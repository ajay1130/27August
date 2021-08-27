package com.example.a27august

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.a27august.databinding.ActivityPermissionBinding
import com.vmadalin.easypermissions.EasyPermissions
import com.vmadalin.easypermissions.dialogs.SettingsDialog

class PermissionActivity : AppCompatActivity(),EasyPermissions.PermissionCallbacks {
    lateinit var binding:ActivityPermissionBinding
    val READ_CONTACT_CODE =1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setVisibility()
        binding.apply {
            buttonPermission.setOnClickListener {
                requestContactReadPermission()
            }
        }

    }
    private fun hasContactReadPermission() =
        EasyPermissions.hasPermissions(
            this,
            Manifest.permission.READ_CONTACTS
        )

    private fun requestContactReadPermission(){
        EasyPermissions.requestPermissions(
            this,
            getString(R.string.denied_permission_text),
            READ_CONTACT_CODE,
            Manifest.permission.READ_CONTACTS
        )
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if(EasyPermissions.somePermissionDenied(this,perms.first())){
            SettingsDialog.Builder(this).build().show()
        }
        else{
            requestContactReadPermission()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        Toast.makeText(
            this,
            getString(R.string.permission_granted),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults,
            this
        )
    }

    private fun setVisibility(){
        binding.apply {
            if(hasContactReadPermission()){
                buttonPermission.isVisible = false
                textPermission.isVisible = true
            }
            else{
                buttonPermission.isVisible = true
                textPermission.isVisible = false
            }
        }
    }


}
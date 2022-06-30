package com.grossova.flighttracker.util

import android.Manifest
import android.content.Context
import android.os.Build
import androidx.fragment.app.Fragment
import com.grossova.flighttracker.util.Constants.PERMISSION_BACKGROUND_LOCATION_REQUEST_CODE
import com.grossova.flighttracker.util.Constants.PERMISSION_LOCATION_REQUEST_CODE
import com.vmadalin.easypermissions.EasyPermissions

object Permissions {

    fun hasLocationPermission(context: Context) =
        EasyPermissions.hasPermissions(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

    fun requestLocationPermission(fragment: Fragment) {
        EasyPermissions.requestPermissions(
            fragment,
            "FlightTracker ke své funkci potřebuje přístup k Vaší poloze.",
            PERMISSION_LOCATION_REQUEST_CODE,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
    }

    fun hasBackgroundLocationPermission(context: Context): Boolean {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            return EasyPermissions.hasPermissions(
                context,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }

        return true
    }

    fun requestBackgroundLocationPermission(fragment: Fragment) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            EasyPermissions.requestPermissions(
                fragment,
                "Ke správné funkci této aplikace je potřeba mít povolený přístup k poloze na pozadí.",
                PERMISSION_BACKGROUND_LOCATION_REQUEST_CODE,
                android.Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }
    }

}
package de.ludklas.forty_two_launcher

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.content.pm.PackageManager

import android.content.pm.ApplicationInfo




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // make the status bar and bottom navigation background completely transparent
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    fun getApps(): List<App> {
        val apps = ArrayList<App>()
        val pm = packageManager
        val packages = pm.getInstalledApplications(0)
        for (pkg in packages){
            val bundleid = pkg.packageName
            val name = pkg.loadLabel(pm).toString()
            val icon = pkg.loadIcon(pm)
            val app = App(name, bundleid,icon)
            apps.add(app)
        }
        return apps
    }


}

data class App(val name: String, val bundleid: String, val icon: Drawable)

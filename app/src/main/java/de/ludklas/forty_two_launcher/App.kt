package de.ludklas.forty_two_launcher

import android.content.Context
import android.graphics.drawable.Drawable

data class App(val name: String, val bundleid: String, val icon: Drawable)

fun App.getApps(context: Context): List<App> {
    val apps = ArrayList<App>()
    val packages = context.packageManager.getInstalledApplications(0)
    for (pkg in packages) {
        val bundleid = pkg.packageName
        val icon = pkg.loadIcon(context.packageManager)
        val name = pkg.loadLabel(context.packageManager).toString()
        val app = App(name, bundleid, icon)
        apps.add(app)
    }
    return apps
}

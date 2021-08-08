package de.ludklas.forty_two_launcher

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable

data class App(val name: String, val bundleid: String, val icon: Drawable, val launchIntent: Intent)

fun getApps(context: Context): Array<App> {
    val apps = ArrayList<App>()
    val packages = context.packageManager.getInstalledApplications(0)
    for (pkg in packages) {
        val bundleid = pkg.packageName
        if (bundleid == context.packageName) continue
        val intent = context.packageManager.getLaunchIntentForPackage(bundleid) ?: continue
        val icon = pkg.loadIcon(context.packageManager)
        val name = pkg.loadLabel(context.packageManager).toString()
        val app = App(name, bundleid, icon, intent)
        apps.add(app)
    }

    return apps.sortedWith(compareBy { it.name }).toTypedArray()
}

fun launchIntent(context: Context, launchIntent: Intent?) {
    if (launchIntent != null) context.startActivity(launchIntent)
}

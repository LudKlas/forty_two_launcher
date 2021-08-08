package de.ludklas.forty_two_launcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var appsAdapter: AppsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // make the status bar and bottom navigation background completely transparent
        // window.setFlags(WindowManager.LayoutParams., WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        initAppsRecyclerView()
    }

    private fun initAppsRecyclerView() {
        val apps = getApps(this)
        val appsRecyclerView = findViewById<RecyclerView>(R.id.app_list)
        appsRecyclerView.layoutManager = LinearLayoutManager(this)
        appsAdapter = AppsAdapter(apps)
        appsRecyclerView.adapter = appsAdapter
    }
}

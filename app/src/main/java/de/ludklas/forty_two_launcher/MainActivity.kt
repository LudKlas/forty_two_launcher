package de.ludklas.forty_two_launcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var appsAdapter: AppsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

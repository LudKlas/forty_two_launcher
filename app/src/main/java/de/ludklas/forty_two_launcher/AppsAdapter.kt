package de.ludklas.forty_two_launcher

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView

class AppsAdapter(private val dataset: Array<App>) :
    RecyclerView.Adapter<AppsAdapter.ViewHolder>() {
    val size = dataset.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.app_name)
        val imageView: ImageView = view.findViewById(R.id.app_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.app_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppsAdapter.ViewHolder, position: Int) {
        holder.textView.text = dataset[position].name
        holder.imageView.setImageDrawable(dataset[position].icon)
        holder.view.setOnClickListener { view: View ->
            launchApp(view.context, dataset[position].bundleid)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}

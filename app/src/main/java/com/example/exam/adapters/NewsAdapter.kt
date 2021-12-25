package com.example.exam.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exam.R
import com.example.exam.fragment.NewsDetailFragment
import com.example.exam.models.NewsModel

class NewsAdapter(
    private val array: List<NewsModel>, val context: FragmentActivity
) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val newsTV = view.findViewById<TextView>(R.id.news_title)
        val newsIV = view.findViewById<ImageView>(R.id.news_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]

        Glide
            .with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.newsIV)

        holder.newsTV.text = item.name

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("news", item)
            context.supportFragmentManager.beginTransaction()
                .replace(R.id.container, NewsDetailFragment::class.java, bundle)
                .addToBackStack(null)
                .commit()
        }

    }

    override fun getItemCount(): Int {
        return array.size
    }

}

package com.example.exam.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.R
import com.example.exam.adapters.CategoryAdapter
import com.example.exam.models.DataBase

class CategoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.category_recyclerview)
        recyclerView.adapter = CategoryAdapter(DataBase.categories, requireActivity())
        return view
    }

}



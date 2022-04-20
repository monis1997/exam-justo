package com.example.justo.view

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.justo.R
import com.example.justo.model.data.Person
import com.example.justo.view.fragment.list.adapter.ItemAdapter

@BindingAdapter("imageUrl")
fun bindImage(
    imgView: ImageView,
    imgUrl: String?
) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading)
            error(R.drawable.error)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<Person>?
) {
    val adapter = recyclerView.adapter as ItemAdapter
    adapter.submitList(data)
    adapter.notifyDataSetChanged()

}
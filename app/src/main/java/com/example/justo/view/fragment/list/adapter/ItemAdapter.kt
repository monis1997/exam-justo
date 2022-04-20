package com.example.justo.view.fragment.list.adapter

import android.media.metrics.PlaybackErrorEvent
import com.example.justo.model.data.Person
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.justo.databinding.ListItemBinding

class ItemAdapter(private val onPersonClicked: (Person, Int) -> Unit) :
    ListAdapter<Person, ItemAdapter.ItemViewHolder>(DiffCallback)
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val personItem = getItem(position)
        holder.bind(personItem)
        holder.itemView.setOnClickListener {
            onPersonClicked(personItem, position)
        }
    }

    class ItemViewHolder(private var binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person) {
            binding.person = person
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.results[0].id == newItem.results[0].id
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.results[0].name.first == newItem.results[0].name.first
        }
    }
}
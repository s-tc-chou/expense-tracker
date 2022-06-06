package com.stevechou.myexpensetracker.summary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stevechou.myexpensetracker.ItemClickListener
import com.stevechou.myexpensetracker.databinding.SummaryItemBinding
import com.stevechou.myexpensetracker.domain.entity.LineItemImpl

class SummaryAdapter(val itemClickListener: ItemClickListener<LineItemImpl>) :
    ListAdapter<LineItemImpl, SummaryAdapter.SummaryViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryViewHolder {
        val binding = SummaryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SummaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return if (currentList.size == 0) {
            0
        } else {
            super.getItemCount()
        }
    }

    inner class SummaryViewHolder(
        private val binding: SummaryItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var data: LineItemImpl

        init {
            itemView.setOnClickListener {
                itemClickListener.onItemClicked(data)
            }
        }

        fun bindView(lineItemImpl: LineItemImpl) {
            data = lineItemImpl
            binding.apply {
                itemName.text = lineItemImpl.name
                itemAmount.text = lineItemImpl.amount.toString()
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<LineItemImpl>() {
        override fun areItemsTheSame(oldItem: LineItemImpl, newItem: LineItemImpl): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: LineItemImpl, newItem: LineItemImpl): Boolean {
            return oldItem == newItem
        }
    }
}

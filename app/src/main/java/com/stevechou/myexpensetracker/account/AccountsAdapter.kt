package com.stevechou.myexpensetracker.account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stevechou.myexpensetracker.ItemClickListener
import com.stevechou.myexpensetracker.databinding.AccountItemBinding
import com.stevechou.myexpensetracker.domain.entity.AccountImpl

class AccountsAdapter(val itemClickListener: ItemClickListener<AccountImpl>) :
    ListAdapter<AccountImpl, AccountsAdapter.AccountsViewHolder>(AccountDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountsViewHolder {
        val binding = AccountItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AccountsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindView(item)
    }

    inner class AccountsViewHolder(
        private val binding: AccountItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var data: AccountImpl

        init {
            itemView.setOnClickListener {
                itemClickListener.onItemClicked(data)
            }
        }

        fun bindView(AccountImpl: AccountImpl) {
            data = AccountImpl
            binding.apply {
                accountName.text = AccountImpl.name
            }
        }
    }

    class AccountDiffCallback : DiffUtil.ItemCallback<AccountImpl>() {
        override fun areItemsTheSame(oldItem: AccountImpl, newItem: AccountImpl): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AccountImpl, newItem: AccountImpl): Boolean {
            return oldItem == newItem
        }
    }

    override fun getItemCount(): Int {
        return if (currentList.size == 0) {
            0
        } else {
            super.getItemCount()
        }
    }
}
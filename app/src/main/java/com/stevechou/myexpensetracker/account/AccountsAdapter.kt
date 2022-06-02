package com.stevechou.myexpensetracker.account

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stevechou.myexpensetracker.ItemClickListener
import com.stevechou.myexpensetracker.databinding.AccountItemBinding
import com.stevechou.myexpensetracker.domain.entity.Account

class AccountsAdapter(val itemClickListener: ItemClickListener<Account>) :
    ListAdapter<Account, AccountsAdapter.AccountsViewHolder>(AccountDiffCallback()) {

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

        private lateinit var data : Account

        init {
            itemView.setOnClickListener {
                itemClickListener.onItemClicked(data)
            }
        }
        fun bindView(account: Account) {
            data = account
            binding.apply {
                accountName.text = account.name
            }
        }
    }

    class AccountDiffCallback : DiffUtil.ItemCallback<Account>() {
        override fun areItemsTheSame(oldItem: Account, newItem: Account): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Account, newItem: Account): Boolean {
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
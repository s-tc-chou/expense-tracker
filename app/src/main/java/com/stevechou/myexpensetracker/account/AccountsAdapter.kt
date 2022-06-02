package com.stevechou.myexpensetracker.account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stevechou.myexpensetracker.databinding.AccountItemBinding
import com.stevechou.myexpensetracker.domain.entity.Account

class AccountsAdapter :
    ListAdapter<Account, AccountsAdapter.AccountsViewHolder>(AccountDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountsViewHolder {
        val binding = AccountItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AccountsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindView(item)
    }

    class AccountsViewHolder(
        private val binding: AccountItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(account: Account) {
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
package com.stevechou.myexpensetracker.summary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stevechou.myexpensetracker.databinding.SummaryItemBinding

// TODO: make into list adapter so we can use diffutil.
class SummaryAdapter : RecyclerView.Adapter<SummaryAdapter.SummaryViewHolder>() {


    class SummaryViewHolder(
        private val binding: SummaryItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private fun bindExpense() {
            //TODO
        }

        private fun bindCashFlow() {
            //TODO
        }

        // add data class to wrap these 2?
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryViewHolder {
        val binding = SummaryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SummaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    //TODO: add diffCallBack
}
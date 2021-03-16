package com.stevechou.myexpensetracker.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.stevechou.myexpensetracker.databinding.FragmentAccountsBinding

class AccountsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAccountsBinding.inflate(layoutInflater)
            .apply {
                val accountsAdapter = AccountsAdapter()
                val manager = GridLayoutManager(activity, 3)
                accountsList.adapter = accountsAdapter
                accountsList.layoutManager = manager
            }

         return binding.root
    }

}
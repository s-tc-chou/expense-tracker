package com.stevechou.myexpensetracker.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.stevechou.myexpensetracker.databinding.FragmentAccountsBinding

class AccountsFragment : Fragment() {

    private var _binding : FragmentAccountsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountsBinding.inflate(layoutInflater, container, false)
            .apply {
                val accountsAdapter = AccountsAdapter()
                val manager = GridLayoutManager(activity, 3)
                accountsList.adapter = accountsAdapter
                accountsList.layoutManager = manager
            }

         return binding.root
    }

    // need to set on click action in the adapter to use nav controller to navigate to fragment.

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
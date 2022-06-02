package com.stevechou.myexpensetracker.account

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.stevechou.myexpensetracker.R
import com.stevechou.myexpensetracker.Utils.provideViewModel
import com.stevechou.myexpensetracker.databinding.FragmentAccountsBinding
import com.stevechou.myexpensetracker.databinding.FragmentAddAccountBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AccountsFragment : Fragment() {
    private var _binding: FragmentAccountsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AccountsViewModel by provideViewModel()
    internal val adapter = AccountsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountsBinding.inflate(layoutInflater, container, false)
            .apply {
                val manager = GridLayoutManager(activity, 3)
                accountsList.adapter = adapter
                accountsList.layoutManager = manager
            }

        binding.addNewUser.setOnClickListener {
            AddAccountDialogFragment().show(
                parentFragmentManager,
                AddAccountDialogFragment::class.simpleName
            )
            viewModel.createAccount("test")
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchAccounts()
        viewLifecycleOwner.lifecycleScope.launch {

        }
        viewModel.accounts.observe(viewLifecycleOwner) { adapter.submitList(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
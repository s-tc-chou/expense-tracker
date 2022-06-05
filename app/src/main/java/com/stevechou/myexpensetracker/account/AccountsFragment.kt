package com.stevechou.myexpensetracker.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.stevechou.myexpensetracker.ItemClickListener
import com.stevechou.myexpensetracker.Utils.provideViewModel
import com.stevechou.myexpensetracker.databinding.FragmentAccountsBinding
import com.stevechou.myexpensetracker.domain.entity.AccountImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountsFragment : Fragment() {
    private var _binding: FragmentAccountsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AccountsViewModel by provideViewModel()
    private val listener = object : ItemClickListener<AccountImpl> {
        override fun onItemClicked(item: AccountImpl) {
            val action = AccountsFragmentDirections.actionAccountsFragmentToSummaryFragment(item)
            findNavController().navigate(action)
        }

    }
    internal val adapter = AccountsAdapter(listener)

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
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchAccounts()
        viewModel.accounts.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
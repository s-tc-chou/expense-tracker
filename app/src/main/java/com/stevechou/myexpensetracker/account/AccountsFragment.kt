package com.stevechou.myexpensetracker.account

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.stevechou.myexpensetracker.R
import com.stevechou.myexpensetracker.databinding.FragmentAccountsBinding
import com.stevechou.myexpensetracker.databinding.FragmentAddAccountBinding

class AccountsFragment : Fragment() {

    private var _binding: FragmentAccountsBinding? = null
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

        val dialogView = FragmentAddAccountBinding.inflate(layoutInflater)
        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.enter_user_name))
            .setPositiveButton(getString(R.string.save)) { dialog, _ ->
                //TODO: replace with viewmodel call to create account
                // should create account, then you can click on the recycler view item
                // which should navigate you to summaryFragment.
                Toast.makeText(context, "Saving", LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .setView(dialogView.root)
            .create()

        binding.addNewUser.setOnClickListener {
            dialogBuilder.show()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
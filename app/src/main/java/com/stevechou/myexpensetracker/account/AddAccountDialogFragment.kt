package com.stevechou.myexpensetracker.account

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.stevechou.myexpensetracker.R
import com.stevechou.myexpensetracker.Utils.provideViewModel
import com.stevechou.myexpensetracker.databinding.FragmentAddAccountBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddAccountDialogFragment : DialogFragment() {
    private var _binding: FragmentAddAccountBinding? = null
    private val binding get() = _binding!!
    private val accountsViewModel: AccountsViewModel by provideViewModel()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = FragmentAddAccountBinding.inflate(layoutInflater)

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.create_user_title))
            .setPositiveButton(getString(R.string.save)) { dialog, _ ->
                accountsViewModel.createAccount(binding.userNameInput.text.toString())
                dialog.dismiss()

            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .setView(binding.root)
            .create()

        binding.userNameLayout.requestFocus()
        return dialog
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
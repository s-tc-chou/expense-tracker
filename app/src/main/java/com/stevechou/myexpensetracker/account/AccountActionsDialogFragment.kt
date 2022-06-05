package com.stevechou.myexpensetracker.account

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.stevechou.myexpensetracker.Utils.provideViewModel
import com.stevechou.myexpensetracker.databinding.DialogFragmentAccountActionsBinding
import com.stevechou.myexpensetracker.domain.entity.AccountImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountActionsDialogFragment : DialogFragment() {

    private var _binding: DialogFragmentAccountActionsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AccountsViewModel by provideViewModel()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogFragmentAccountActionsBinding.inflate(layoutInflater)

        setupClickListeners()

        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .create()
    }

    private fun setupClickListeners() {
        // is there a way to pass this around fragments better?
        val args = requireArguments().get("arg_account") as AccountImpl

        binding.viewAccount.setOnClickListener {
            val action =
                AccountActionsDialogFragmentDirections.actionAccountActionsDialogFragmentToSummaryFragment(
                    args
                )
            findNavController().navigate(action)
        }

        binding.deleteAccount.setOnClickListener {
            // is there a better approach?
            AlertDialog.Builder(requireContext())
                .setPositiveButton("Are you sure?") { _, _ ->
                    viewModel.deleteAccount(args)
                    dismiss()
                }
                .setNegativeButton("Cancel") { _, _ -> dismiss() }
                .create()
                .show()
        }

        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
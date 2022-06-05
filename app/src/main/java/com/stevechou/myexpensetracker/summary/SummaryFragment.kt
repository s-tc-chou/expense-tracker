package com.stevechou.myexpensetracker.summary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.leinardi.android.speeddial.SpeedDialActionItem
import com.stevechou.myexpensetracker.R
import com.stevechou.myexpensetracker.databinding.FragmentSummaryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SummaryFragment : Fragment() {

    private var _binding: FragmentSummaryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSummaryBinding.inflate(layoutInflater, container, false)

        setupSpeedDial()
        val args = requireArguments().get("arg_account")

        return binding.root
    }

    private fun setupSpeedDial() {

        val speedDial = binding.speedDial
        speedDial.addActionItem(
            SpeedDialActionItem.Builder(R.id.fab_cash_flow, R.drawable.ic_cash_flow)
                .setFabBackgroundColor(ResourcesCompat.getColor(resources, R.color.cash_flow_green, requireActivity().theme))
                .setLabel(resources.getString(R.string.fab_add_cash_flow))
                .create()
        )
        speedDial.addActionItem(
            SpeedDialActionItem.Builder(R.id.fab_expense, R.drawable.ic_expense)
                .setFabBackgroundColor(ResourcesCompat.getColor(resources, R.color.expense_red, requireActivity().theme))
                .setLabel(resources.getString(R.string.fab_add_expense))
                .create()
        )

        speedDial.setOnActionSelectedListener {
            when (it.id) {
                R.id.fab_cash_flow -> {
                    Toast.makeText(context, "cash flow clicked", LENGTH_SHORT).show()
                    speedDial.close()
                    return@setOnActionSelectedListener true
                }
                R.id.fab_expense -> {
                    Toast.makeText(context, "expense clicked", LENGTH_SHORT).show()
                    speedDial.close()
                    return@setOnActionSelectedListener true
                }
            }
            false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
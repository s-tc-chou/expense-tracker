package com.stevechou.myexpensetracker.summary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.stevechou.myexpensetracker.account.AccountsAdapter
import com.stevechou.myexpensetracker.databinding.FragmentSummaryBinding

class SummaryFragment : Fragment() {

    private var _binding: FragmentSummaryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSummaryBinding.inflate(layoutInflater, container, false)
            .apply {
                // temporarily use Account Adapter instead for testing.
//                val summaryAdapter = SummaryAdapter()
//                val summaryAdapter = AccountsAdapter()
                val manager = GridLayoutManager(activity, 3)
//                summaryList.adapter = summaryAdapter
                summaryList.layoutManager = manager
            }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
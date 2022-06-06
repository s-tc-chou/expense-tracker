package com.stevechou.myexpensetracker.summary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stevechou.myexpensetracker.domain.entity.LineItemImpl
import com.stevechou.myexpensetracker.domain.entity.Frequency
import com.stevechou.myexpensetracker.domain.usecase.CreateExpense
import com.stevechou.myexpensetracker.domain.usecase.DeleteExpense
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SummaryViewModel @Inject constructor(
    private val createExpense: CreateExpense,
    private val deleteExpense: DeleteExpense
) : ViewModel() {

    lateinit var accountId: String
    private val _summary = MutableLiveData<List<Summary>>()
    val summary get() = _summary

    // TODO: fetch current account id automatically.
    fun createNewExpense(name: String) {
        // create a test expense for now.
        val expense = LineItemImpl(
            UUID.randomUUID().toString(),
            name,
            420.69f,
            Frequency.MONTHLY,
            accountId,
            occurrenceDate = Date(System.currentTimeMillis())
        )
        viewModelScope.launch(Dispatchers.IO) {
            createExpense.execute(expense)
        }
    }
}

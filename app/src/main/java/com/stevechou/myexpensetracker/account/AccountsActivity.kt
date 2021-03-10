package com.stevechou.myexpensetracker.account

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.stevechou.myexpensetracker.databinding.AccountsActivityBinding
import dagger.hilt.android.AndroidEntryPoint


//Account selector -> view of your account
@AndroidEntryPoint
class AccountsActivity : AppCompatActivity() {

    private lateinit var binding: AccountsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AccountsActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val viewModel: AccountsViewModel =
            ViewModelProvider(this).get(AccountsViewModel::class.java)

        binding.testTextField.text = viewModel.test()
        binding.getAccount.setOnClickListener {
            viewModel.getTestAccount()
                /*.also {
                    Toast.makeText(this, it, Toast.LENGTH_LONG).show()
                }*/
        }
    }

}
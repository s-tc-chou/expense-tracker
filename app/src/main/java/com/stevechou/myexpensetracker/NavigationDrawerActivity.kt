package com.stevechou.myexpensetracker

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.stevechou.myexpensetracker.account.AccountsFragment
import com.stevechou.myexpensetracker.databinding.NavigationDrawerActivityBinding
import dagger.hilt.android.AndroidEntryPoint


//Account selector -> view of your account -> On select, inflate fragment.
@AndroidEntryPoint
class NavigationDrawerActivity : AppCompatActivity() {

    private lateinit var binding: NavigationDrawerActivityBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NavigationDrawerActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        drawer = binding.drawerLayout
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val toolbar: Toolbar = findViewById(R.id.app_toolbar)
        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(
            this,
            drawer,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)

        supportFragmentManager.beginTransaction()
            .add(R.id.nav_host_fragment, AccountsFragment())
            .commit()

//        val viewModel: AccountsViewModel = ViewModelProvider(this).get(AccountsViewModel::class.java)

//        binding.testTextField.text = viewModel.test()
//        binding.getAccount.setOnClickListener {
//            viewModel.getTestAccount()
        /*.also {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }*/
//        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true

        return super.onOptionsItemSelected(item)
    }
}
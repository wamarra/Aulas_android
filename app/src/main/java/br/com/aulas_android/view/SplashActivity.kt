package br.com.aulas_android.view

import android.content.Intent
import android.os.Bundle
import br.com.aulas_android.R
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.aulas_android.model.SplashRepository
import br.com.aulas_android.viewmodel.SplashViewModel

class SplashActivity : AppCompatActivity() {
    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel = ViewModelProvider(this, SplashViewModel.SplashViewModelFactory(SplashRepository()))
            .get(SplashViewModel::class.java)

        viewModel.authenticatedUserLiveData.observe(this) { user ->
            if (user != null) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(MainActivity.USER_EXTRA, user)

                startActivity(intent)
                finish()
            } else {
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.checkIfUserIsAuthenticated()
    }
}
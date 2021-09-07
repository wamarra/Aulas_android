package br.com.aulas_android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import br.com.aulas_android.R
import br.com.aulas_android.databinding.ActivityMainBinding
import br.com.aulas_android.model.Address
import br.com.aulas_android.model.MainRepository
import br.com.aulas_android.model.User
import br.com.aulas_android.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    companion object {
        val USER_EXTRA = "user"
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE)
        val name = sharedPreferences.getString("user", "Outro")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.user = User(uid = "1", name = name) // intent.getSerializableExtra(USER_EXTRA) as User

        viewModel = ViewModelProvider(this, MainViewModel.MainViewModelFactory(MainRepository()))
            .get(MainViewModel::class.java)

        viewModel.requestError.observe(this) { wrapper ->
            wrapper.getContentIfNotHandled()?.let { errorMessage ->
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()

        var button = findViewById<Button>(R.id.btn_get_address_by_cep)

        button.setOnClickListener{
            var cep = findViewById<EditText>(R.id.et_cep)

            viewModel.getAddressByCep(cep.text.toString())

            binding.address = viewModel.address
        }
    }
}
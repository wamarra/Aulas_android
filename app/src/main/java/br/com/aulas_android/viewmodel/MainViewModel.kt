package br.com.aulas_android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import br.com.aulas_android.model.Address
import br.com.aulas_android.model.EventWrapper
import br.com.aulas_android.model.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    var address: Address? = null
    val requestError = MutableLiveData<EventWrapper<String>>()

    fun getAddressByCep(cep: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getAddressByCep(cep)

                if (response.isSuccessful) {
                    address = response.body()
                } else {
                    withContext(Dispatchers.Main) {
                        requestError.value = EventWrapper("Erro ao atualizar os dados")
                    }
                }
            } catch (error: Exception) {
                withContext(Dispatchers.Main) {
                    print(error.message)
                    requestError.value = EventWrapper("Erro ao atualizar os dados")
                }
            }
        }
    }

    class MainViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }
    }
}

package br.com.aulas_android.model

import androidx.lifecycle.LiveData
import br.com.aulas_android.MyApplication
import br.com.aulas_android.network.ViaCepAPI
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type

class MainRepository {

    private val api: ViaCepAPI = Retrofit.Builder()
        .baseUrl("https://viacep.com.br/ws/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ViaCepAPI::class.java)

    suspend fun getAddressByCep(cep: String): Response<Address> {
        return api.getAddressByCep(cep)
    }
}
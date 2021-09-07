package br.com.aulas_android.network

import br.com.aulas_android.model.Address
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepAPI {

    @GET("{cep}/json/")
    suspend fun getAddressByCep(@Path("cep", encoded = true) cep: String): Response<Address>
}
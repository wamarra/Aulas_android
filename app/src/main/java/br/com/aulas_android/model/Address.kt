package br.com.aulas_android.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Address")
data class Address(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "cep")
    @SerializedName("cep") val cep: String = "",

    @ColumnInfo(name = "logradouro")
    @SerializedName("logradouro") val logradouro: String = "",

    @ColumnInfo(name = "complemento")
    @SerializedName("complemento") val complemento: String = "",

    @ColumnInfo(name = "bairro")
    @SerializedName("bairro") val bairro: String = "",

    @ColumnInfo(name = "localidade")
    @SerializedName("localidade") val localidade: String = "",

    @ColumnInfo(name = "uf")
    @SerializedName("uf") val uf: String = "",

    @ColumnInfo(name = "ibge")
    @SerializedName("ibge") val ibge: String = "",

    @ColumnInfo(name = "gia")
    @SerializedName("gia") val gia: String = "",

    @ColumnInfo(name = "ddd")
    @SerializedName("ddd") val ddd: String = "",

    @ColumnInfo(name = "siafi")
    @SerializedName("siafi") val siafi: String = ""
)

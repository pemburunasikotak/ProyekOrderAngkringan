package tj.belajar.orang.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataRepository {
    fun create(): ServiceMakan {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://localhost/PBM/")
            .build()
        return retrofit.create(ServiceMakan::class.java)
    }

}
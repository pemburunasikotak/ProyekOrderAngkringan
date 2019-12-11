package tj.belajar.orang.API

import retrofit2.Call
import retrofit2.http.GET

interface ServiceMakan {
    @GET("lihatdata")
    fun getPosts(): Call<List<ModelMakan>>
}
package tj.belajar.orang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import retrofit2.Call
import retrofit2.Response
import tj.belajar.orang.API.DataRepository
import tj.belajar.orang.API.ModelMakan
import tj.belajar.orang.API.ServiceMakan
import tj.belajar.orang.makan.MenuMakanan
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    lateinit var btnmakan : Button
    lateinit var btnminum : Button

    lateinit var btnlogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Fungsi Tombol Intent

        btnlogin= findViewById(R.id.btnLogin)
        btnlogin.setOnClickListener{
            val masuk:Intent = Intent(this, MenuMakanan::class.java)
            startActivity(masuk)
        }

        //fungsi untuk Retrofit
        val postServices = DataRepository.create()
        ServiceMakan.getPosts.enqueue(object : Callback<List<ModelMakan>> {

            override fun onResponse(call: Call<List<ModelMakan>>, response: Response<List<ModelMakan>>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("tag", "responsennya ${data?.size}")

                    data?.map {
                        Log.d("tag", "datanya ${it.body}")
                    }
                }
            }

            override fun onFailure(call: Call<List<ModelMakan>>, error: Throwable) {
                Log.e("tag", "errornya ${error.message}")
            }

    }
}

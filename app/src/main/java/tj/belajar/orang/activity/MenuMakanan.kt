package tj.belajar.orang.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_menu_makan.*
import tj.belajar.orang.R
import tj.belajar.orang.adapter.AdapterMakanan
import tj.belajar.orang.interfaces.onGetResponse
import tj.belajar.orang.model.StaticVariabel
import tj.belajar.orang.model.makan.AllMakanan
import tj.belajar.orang.model.makan.Makanan
import tj.belajar.orang.task.TaskGetRequest

class MenuMakanan: AppCompatActivity() {

    lateinit var context: Context
    private var list:ArrayList<Makanan> = ArrayList()
    lateinit var listMakanan : AdapterMakanan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_makan)
        initWidget()
    }

    fun initWidget(){

        context = this@MenuMakanan

        rv_menu.setHasFixedSize(true)

        btnMinuman.setOnClickListener{
            startActivity(Intent(this, MenuMinuman::class.java))
            finish()
        }

        showRecyleView()

        TaskGetRequest("${StaticVariabel.baseURL}api/all_makanan.php",object : onGetResponse {
            override fun onError(message: String) {
                Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
            }
            override fun onGetData(body : String) {
                try {
                    val data = Gson().fromJson<AllMakanan>(body, AllMakanan::class.java)
                    list.clear()
                    list.addAll(data.data)
                    listMakanan.notifyDataSetChanged()

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }).execute()
    }

    private fun showRecyleView() {
        listMakanan = AdapterMakanan(list)
        rv_menu.adapter = listMakanan
        rv_menu.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }
}
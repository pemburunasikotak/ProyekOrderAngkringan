package tj.belajar.orang.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_menu_makan.*
import tj.belajar.orang.R
import tj.belajar.orang.adapter.AdapterMakanan
import tj.belajar.orang.interfaces.onGetAllDataMakanan
import tj.belajar.orang.model.StaticVariabel
import tj.belajar.orang.model.makan.Makanan
import tj.belajar.orang.model.makan.dataMakanan
import tj.belajar.orang.task.TaskGetAllMakanan
import tj.belajar.orang.task.TaskGetAllMakananAsc

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

        TaskGetAllMakananAsc("${StaticVariabel.baseURL}api/all_makanan.php",object : onGetAllDataMakanan {
            override fun onError(message: String) {
                Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
            }
            override fun onGetData(dataAll: ArrayList<Makanan>) {
                list.clear()
                list.addAll(dataAll)
                listMakanan.notifyDataSetChanged()
            }
        }).execute()
    }

    private fun showRecyleView() {
        listMakanan = AdapterMakanan(list)
        rv_menu.adapter = listMakanan
        rv_menu.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }
}
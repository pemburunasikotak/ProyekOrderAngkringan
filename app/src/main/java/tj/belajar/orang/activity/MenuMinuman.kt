package tj.belajar.orang.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_menu_makan.*
import tj.belajar.orang.R
import tj.belajar.orang.adapter.AdapterMakanan
import tj.belajar.orang.adapter.AdapterMinuman
import tj.belajar.orang.model.makan.Makanan
import tj.belajar.orang.model.makan.dataMakanan
import tj.belajar.orang.model.minum.Minuman

class MenuMinuman : AppCompatActivity() {

    lateinit var context: Context
    private var list : ArrayList<Minuman> = ArrayList()
    lateinit var listMakanan : AdapterMinuman

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_makan)
        initWidget()
    }

    fun initWidget(){

        context = this@MenuMinuman
        rv_menu.setHasFixedSize(true)

        btnMinuman.setOnClickListener{
            startActivity(Intent(this, MenuMinuman::class.java))
            finish()
        }

        showRecyleView()
    }

    private fun showRecyleView() {
        listMakanan = AdapterMinuman(list)
        rv_menu.adapter = listMakanan
        rv_menu.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }
}
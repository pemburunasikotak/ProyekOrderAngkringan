package tj.belajar.orang.makan

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tj.belajar.orang.minum.MenuMinuman
import tj.belajar.orang.R


class MenuMakanan: AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    lateinit var btnmakan:Button

    private var list:ArrayList<Makanan> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_makan)


        //Fungsi RecyleVie

        recyclerView = findViewById(R.id.rv_menu)
        recyclerView.setHasFixedSize(true)

        list.addAll(dataMakanan.listData)
        showRecyleView()

        btnmakan = findViewById(R.id.btnMinuman)
        btnmakan.setOnClickListener{
            val makan: Intent = Intent(this, MenuMinuman::class.java)
            startActivity(makan)
        }

    }

    private fun showRecyleView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listMakanan = AdapterMakanan(list)
        recyclerView.adapter = listMakanan
    }

    /** Called when the user taps the Send button  */
    fun sendMessage(view: View) {
        // Do something in response to button
    }
}
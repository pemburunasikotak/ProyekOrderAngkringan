package tj.belajar.orang

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MenuMakanan: AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private var list:ArrayList<Makanan> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        //Fungsi RecyleVie

        recyclerView = findViewById(R.id.rv_menu)
        recyclerView.setHasFixedSize(true)

        list.addAll(dataMakanan.listData)
        showRecyleView()




        //tambah data


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
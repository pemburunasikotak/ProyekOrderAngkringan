package tj.belajar.orang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import tj.belajar.orang.makan.MenuMakanan

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

    }
}

package tj.belajar.orang.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tj.belajar.orang.R

class MainActivity : AppCompatActivity() {
    lateinit var context :Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWidget()
    }

    fun initWidget(){
        this.context = this@MainActivity
        btnLogin.setOnClickListener {
            startActivity(Intent(this, MenuMakanan::class.java))
            finish()
        }
    }
}

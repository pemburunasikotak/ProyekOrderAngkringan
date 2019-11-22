package tj.belajar.orang.makan

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import tj.belajar.orang.R

class AdapterMakanan(private val makanadapter: ArrayList<Makanan>):RecyclerView.Adapter<AdapterMakanan.MyViewHolder>(){

    lateinit var btnmakan : Button

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MyViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_menuminum, viewGroup, false)
        return MyViewHolder(view)



    }

    override fun getItemCount()= makanadapter.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val data = makanadapter[position]
        holder.tvName.text  = data.nama
        holder.tvDetail.text = data.harga
        Glide.with(holder.item.context)
            .load(data.image)
            .override(97,140)
            .apply(RequestOptions())
            .into(holder.imgPhoto)
    }


    //class  yang harus dibuat ketika membuat extend
    inner class MyViewHolder(val item:View):RecyclerView.ViewHolder(item) {

        var tvName: TextView = item.findViewById(R.id.textJudul)
        var tvDetail: TextView = item.findViewById(R.id.tvharga)
        var imgPhoto: ImageView = item.findViewById(R.id.imageView)

    }

}
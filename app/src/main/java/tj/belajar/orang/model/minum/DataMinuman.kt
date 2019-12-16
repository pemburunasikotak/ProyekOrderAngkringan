package tj.belajar.orang.model.minum

import tj.belajar.orang.R
import tj.belajar.orang.model.makan.Makanan

object DataMinuman {

    object dataMakanan {
        private val namaMakanan = arrayOf("Sego Pecel",
            "Orak Arik","Sego tiwul","Nasi Goreng","Bakwan")

        private val hargaMakanan = arrayOf("3000","4000","4000","4000","4000")

        private val imageMakanan = intArrayOf(
            R.drawable.pesan,
            R.drawable.logo,
            R.drawable.pesan,
            R.drawable.logo,
            R.drawable.logo
        )


        val listData: ArrayList<Makanan>
            get() {
                val list = arrayListOf<Makanan>()
                for (position in namaMakanan.indices) {
                    val makan = Makanan()
                    makan.nama = namaMakanan[position]
                    makan.harga = hargaMakanan[position]
                    //makan.image = imageMakanan[position]
                    list.add(makan)
                }
                return list
            }

    }
}
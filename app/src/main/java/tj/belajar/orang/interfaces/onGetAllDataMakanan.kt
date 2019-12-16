package tj.belajar.orang.interfaces

import tj.belajar.orang.model.makan.Makanan

interface onGetAllDataMakanan {
    fun onError(message : String)
    fun onGetData(listMakanan : ArrayList<Makanan>)
}
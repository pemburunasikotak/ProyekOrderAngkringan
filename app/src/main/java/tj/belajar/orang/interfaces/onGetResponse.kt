package tj.belajar.orang.interfaces

import tj.belajar.orang.model.makan.Makanan

interface onGetResponse {
    fun onError(message : String)
    fun onGetData(body : String)
}
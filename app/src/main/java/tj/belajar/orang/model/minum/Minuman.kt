package tj.belajar.orang.model.minum

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Minuman : Serializable {

    @SerializedName("id")
    var id = 0

    @SerializedName("nama_minum")
    var namaMinum : String= ""

    @SerializedName("harga_minum")
    var hargaMinum : String = ""

    @SerializedName("gambar_minum")
    var gambarMinum : Int = 0
}
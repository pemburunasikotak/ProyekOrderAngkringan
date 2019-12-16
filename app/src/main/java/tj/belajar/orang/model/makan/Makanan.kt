package tj.belajar.orang.model.makan

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Makanan : Serializable {

    @SerializedName("id")
    var id : Int = 0

    @SerializedName("nama")
    var nama : String = ""

    @SerializedName("harga")
    var harga : String = ""

    @SerializedName("image")
    var image : String = ""
}
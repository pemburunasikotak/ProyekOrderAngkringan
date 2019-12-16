package tj.belajar.orang.model.makan

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class AllMakanan :Serializable {
    
    @SerializedName("data")
    var data = ArrayList<Makanan>()

    @SerializedName("error")
    var error = ""
}
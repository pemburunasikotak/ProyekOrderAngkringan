package tj.belajar.orang.task

import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import tj.belajar.orang.interfaces.onGetAllDataMakanan
import tj.belajar.orang.model.makan.AllMakanan

class TaskGetAllMakananAsc :AsyncTask<Void,Void,String> {

    lateinit var Url : String
    lateinit var onGetAllDataMakanan : onGetAllDataMakanan
    var error = ""

    constructor(Url: String, onGetAllDataMakanan: onGetAllDataMakanan) {
        this.Url = Url
        this.onGetAllDataMakanan = onGetAllDataMakanan
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Void?): String {
        var body = ""
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(this.Url)
            .get()
            .build()

        try {
            val response = client.newCall(request).execute()
            body = response.body!!.string()

        } catch (e: Exception) {
            e.printStackTrace()
            error += e.message!!
        }

        return body
    }


    override fun onPostExecute(body: String) {
        super.onPostExecute(body)
        try {

            Log.e("response",body)
            val data = Gson().fromJson<AllMakanan>(body, AllMakanan::class.java)
            if (data.error != ""){
                onGetAllDataMakanan.onError(data.error)
                return
            }
            onGetAllDataMakanan.onGetData(data.data)

        } catch (e: Exception) {
            e.printStackTrace()
            error += e.message!!
            Log.e("response_error",error)
            onGetAllDataMakanan.onError(error)
        }
    }
}
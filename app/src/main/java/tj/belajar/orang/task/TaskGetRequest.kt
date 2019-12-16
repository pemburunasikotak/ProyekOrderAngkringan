package tj.belajar.orang.task

import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import tj.belajar.orang.interfaces.onGetResponse
import tj.belajar.orang.model.makan.AllMakanan

class TaskGetRequest :AsyncTask<Void,Void,String> {

    lateinit var Url : String
    lateinit var onGetResponse : onGetResponse
    var error = ""

    constructor(Url: String, onGetResponse: onGetResponse) {
        this.Url = Url
        this.onGetResponse = onGetResponse
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
        if (error != ""){
            onGetResponse.onError(error)
            return
        }
        onGetResponse.onGetData(body)
    }
}
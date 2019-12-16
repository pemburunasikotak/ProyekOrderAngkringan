package tj.belajar.orang.task

import android.os.AsyncTask
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import tj.belajar.orang.interfaces.onGetResponse

class TaskPostRequest : AsyncTask<Void, Void, String> {

    lateinit var Url : String
    lateinit var requestBody: RequestBody
    lateinit var onGetResponse : onGetResponse
    var error = ""

    constructor(Url: String, requestBody: RequestBody, onGetResponse: onGetResponse) : super() {
        this.Url = Url
        this.requestBody = requestBody
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
            .post(requestBody)
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
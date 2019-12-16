package tj.belajar.orang.task

import android.util.Log
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import tj.belajar.orang.interfaces.onGetAllDataMakanan
import tj.belajar.orang.model.makan.AllMakanan


class TaskGetAllMakanan {

    lateinit var Url : String
    lateinit var onGetAllDataMakanan : onGetAllDataMakanan

    constructor(Url: String, onGetAllDataMakanan: onGetAllDataMakanan) {
        this.Url = Url
        this.onGetAllDataMakanan = onGetAllDataMakanan
    }


    fun getAllMakanan(){

        val client = OkHttpClient()
        val request = Request.Builder()
            .url(this.Url)
            .get()
            //.addHeader("application/json", "charset=utf-8")
            .build()

        Observable.create(ObservableOnSubscribe<Response> { subscriber ->
            try {
                val response = client.newCall(request).execute()
                Log.e("response",response.body!!.string())
                subscriber.onNext(response)
                subscriber.onComplete()
            } catch (e: Exception) {
                e.printStackTrace()
                subscriber.onError(e)
            }

        }).subscribe(object : Observer<Response> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(s: Response) {
                    try {
                        val body = s.body!!.string()
                        Log.e("response",body)
                        val data = Gson().fromJson<AllMakanan>(body,AllMakanan::class.java)
                        if (data.error != ""){
                            onGetAllDataMakanan.onError(data.error)
                            return
                        }
                        onGetAllDataMakanan.onGetData(data.data)

                    } catch (e: Exception) {
                        e.printStackTrace()
                        onGetAllDataMakanan.onError(e.message!!)
                        Log.e("response_error",e.message!!)
                    }
                }

                override fun onError(e: Throwable) {
                    if (e.message != null)
                        onGetAllDataMakanan.onError(e.message!!)
                }

                override fun onComplete() {

                }
            })
    }
}
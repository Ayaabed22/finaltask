package com.example.application.MVVM

import android.provider.ContactsContract
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.application.Api.RetrofitClient
import com.example.application.DataModel
import com.example.application.Logindata
import com.example.application.R
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class viewModelUser :ViewModel() {
    lateinit var email: TextView
    lateinit var password: TextView

    var errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorLiveData: LiveData<String>
        get() = errorMessage

    lateinit var CreateuserLiveData: MutableLiveData<Logindata?>

    init {
        CreateuserLiveData = MutableLiveData()
    }

    fun getCreateneyUserObserver(): MutableLiveData<Logindata> {
        return getCreateneyUserObserver()
    }

    fun CreateUser(logindata: Logindata) {
        email.text.toString()
        password.text.toString()

        val retrofit = RetrofitClient().apiCalls()
        val call = retrofit.login(Logindata())

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        if (response != null) {
                            CreateuserLiveData.postValue(logindata)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                error(errorMessage.postValue(t?.message))

            }


        })
    }
}








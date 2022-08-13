package com.example.application.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.application.Api.RetrofitClient
import com.example.application.Data
import com.example.application.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class viewModeProduct:ViewModel() {


    var getMD: MutableLiveData<ArrayList<Data>?> = MutableLiveData()
    val getLiveData: MutableLiveData<ArrayList<Data>?>
        get() = getMD

    var errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorLiveData: LiveData<String>
        get() = errorMessage

fun getMyProducts() {
    RetrofitClient().apiCalls().getproducts().enqueue(object : Callback<DataModel> {
        override fun onResponse(call: Call<DataModel>?, response: Response<DataModel>?
        ) {
            if (response != null) {
                if (response.isSuccessful){
                    if (response != null) {
                        getMD.postValue(response.body().data as ArrayList<Data>?)
                    }
                }
            }

        }

        override fun onFailure(call: Call<DataModel>?, t: Throwable?) {

           errorMessage.postValue(t?.message)
        }

    })

}



        }

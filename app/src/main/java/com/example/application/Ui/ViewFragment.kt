package com.example.application.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.application.Api.RetrofitClient
import com.example.application.Data
import com.example.application.DataModel
import com.example.application.MVVM.viewModeProduct
import com.example.application.MVVM.viewModelUser
import com.example.application.R
import de.hdodenhof.circleimageview.CircleImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewFragment : Fragment() {
   private lateinit var itemimage:CircleImageView
   private lateinit var itemname:TextView
   private lateinit var itemprice:TextView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initviews(view)
        val id=ViewFragmentArgs.fromBundle(requireArguments())
        val productid=id.itemid

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view, container, false)


        }


    fun initviews(view:View) {
         itemimage= view.findViewById(R.id.image)
        itemname = view.findViewById(R.id.my_name)
         itemprice = view.findViewById(R.id.my_price)
    }






    }

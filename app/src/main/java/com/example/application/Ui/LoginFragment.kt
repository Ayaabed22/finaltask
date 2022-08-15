package com.example.application.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.application.Logindata
import com.example.application.MVVM.viewModelUser
import com.example.application.R


class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnsignin: Button = requireView().findViewById(R.id.btn_signin)
        val ModelUser: viewModelUser by viewModels()

        btnsignin.setOnClickListener {Logindata()
            ModelUser.CreateUser(
                view.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            )


        }
    }
}

private fun viewModelUser.CreateUser(logindata: Unit) {

}

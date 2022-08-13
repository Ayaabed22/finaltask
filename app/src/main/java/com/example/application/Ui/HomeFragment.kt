package com.example.application.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.application.*
import com.example.application.MVVM.viewModeProduct
import com.example.application.MVVM.viewModelUser


class HomeFragment : Fragment(),ProudctCilck {

    lateinit var  recyclerView: RecyclerView
    lateinit var data:ArrayList<Data>
    lateinit var dataModel: DataModel
    lateinit var dataAddapter: DataAdapter
    lateinit var layoutManager: GridLayoutManager
    val viewModelProduct:viewModeProduct  by viewModels()
    lateinit var ModelUser:viewModelUser
    val email:TextView= requireView().findViewById(R.id.et_email)
    val password:TextView= requireView().findViewById(R.id.et_password)
    var  buttonsignin:Button= requireView().findViewById(R.id.et_password)


    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       initviwes(recyclerView)


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initviwes(view)
        initViewModel()
        buttonsignin.setOnClickListener{
            createUser()

        }

        viewModelProduct.getMyProducts()
        viewModelProduct.getLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                data = it
            }
            installrecycler()

        })
        viewModelProduct.errorLiveData.observe(viewLifecycleOwner , Observer {
           Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
        })

    }

    private fun createUser() {
       val login=Logindata()
        ModelUser.CreateUser(login)
    }
    private fun initViewModel(){
        ModelUser=ViewModelProvider(this).get(viewModelUser::class.java)
        ModelUser.getCreateneyUserObserver().observe(viewLifecycleOwner,Observer<Logindata>{
            if (it==null){
                Toast.makeText(requireContext(),"no internet",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(requireContext(),"sucssefullly login",Toast.LENGTH_LONG).show()
            }
        })

    }


    private fun installrecycler() {
        layoutManager= GridLayoutManager(requireContext(),2)
        recyclerView.layoutManager=layoutManager
        dataAddapter= DataAdapter(dataModel, requireContext(),this )
        recyclerView.adapter=dataAddapter

}
fun initviwes(view: View) {
    recyclerView=view.findViewById(R.id.recycler_view)
}

    override fun itemCilck(productId: Int) {
        view?.findNavController()!!.navigate(HomeFragmentDirections.actionHomeFragmentToViewFragment(productId))


    }


}





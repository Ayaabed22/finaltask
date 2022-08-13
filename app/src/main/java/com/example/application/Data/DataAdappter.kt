package com.example.application

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class DataAdapter(var dataModel: DataModel,
                  var context: Context, proudctCilck: ProudctCilck):RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

var onCilckListener:ProudctCilck=proudctCilck

    class MyViewHolder(item_view:View ):RecyclerView.ViewHolder(item_view) {
        var itemid:TextView=item_view.findViewById(R.id.id)
        var itemqantity:TextView=item_view.findViewById(R.id.qantity)
        var itemimage: CircleImageView = item_view.findViewById(R.id.image)
        var itemname: TextView = item_view.findViewById(R.id.my_name)
        var itemprice: TextView = item_view.findViewById(R.id.my_price)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view :View=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)

        return MyViewHolder(view)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var mydata= dataModel.data?.get(position)
        if (mydata != null) {
            holder.itemname.text=mydata.name
        }
        if (mydata != null) {
            if (mydata != null) {
                holder.itemprice.text=mydata.price.toString()
            }
            Glide.with(View(context)).load(mydata.image).into(holder.itemimage)
        }
        if (mydata != null) {
            holder.itemid.text=mydata.id.toString()
        }
        if (mydata != null) {
            holder.itemqantity.text= mydata.quantity.toString()
        }
        holder.itemView.setOnClickListener(){
            if (mydata != null) {
                mydata.id?.let { it1 -> onCilckListener.itemCilck(it1) }
            }
        }


    }

    override fun getItemCount(): Int {
        return dataModel.data!!.size
    }

    }





    

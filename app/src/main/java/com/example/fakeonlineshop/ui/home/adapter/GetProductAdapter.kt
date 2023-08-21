package com.example.fakeonlineshop.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeonlineshop.databinding.ViewholderPopListBinding
import com.example.fakeonlineshop.models.GetProduct
import com.squareup.picasso.Picasso

class GetProductAdapter(private val list: List<GetProduct>) :
    RecyclerView.Adapter<GetProductAdapter.VH>() {

    inner class VH(private val listBinding: ViewholderPopListBinding) :
        RecyclerView.ViewHolder(listBinding.root) {
        fun onBind(getProduct: GetProduct, position: Int) {
            listBinding.titleItemTxt.text = getProduct.title
            listBinding.feeTxt.text = getProduct.price.toString()
            listBinding.scoreTxt.text = getProduct.rating.rate.toString()
            Picasso.get().load(getProduct.image).into(listBinding.pic)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            ViewholderPopListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position], position)
    }
}
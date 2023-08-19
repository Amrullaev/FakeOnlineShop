package com.example.fakeonlineshop.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeonlineshop.databinding.ViewholderPopListBinding
import com.example.fakeonlineshop.models.GetProduct

class GetProductAdapter(private val list: List<GetProduct>) :
    RecyclerView.Adapter<GetProductAdapter.VH>() {

    inner class VH(private val listBinding: ViewholderPopListBinding) :
        RecyclerView.ViewHolder(listBinding.root) {
        fun onBind(getProduct: GetProduct, position: Int) {
            listBinding.titleItemTxt.text = getProduct.title
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
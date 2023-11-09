package com.example.dbofficer.domain.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.databinding.ItemListOfficerBinding

class AdapterOfficer(var officerList: List<OfficerDataModel>):RecyclerView.Adapter<AdapterOfficer.InfoOfficerViewHolder>(){
    inner class InfoOfficerViewHolder (val binding: ItemListOfficerBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): InfoOfficerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = ItemListOfficerBinding.inflate(inflater,parent,false)
        return InfoOfficerViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: InfoOfficerViewHolder, position: Int) {
        holder.binding.tvNameList.text = officerList[position].name
        holder.binding.tvRangList.text = officerList[position].rank
        holder.binding.tvData.text = officerList[position].birthDate
    }

    override fun getItemCount(): Int {
        return officerList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun searchList(searchList: List<OfficerDataModel>){
        officerList = searchList
        notifyDataSetChanged()
    }
}
package com.android.kuesionerku.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.kuesionerku.R
import com.android.kuesionerku.data.User
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter(
        private val listener: OnItemClickListener
): RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val judul = itemView.tvberandakuesionerjudul.text
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position, judul)
            }
        }
    }

    interface OnItemClickListener {
            fun onItemClick(position: Int, judul: CharSequence)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.tvberandakuesionerjudul.text = currentItem.judul
        holder.itemView.tvberandakuesionerakses.text = currentItem.akses
        holder.itemView.tvberandakuesionerkategori.text = currentItem.kategori
        holder.itemView.tvberandakuesionertanggal.text = currentItem.tanggal
        holder.itemView.tvberandakuesionersaldo.text = currentItem.reward
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}
package com.example.alamat_user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alamat_user.data.AlamatItem
import com.example.alamat_user.databinding.AlamatItemBinding

class AlamatListAdapter(
    private val alamatt: ArrayList<AlamatItem>,
    val itemClickListener: (AlamatItem) -> Unit
): RecyclerView.Adapter<AlamatListAdapter.AlamatViewHolder>() {

    inner class AlamatViewHolder(private val binding: AlamatItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(alamat: AlamatItem) = with(binding) {
            tvNama.text = alamat.nama
            tvNohp.text = alamat.nohp.toString()
            root.setOnClickListener { itemClickListener(alamat) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlamatViewHolder {
        val binding = AlamatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AlamatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlamatViewHolder, position: Int) {
        val alamat = alamatt[position]
        holder.bind(alamat)
    }

    override fun getItemCount() = alamatt.size
}
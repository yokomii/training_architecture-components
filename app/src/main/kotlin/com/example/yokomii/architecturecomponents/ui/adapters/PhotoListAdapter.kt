package com.example.yokomii.architecturecomponents.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.yokomii.architecturecomponents.databinding.ListItemPhotoBinding
import com.example.yokomii.architecturecomponents.vo.Photo
import kotlin.properties.Delegates

/**
 *  フォトリストアダプター
 */
class PhotoListAdapter : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    var list by Delegates.observable(emptyList<Photo>()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val binding = ListItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(val binding: ListItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.photo = photo
        }
    }
}

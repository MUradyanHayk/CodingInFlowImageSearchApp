package com.example.codinginflowimagesearchapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.codinginflowimagesearchapp.R
import com.example.codinginflowimagesearchapp.databinding.ItemUnsplashPhotoBinding
import com.example.codinginflowimagesearchapp.model.UnsplashPhotoResult
import java.lang.ref.WeakReference

interface UnsplashPhotoAdapterDelegate {
    fun onItemClick(photo: UnsplashPhotoResult?)
}

class UnsplashPhotoAdapter(private val delegate: WeakReference<UnsplashPhotoAdapterDelegate>?) : PagingDataAdapter<UnsplashPhotoResult, UnsplashPhotoAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {

    inner class PhotoViewHolder(private val binding: ItemUnsplashPhotoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: UnsplashPhotoResult) {
            Glide.with(binding.root.context)
                .load(photo.urls?.regular)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(binding.imageView)

            binding.textViewUserName.text = photo.user?.name ?: ""

            binding.root.setOnClickListener {
                delegate?.get()?.onItemClick(photo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemUnsplashPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UnsplashPhotoResult>() {
            override fun areItemsTheSame(oldItem: UnsplashPhotoResult, newItem: UnsplashPhotoResult): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UnsplashPhotoResult, newItem: UnsplashPhotoResult): Boolean {
                return oldItem == newItem
            }
        }
    }
}
package com.example.movieapp.ui.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : ViewBinding?, M>(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    open val binding: T = binding as T
    abstract fun onBind(position: Int, model: M)
}

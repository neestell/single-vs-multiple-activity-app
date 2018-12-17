package com.neestell.singleandmultiactivityapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import singlemultiple.neestell.com.singleandmultiactivityapp.R


/**
 * Copyright © 2018 Rosberry. All rights reserved.
 *
 * Created by neestell on 07.11.2018.
 */
class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemViewHolder {
        return ItemViewHolder(p0)
    }

    override fun getItemCount() = 20

    override fun onBindViewHolder(p0: ItemViewHolder, p1: Int){}

    class ItemViewHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.i_item, parent, false)
            )

}
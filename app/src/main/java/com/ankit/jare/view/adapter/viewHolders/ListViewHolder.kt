package com.ankit.jare.view.adapter.viewHolders

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.ankit.jare.BR
import com.ankit.jare.model.Fuel_stations
import com.ankit.jare.viewmodel.RepoListViewModel

class ListViewHolder constructor(private val dataBinding: ViewDataBinding, private val repoListViewModel: RepoListViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {

    fun setup(itemData: Fuel_stations) {
        try {
            if (itemData != null) {
                dataBinding.setVariable(BR.itemData, itemData)
                dataBinding.executePendingBindings()
            }

        } catch (e: NullPointerException) {
            e.printStackTrace()
        }

    }
}
package com.ankit.jare.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ankit.jare.model.Fuel_stations
import com.ankit.jare.model.ListRepository

class RepoListViewModel : BaseViewModel() {

    val repoListLive = MutableLiveData<List<Fuel_stations>>()

    fun fetchRepoList() {
        try {
            dataLoading.value = true
            ListRepository.getInstance().getRepoList { isSuccess, response ->
                dataLoading.value = false
                if (isSuccess) {
                    if (response != null && response.fuel_stations.size > 0) {
                        repoListLive.postValue(response?.fuel_stations)
                    }

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
package com.rajeev.everydaynews.viewModals
import androidx.lifecycle.ViewModel
import com.rajeev.everydaynews.repo.MainRepositires

class MainViewModal(val mainRepositires: MainRepositires):ViewModel() {

    var currentPage = 1
    val articleLiveData get() = mainRepositires.liveData
    fun loadArticles(){
        currentPage++
        mainRepositires.getArticles(currentPage.toString())
    }
}
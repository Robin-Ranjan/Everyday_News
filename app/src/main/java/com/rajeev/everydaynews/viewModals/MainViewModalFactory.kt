package com.rajeev.everydaynews.viewModals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.rajeev.everydaynews.repo.MainRepositires

class MainViewModalFactory(val mainRepositires: MainRepositires):ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return MainViewModal(mainRepositires) as T
    }
}
package com.ibrahim.themovieapp.ui.base

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment(layoutId: Int): Fragment(layoutId) {

    abstract fun clearResources()

    override fun onDestroyView() {
        super.onDestroyView()
        clearResources()
    }

}
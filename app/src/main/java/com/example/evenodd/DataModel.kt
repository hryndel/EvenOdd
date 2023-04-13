package com.example.evenodd

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel(){
    val messageForFirstFragment: MutableLiveData<Triple<Int, Int, Int>> by lazy {
        MutableLiveData<Triple<Int, Int, Int>>()
    }
    val messageForSecondFragment: MutableLiveData<Triple<Int, Int, Int>> by lazy {
        MutableLiveData<Triple<Int, Int, Int>>()
    }
    val messageFromFirstFragment: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val messageFromSecondFragment: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
}
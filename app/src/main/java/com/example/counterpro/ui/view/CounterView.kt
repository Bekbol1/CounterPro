package com.example.counterpro.ui.view

interface CounterView {
    fun showCount(number:Int)
    fun showToast(message:String)
    fun setTextColor(color:Int)
    fun resetTextColor(color:Int)
}
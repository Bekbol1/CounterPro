package com.example.counterpro.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.counterpro.databinding.FragmentCountBinding
import com.example.counterpro.presenter.Presenter
import com.example.counterpro.ui.view.CounterView

class CountFragment : Fragment(), CounterView {
    private lateinit var binding: FragmentCountBinding
    private lateinit var presenter: Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCountBinding.inflate(layoutInflater)
        presenter = Presenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnPlus.setOnClickListener {
                presenter.increment()
            }
            btnMinus.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showCount(number: Int) {
        binding.number.text = number.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText( requireContext(),message, Toast.LENGTH_SHORT).show()
    }

    override fun setTextColor(color: Int) {
        binding.number.setTextColor(color)
    }

    override fun resetTextColor(color: Int) {
        binding.number.setTextColor(color)
    }


}
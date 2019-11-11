package com.influx.fbapp.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.influx.fbapp.R
import com.influx.fbapp.viewmodel.ComboViewModel

class ComboFragment : Fragment() {

    companion object {
        fun newInstance() = ComboFragment()
    }

    private lateinit var viewModel: ComboViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.combo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ComboViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
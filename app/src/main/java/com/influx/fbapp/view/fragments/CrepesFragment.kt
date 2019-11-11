package com.influx.fbapp.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.influx.fbapp.R
import com.influx.fbapp.viewmodel.CrepesViewModel

class CrepesFragment : Fragment() {

    companion object {
        fun newInstance() = CrepesFragment()
    }

    private lateinit var viewModel: CrepesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.crepes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CrepesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

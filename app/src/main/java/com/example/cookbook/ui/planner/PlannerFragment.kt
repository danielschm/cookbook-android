package com.example.cookbook.ui.planner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cookbook.R

class PlannerFragment : Fragment() {

    private lateinit var plannerViewModel: PlannerViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        plannerViewModel =
                ViewModelProviders.of(this).get(PlannerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_planner, container, false)
        return root
    }
}

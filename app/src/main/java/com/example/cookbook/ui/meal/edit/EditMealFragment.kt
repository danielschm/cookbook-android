package com.example.cookbook.ui.meal.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.cookbook.R

class EditMealFragment : Fragment() {

    private lateinit var editMealViewModel: EditMealViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        editMealViewModel =
                ViewModelProviders.of(this).get(EditMealViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_edit_meal, container, false)
        return root
    }
}

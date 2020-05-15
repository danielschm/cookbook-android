package com.example.cookbook.ui.meal

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cookbook.R
import com.example.cookbook.data.MealRepository
import com.example.cookbook.model.Meal

class MealFragment : Fragment() {
    private lateinit var mealViewModel: MealViewModel
    private lateinit var adapter: MealAdapter

    private lateinit var ctx: Context
    private lateinit var root: View

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ctx = container!!.context
        root = inflater.inflate(R.layout.fragment_meal, container, false)

        initViewModel()
        initAdapter()

        return root
    }

    private fun initViewModel() {
        mealViewModel = ViewModelProviders.of(this, MealViewModelFactory(MealRepository()))
            .get(MealViewModel::class.java)
        mealViewModel.meals.observe(viewLifecycleOwner, this.updateAdapter)
        mealViewModel.loadMeals()
    }

    private fun initAdapter() {
        listView = root.findViewById(R.id.listView)
        adapter = MealAdapter(ctx)
        listView.adapter = adapter
    }

    private val updateAdapter = Observer<ArrayList<Meal>> {
        adapter.mealList = it
    }
}

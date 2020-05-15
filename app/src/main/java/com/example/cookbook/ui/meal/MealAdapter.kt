package com.example.cookbook.ui.meal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.cookbook.R
import com.example.cookbook.model.Meal

class MealAdapter(var ctx: Context, var mealList: ArrayList<Meal> = arrayListOf()) : BaseAdapter() {

    private class ViewHolder(row: View?) {
        var txtName: TextView
        var txtDuration: TextView
        var txtTags: TextView

        init {
            this.txtName = row!!.findViewById(R.id.meal_name)
            this.txtDuration = row.findViewById(R.id.meal_duration)
            this.txtTags = row.findViewById(R.id.meal_tags)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        if (convertView == null) {
            val layout = LayoutInflater.from(ctx)
            view = layout.inflate(R.layout.list_item_template, parent, false)
            viewHolder =
                ViewHolder(
                    view
                )
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val meal: Meal = getItem(position) as Meal
        viewHolder.txtName.text = meal.name
        viewHolder.txtDuration.text = meal.duration
        viewHolder.txtTags.text = meal.tags.toString()

        return view as View
    }

    override fun getItem(position: Int): Any {
        return mealList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 1
    }

    override fun getCount(): Int {
        return mealList.count()
    }
}
package com.example.healthapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SearchView
import android.widget.Spinner
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment


class TodoFragment : Fragment() {
    // Added these four variables
    private lateinit var editTextNewItem: EditText
    private lateinit var listViewItems: ListView
    private lateinit var itemsAdapter: ArrayAdapter<String>
    private val todoItems = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?

    ): View? {

        val rootView = inflater.inflate(R.layout.layout_todo, container, false)

        var counter = 1

        var mintotal = 0

        var caltotal = 0

        val search: SearchView = rootView.findViewById(R.id.editSearch)

        val spinner: Spinner = rootView.findViewById(R.id.spinner)

        val calories: EditText = rootView.findViewById(R.id.calsBurned)

        val button: Button = rootView.findViewById(R.id.add)

        val table: TableLayout = rootView.findViewById(R.id.table)

        val totals: TableLayout = rootView.findViewById(R.id.totals)

        button.setOnClickListener {
            val act = TextView(container!!.context)
            act.text = search.query.toString()
            act.textSize = 24F
            val tim = TextView(container.context)
            tim.text = spinner.selectedItem.toString()
            tim.textSize = 24F
            val cal = TextView(container.context)
            cal.text = calories.text.toString()
            cal.textSize = 24F

            if (cal.text == "") {
                cal.text = "" + (tim.text.toString().toInt() * 5)
            }

            mintotal += tim.text.toString().toInt()
            caltotal += cal.text.toString().toInt()

            addNewItem(container.context, table, counter, act, tim, cal)
            counter += 1
            val row = totals.getChildAt(0) as TableRow
            var item = row.getChildAt(1) as TextView
            item.text = "" + mintotal
            item = row.getChildAt(2) as TextView
            item.text = "" + caltotal
        }

        return rootView
    }

    private fun addNewItem(context: Context, table: TableLayout, counter: Int, activity: TextView, time: TextView, cals: TextView) {
        table.addView(TableRow(context))
        val row = table.getChildAt(counter) as TableRow
        row.addView(activity)
        row.addView(time)
        row.addView(cals)
    }
    // Here "layout_todo" is a name of layout file
    // created for TodoFragment
    //inspired from https://www.geeksforgeeks.org/how-to-implement-tabs-viewpager-and-fragment-in-android-using-kotlin/

}
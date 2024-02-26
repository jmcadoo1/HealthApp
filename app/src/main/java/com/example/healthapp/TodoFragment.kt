package com.example.healthapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ListView
import android.widget.Button
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter


class TodoFragment : Fragment() {
    // Added these four variables
    private lateinit var editTextNewItem: EditText
    private lateinit var listViewItems: ListView
    private lateinit var itemsAdapter: ArrayAdapter<String>
    private val todoItems = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?

    ): View? {

        /*return inflater.inflate(
            R.layout.layout_todo, container, false
        )*/
        val rootView = inflater.inflate(R.layout.layout_todo, container, false)
        editTextNewItem = rootView.findViewById(R.id.editText)
        listViewItems = rootView.findViewById(R.id.listView)
        itemsAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, todoItems)
        listViewItems.adapter = itemsAdapter
        rootView.findViewById<Button>(R.id.add).setOnClickListener {
            addNewItem()
        }
        listViewItems.setOnItemClickListener { _, _, position, _ ->
            val currentItem = todoItems[position]
            if(!currentItem.endsWith(" ✔")) {
                todoItems[position] = todoItems[position] + " ✔"
            } else {
                todoItems[position] = currentItem.removeSuffix(" ✔")
            }
            itemsAdapter.notifyDataSetChanged()
        }
        listViewItems.setOnItemLongClickListener { _, _, position, _ ->
            todoItems.removeAt(position)
            itemsAdapter.notifyDataSetChanged()
            true
        }
        return rootView
    }

    private fun addNewItem() {
        val newItem = editTextNewItem.text.toString()
        if (newItem.isNotBlank()) {
            todoItems.add(newItem)
            itemsAdapter.notifyDataSetChanged()
            editTextNewItem.text.clear()
        }
    }
    // Here "layout_todo" is a name of layout file
    // created for TodoFragment
    //inspired from https://www.geeksforgeeks.org/how-to-implement-tabs-viewpager-and-fragment-in-android-using-kotlin/

}
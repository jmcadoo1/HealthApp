package com.example.healthapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class TodoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(
            R.layout.layout_todo, container, false
        )
    }
    // Here "layout_todo" is a name of layout file
    // created for TodoFragment
    //inspired from https://www.geeksforgeeks.org/how-to-implement-tabs-viewpager-and-fragment-in-android-using-kotlin/

}
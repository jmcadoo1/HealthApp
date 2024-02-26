package com.example.healthapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Button


class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.layout_profile, container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val profileButton = view.findViewById<ImageButton>(R.id.image)
        val linearLayout = view.findViewById<LinearLayout>(R.id.linlayout)
        val closeNotif = view.findViewById<TextView>(R.id.closenotif)

        profileButton.setOnClickListener {
            linearLayout.visibility = View.VISIBLE
        }

        closeNotif.setOnClickListener {
            linearLayout.visibility = View.INVISIBLE
        }
    }
    // Here "layout_profile" is a name of layout file
    // created for ChoicesFragment
    //inspired from https://www.geeksforgeeks.org/how-to-implement-tabs-viewpager-and-fragment-in-android-using-kotlin/

}
package com.example.healthapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.fragment.app.Fragment
class ChoicesFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.layout_choices, container, false
        )
        val spinner: Spinner = view.findViewById(R.id.mySpinner)
        val spinnerAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.color_options,
            android.R.layout.simple_spinner_item
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter

        val radioGroup: RadioGroup = view.findViewById(R.id.radioGroup4)
        var radioButton = view.findViewById<RadioButton>(R.id.redRadioButton)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            radioButton = view.findViewById(checkedId)
        }

        val button: Button = view.findViewById(R.id.button)

        button.setOnClickListener {
            button.text = "Player 1: ${radioButton.text}\nPlayer 2: ${spinner.selectedItem}"
        }

        return view
    }
    // Here "layout_choices" is a name of layout file
    // created for ChoicesFragment
    //inspired from https://www.geeksforgeeks.org/how-to-implement-tabs-viewpager-and-fragment-in-android-using-kotlin/
}
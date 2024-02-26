package com.example.healthapp


import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.app.Activity
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tab_viewpager = findViewById<ViewPager>(R.id.viewPager)
        var tab_tablayout = findViewById<TabLayout>(R.id.tabbyCat)

        // As we set NoActionBar as theme to this activity
        // so when we run this project then this activity doesn't
        // show title. And for this reason, we need to run
        // setSupportActionBar method
        setupViewPager(tab_viewpager)

        // If we dont use setupWithViewPager() method then
        // tabs are not used or shown when activity opened
        tab_tablayout.setupWithViewPager(tab_viewpager)



        // Code for warning message for profile pic to work:

        // The below code will not work without switching to "layout_profile" as the layout, 
        // however this conflicts with the above setup of "activity_main" as the layout.
        // Presumably code to switch tabs/layouts will fix this issue.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_profile)

        // initiate view's
        val profileButton = findViewById<ImageButton>(R.id.image) // how do we put the right layout?
        val linearLayout = findViewById<LinearLayout>(R.id.linlayout)
        val closeNotif = findViewById<TextView>(R.id.closenotif)

        // perform click event on button's
        profileButton.setOnClickListener {
            linearLayout.setVisibility(View.VISIBLE)
        }

        closeNotif.setOnClickListener {
            linearLayout.setVisibility(View.INVISIBLE)
        }

    }

    private fun setupViewPager(viewpager: ViewPager) {
        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        // TextFragment is the name of Fragment and the text
        // is a title of tab
        adapter.addFragment(TextFragment(), "Text")
        adapter.addFragment(ChoicesFragment(), "Choices")
        adapter.addFragment(TodoFragment(), "Todo")
        adapter.addFragment(ProfileFragment(), "Profile")
        adapter.addFragment(ColorsFragment(), "Colors")
        adapter.addFragment(LowerRightFragment(), "LowerRight")

        // setting adapter to view pager.
        viewpager.setAdapter(adapter)
    }

    class ViewPagerAdapter : FragmentPagerAdapter {

        // objects of arraylist. One is of Fragment type and
        // another one is of String type.*/
        private final var fragmentList1: ArrayList<Fragment> = ArrayList()
        private final var fragmentTitleList1: ArrayList<String> = ArrayList()

        // this is a secondary constructor of ViewPagerAdapter class.
        public constructor(supportFragmentManager: FragmentManager)
                : super(supportFragmentManager)

        // returns which item is selected from arraylist of fragments.
        override fun getItem(position: Int): Fragment {
            return fragmentList1.get(position)
        }

        // returns which item is selected from arraylist of titles
        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList1.get(position)
        }

        // returns the number of items present in arraylist.
        override fun getCount(): Int {
            return fragmentList1.size
        }

        // this function adds the fragment and title in 2 separate  arraylist.
        fun addFragment(fragment: Fragment, title: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(title)
        }

    }



// code below is for getting checklist/selection for todo list
//    import androidx.appcompat.app.AppCompatActivity
//    import android.os.Bundle
//    import android.util.SparseBooleanArray
//    import android.widget.ArrayAdapter
//    import kotlinx.android.synthetic.main.activity_main.*
//    class MainActivity : AppCompatActivity() {
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            setContentView(R.layout.activity_main)
//            // Initializing the array lists and the adapter
//            var itemlist = arrayListOf<String>()
//            var adapter =ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_multiple_choice
//                , itemlist)
//            // Adding the items to the list when the add button is pressed
//            add.setOnClickListener {
//
//                itemlist.add(editText.text.toString())
//                listView.adapter =  adapter
//                adapter.notifyDataSetChanged()
//                // This is because every time when you add the item the input space or the eidt text space will be cleared
//                editText.text.clear()
//            }
//            // Clearing all the items in the list when the clear button is pressed
//            clear.setOnClickListener {
//
//                itemlist.clear()
//                adapter.notifyDataSetChanged()
//            }
//            // Adding the toast message to the list when an item on the list is pressed
//            listView.setOnItemClickListener { adapterView, view, i, l ->
//                android.widget.Toast.makeText(this, "You Selected the item --> "+itemlist.get(i), android.widget.Toast.LENGTH_SHORT).show()
//            }
//            // Selecting and Deleting the items from the list when the delete button is pressed
//            delete.setOnClickListener {
//                val position: SparseBooleanArray = listView.checkedItemPositions
//                val count = listView.count
//                var item = count - 1
//                while (item >= 0) {
//                    if (position.get(item))
//                    {
//                        adapter.remove(itemlist.get(item))
//                    }
//                    item--
//                }
//                position.clear()
//                adapter.notifyDataSetChanged()
//            }
//        }
//    }


}

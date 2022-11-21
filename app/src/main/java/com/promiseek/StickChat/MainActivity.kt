package com.promiseek.StickChat
//https://docs.google.com/document/d/1I_u5upwAm01kg2cdZvNHK6mPkSobuHnJ89TjAuxkNKI/edit?usp=sharing
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.promiseek.StickChat.Add.MyCanvas
import com.promiseek.StickChat.Home.HomeFragment
import com.promiseek.StickChat.Person.PersonFragment
import com.promiseek.StickChat.Saved.SavedFragment
import com.promiseek.StickChat.Trending.TrendingFragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var fragmentManager:FragmentManager
    lateinit var toolbar:MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        toolbar()
        fragmentManager = supportFragmentManager
        supportFragmentManager.beginTransaction().add(R.id.gaphicRelativeLayout, HomeFragment(), "zero").commit()

        //on bottom nav clicked
        bottomNav.setOnItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    selectItem(0)
                    toolbar.title ="Home"
                    true
                }
                R.id.trending -> {
                    selectItem(1)
                    toolbar.title ="Trending"
                    true
                }
                R.id.add -> {
                    startActivity(Intent(this,MyCanvas::class.java))
                    true
                }
                R.id.saved -> {

                    selectItem(4)
                    toolbar.title ="Saved"
                    true
                }
                R.id.person -> {

                    selectItem(5)
                    toolbar.title ="Person"
                    true
                }
                else -> false
            }
        })

    }

    fun toolbar(){
        toolbar = findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.bottom_navigation)
    }

    //bottom navigation item clicked
    fun selectItem(position: Int) {
        when (position) {
            0 -> {
                if (fragmentManager.findFragmentByTag("zero") != null) {
                    //if the fragment exists, show it.

                    fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("zero")!!).commit()
                } else {
                    //if the fragment does not exist, add it to fragment manager.
                    fragmentManager.beginTransaction().add(R.id.gaphicRelativeLayout, HomeFragment(), "zero").commit()
                }
                if (fragmentManager.findFragmentByTag("one") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("one")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("two") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("two")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("three") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("three")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("four") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("four")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("five") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("five")!!).commit()
                }
            }

            1-> {
                if (fragmentManager.findFragmentByTag("one") != null) {
                    //if the fragment exists, show it.

                    fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("one")!!).commit()
                } else {
                    //if the fragment does not exist, add it to fragment manager.
                    fragmentManager.beginTransaction().add(R.id.gaphicRelativeLayout, TrendingFragment(), "one").commit()
                }
                if (fragmentManager.findFragmentByTag("zero") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("zero")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("two") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("two")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("three") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("three")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("four") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("four")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("five") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("five")!!).commit()
                }
            }

            3->{
                if (fragmentManager.findFragmentByTag("four") != null) {
                    //if the fragment exists, show it.

                    fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("four")!!).commit()
                } else {
                    //if the fragment does not exist, add it to fragment manager.
                    fragmentManager.beginTransaction().add(R.id.gaphicRelativeLayout, SavedFragment(), "four").commit()
                }
                if (fragmentManager.findFragmentByTag("zero") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("zero")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("one") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("one")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("two") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("two")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("three") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("three")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("five") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("five")!!).commit()
                }
            }

            4->{
                if (fragmentManager.findFragmentByTag("five") != null) {
                    //if the fragment exists, show it.

                    fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("five")!!).commit()
                } else {
                    //if the fragment does not exist, add it to fragment manager.
                    fragmentManager.beginTransaction().add(R.id.gaphicRelativeLayout, PersonFragment(), "five").commit()
                }
                if (fragmentManager.findFragmentByTag("zero") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("zero")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("one") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("one")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("two") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("two")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("three") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("three")!!).commit()
                }
                if (fragmentManager.findFragmentByTag("four") != null) {
                    //if the other fragment is visible, hide it.
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("four")!!).commit()
                }
            }




        }
    }


}
package com.javiertorres.icesisites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navigator:BottomNavigationView

    private lateinit var editProfileFragment: EditProfileFragment
    private lateinit var viewProfileFragment: ViewProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        val timer = object: CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                initialize()

            }
        }
        timer.start()
    }

    fun initialize(){
        setContentView(R.layout.activity_main)

        editProfileFragment = EditProfileFragment.newInstance()
        viewProfileFragment = ViewProfileFragment.newInstance()

        viewProfileFragment.setMainActivity(this)
        viewProfileFragment.setEditProfileFragment(editProfileFragment)

        editProfileFragment.setMainActivity(this)
        editProfileFragment.setViewProfileFragment(viewProfileFragment)

        showFragment(viewProfileFragment)

        navigator = findViewById(R.id.navigator)
        navigator.setOnNavigationItemSelectedListener {menuItem ->
            if(menuItem.itemId == R.id.profileMenu){
                showFragment(editProfileFragment)
            } else if(menuItem.itemId == R.id.postsMenu){
//                        showFragment()
            } else if(menuItem.itemId == R.id.mapMenu){
//                        showFragment()
            }
            true
        }
    }

    fun showFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}
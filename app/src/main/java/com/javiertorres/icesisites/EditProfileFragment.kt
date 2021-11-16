package com.javiertorres.icesisites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_edit_profile.view.*

class EditProfileFragment : Fragment() {

    private lateinit var mainActivity: MainActivity
    private lateinit var viewProfileFragment: ViewProfileFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edit_profile, container, false)
        view.editButton.setOnClickListener{
            mainActivity.showFragment(viewProfileFragment)
        }
        return view
    }

    fun setMainActivity(mainActivity: MainActivity){
        this.mainActivity = mainActivity
    }

    fun setViewProfileFragment(viewProfileFragment: ViewProfileFragment){
        this.viewProfileFragment = viewProfileFragment
    }

    companion object {
        @JvmStatic
        fun newInstance() = EditProfileFragment()
    }
}
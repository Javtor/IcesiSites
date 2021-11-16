package com.javiertorres.icesisites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_view_profile.view.*

class ViewProfileFragment : Fragment() {

    private lateinit var mainActivity: MainActivity
    private lateinit var editProfileFragment: EditProfileFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_profile, container, false)
        view.editBtn.setOnClickListener {
            mainActivity.showFragment(editProfileFragment)
        }
        return view
    }

    fun setMainActivity(mainActivity: MainActivity){
        this.mainActivity = mainActivity
    }

    fun setEditProfileFragment(editProfileFragment: EditProfileFragment){
        this.editProfileFragment = editProfileFragment
    }

    companion object {

        fun newInstance() = ViewProfileFragment()
    }

}
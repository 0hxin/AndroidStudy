package com.example.app08_viewpager.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// FragmentStateAdapter
class MyFragAdapter2(val fragActivity : FragmentActivity, val mCont:Int) : FragmentStateAdapter(fragActivity) {
    override fun getItemCount(): Int {
        return 200
    }

    override fun createFragment(position: Int): Fragment {
        val index:Int = getRealPosition(position)
        return if (index == 0) FragmentOne()
        else if (index == 1) FragmentTwo()
        else if (index == 2) FragmentThree()
        else FragmentFour()
    }
    private fun getRealPosition(position: Int):Int{
        return position%mCont
    }
}
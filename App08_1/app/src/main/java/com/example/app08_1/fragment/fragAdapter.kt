package com.example.app08_1.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class fragAdapter(fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {
    var fragments = listOf<Fragment>(FragmentOne(), FragmentTwo(), FragmentThree(), FragmentFour())
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
package com.example.app08_viewpager.tab

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ContentAdapter(val fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {
    var fragments = listOf<Fragment>(FragmentTab1(), FragmentTab2(), FragmentTab3())
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
package com.example.app06_1.friend

import com.example.app06_1.R

data class Friend(var resourceId: Int, var name:String, var msg:String) {
    constructor(name:String, msg:String):this(R.drawable.profile, name, msg)
}

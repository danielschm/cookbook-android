package com.example.cookbook.model

class TagList(private val list: ArrayList<String>) {

    override fun toString(): String {
        var string = ""
        list.forEach {
            string = "$string#$it "
        }
        string = string.dropLast(1)
        return string
    }
}
package com.example.cookbook.model

class Meal(
    var name: String,
    var duration: String,
    tagList: ArrayList<String> = arrayListOf()
) {
    var tags: TagList = TagList(tagList)
}


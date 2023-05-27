package com.rajeev.everydaynews.modals

import com.rajeev.everydaynews.Adapter.LAYOUT_CARD
import com.rajeev.everydaynews.Adapter.LAYOUT_LIST
import java.io.Serializable

data class ArticleModal(
    val id:Int,
    val title:String,
    val content:String,
    val date: String,
    val excerpt:String,
    val authorName:String,
    val authorUrl:String,
    val authorPic:String,
    val readingTime:String,
    val imageUrl: String,
    val category:Int,
    var LAYOUT_TYPE: Int = LAYOUT_LIST

    ):Serializable

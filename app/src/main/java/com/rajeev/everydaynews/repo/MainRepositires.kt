package com.rajeev.everydaynews.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.rajeev.everydaynews.modals.ArticleModal
import com.rajeev.everydaynews.utils.*
import org.json.JSONArray

class MainRepositires(private val context: Context) {
    private val muteableLiveData = MutableLiveData<APIResponses<ArrayList<ArticleModal>>>()
    val liveData get() = muteableLiveData


    fun getArticles(page: String = "1") {

        liveData.value = APIResponses.Loading()
        val requestQueue = Volley.newRequestQueue(context)
        val url = POSTS_URL
        val stringRequest = object : StringRequest(Method.GET, url, { response ->

            if (response.isNotEmpty()) {
                val tempList: ArrayList<ArticleModal> = ArrayList()
                val mainJsonArray = JSONArray(response)

                for (i in 0 until mainJsonArray.length()) {
                    val postObject = mainJsonArray.getJSONObject(i)
                    postObject.apply {
                        val embedded = getJSONObject("_embedded")
                        val id = getInt("id")
                        val title = getJSONObject("title").getString("rendered")
                        val content = getJSONObject("content").getString("rendered")
                        val excerpt = getJSONObject("excerpt").getString("rendered")
                        val date = getString("date")
                        val authorArray = embedded.getJSONArray("author")
                        val authorName = authorArray.getJSONObject(0).getString("name")
                        val authorUrl = authorArray.getJSONObject(0).getString("link")
                        val authorPic =
                            authorArray.getJSONObject(0).getJSONObject("avatar_urls").getString("96")
                        val readingTime = (content.split(" ").size / 200).toString()
                        val image = embedded.getJSONArray("wp:featuredmedia").getJSONObject(0)
                            .getJSONObject("media_details").getJSONObject("sizes")
                            .getJSONObject("full").getString("source_url")
                        val category = getJSONArray("categories").get(0)
                        val modal = ArticleModal(
                            id = id,
                            title = title,
                            content = content,
                            date = date,
                            excerpt = excerpt,
                            authorName = authorName,
                            authorUrl = authorUrl,
                            authorPic = authorPic,
                            readingTime = readingTime,
                            imageUrl = image,
                            category = category.toString().toInt()
                        )
                        tempList.add(modal)
                    }
                    liveData.value = APIResponses.Success(tempList)
                }
            }
        }, { error ->
            liveData.value = error.localizedMessage?.let { APIResponses.Error(error = it) }
        }) {

        }
        requestQueue.add(stringRequest)

    }
}
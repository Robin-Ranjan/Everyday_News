package com.rajeev.everydaynews.Activitys

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.rajeev.everydaynews.R
import com.rajeev.everydaynews.utils.convertDateFormate
import com.rajeev.everydaynews.utils.loadImageWithGlide
import com.rajeev.everydaynews.databinding.ActivityArticleBinding
import com.rajeev.everydaynews.modals.ArticleModal

class ArticleActivity : AppCompatActivity() {
    val activity = this
    lateinit var binding: ActivityArticleBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val model = intent.getSerializableExtra("model") as ArticleModal
            loadImageWithGlide(model.imageUrl, postImage, activity)
            loadImageWithGlide(model.authorPic, authorImg, activity)
            listAuthorName.text = model.authorName
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                articleDate.text = convertDateFormate(model.date)
            } else
                articleDate.text = "Unknown"
            articleView.text = Html.fromHtml(model.content)
            aTitle.text = model.title

        }
    }
}
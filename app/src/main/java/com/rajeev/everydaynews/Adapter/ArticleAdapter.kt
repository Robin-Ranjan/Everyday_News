package com.rajeev.everydaynews.Adapter

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rajeev.everydaynews.Activitys.ArticleActivity
import com.rajeev.everydaynews.modals.ArticleModal
import com.rajeev.everydaynews.utils.*
import com.rajeev.everydaynews.databinding.ItemNewsCardBinding
import com.rajeev.everydaynews.databinding.ItemNewsListBinding

const val TAG = "MAIN_ACTIVITY"
const val LAYOUT_CARD = 1
const val LAYOUT_LIST = 2

class ArticleAdapter(var list: ArrayList<ArticleModal>, var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class cardViewHolder(var binding: ItemNewsCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ArticleModal, context: Context) {
            binding.apply {
                mArticleTitleCard.text = Html.fromHtml(model.title)
                mArticleExcerpt.text = Html.fromHtml(model.excerpt)
                loadImageWithGlide(model.imageUrl, imageView2, context)
                articleCard.setOnClickListener {
                    val intent = Intent().apply {
                        putExtra("model", model)
//                        putExtra("image",model.imageUrl)
//                        putExtra("title",model.title)
//                        putExtra("date",model.date)
//                        putExtra("content",model.content)
//                        putExtra("authorName",model.authorName)
//                        putExtra("authorPic",model.authorPic)
//                        putExtra("authorUrl",model.authorUrl)
                        setClass(context, ArticleActivity::class.java)
                    }
                    context.startActivity(intent)

                }
                // Log.d("Tag","Hello")
            }
        }
    }

    class listViewHolder(var binding: ItemNewsListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, model: ArticleModal) {
            binding.apply {
                listTitle.text = Html.fromHtml(model.title)
                listAuthorName.text = Html.fromHtml(model.authorName)
                listTime.text = ".${model.readingTime}m Read"
                loadImageWithGlide(model.imageUrl, listImg, context)
                listConstrain.setOnClickListener {
                    val intent = Intent().apply {
                        putExtra("model", model)
                        setClass(context, ArticleActivity::class.java)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == LAYOUT_CARD) {
            return cardViewHolder(
                ItemNewsCardBinding.inflate(
                    LayoutInflater.from(context),
                    parent,
                    false
                )
            )
        } else {
            return listViewHolder(
                ItemNewsListBinding.inflate(
                    LayoutInflater.from(context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]
        if (getItemViewType(position) == LAYOUT_CARD) {
            (holder as cardViewHolder).bind(model, context)
        } else {
            (holder as listViewHolder).bind(context, model)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].LAYOUT_TYPE == LAYOUT_CARD) {
            LAYOUT_CARD
        } else {
            LAYOUT_LIST
        }
    }


}
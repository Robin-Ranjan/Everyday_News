package com.rajeev.everydaynews.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rajeev.everydaynews.utils.logInfo
import com.rajeev.everydaynews.Adapter.ArticleAdapter
import com.rajeev.everydaynews.Adapter.LAYOUT_CARD
import com.rajeev.everydaynews.Adapter.LAYOUT_LIST
import com.rajeev.everydaynews.R
import com.rajeev.everydaynews.modals.ArticleModal
import com.rajeev.everydaynews.utils.showMessage
import com.rajeev.everydaynews.databinding.ActivityMainBinding
import com.rajeev.everydaynews.repo.APIResponses
import com.rajeev.everydaynews.repo.MainRepositires
import com.rajeev.everydaynews.utils.Preutil
import com.rajeev.everydaynews.viewModals.MainViewModal
import com.rajeev.everydaynews.viewModals.MainViewModalFactory

const val TAG = "MAIN_ACTIVITY"

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val activity = this
    private val list: ArrayList<ArticleModal> = ArrayList()
    private val adapter = ArticleAdapter(list, activity)
    private lateinit var viewModal: MainViewModal
    private val refreshLiveData = MutableLiveData<Boolean>()

    var layoutCurrent = LAYOUT_CARD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Preutil.init(activity)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadArticlesFromBackEnd()
        updateRefreshLayout()
        changeRecyclerViewLayout()
    }

    private fun changeRecyclerViewLayout() {
        layoutCurrent = Preutil.getPrefInt("layout_type", LAYOUT_CARD)
        binding.mActionBar.actionBarImg.setOnClickListener {
            if (layoutCurrent == LAYOUT_CARD) {
                layoutCurrent = LAYOUT_LIST
            } else {
                layoutCurrent = LAYOUT_CARD
            }
            updateUiBasedOnLayoutType()
        }
    }

    private fun updateUiBasedOnLayoutType() {
        Preutil.putPrefInt("layout_type", layoutCurrent)
        if (layoutCurrent == LAYOUT_CARD) {
            binding.mActionBar.actionBarImg.setImageResource(R.drawable.layout_card)
        } else {
            binding.mActionBar.actionBarImg.setImageResource(R.drawable.layout_list)
        }

        val tempList: ArrayList<ArticleModal> = ArrayList()
        if (list.isNotEmpty()) {
            list.forEach {
                tempList.add(it)
            }
            list.clear()
            tempList.forEach {
                it.LAYOUT_TYPE = layoutCurrent
                list.add(it)
            }

            adapter.notifyDataSetChanged()
        }
    }

    private fun updateRefreshLayout() {
        updateShimmerLayout(true)
        refreshLiveData.observe(this) {
            binding.refreshLayout.isRefreshing = it
            updateShimmerLayout(it)
        }
        binding.refreshLayout.setOnRefreshListener {
            viewModal.currentPage = 0
            viewModal.loadArticles()
        }
    }

    private fun updateShimmerLayout(isLoaded: Boolean) {
        binding.apply {
            if (!isLoaded) {
                binding.mCardShimerHolder.visibility = View.GONE
                binding.mlistShimerHolder.visibility = View.GONE
                return
            }
            if (layoutCurrent == LAYOUT_CARD) {
                mCardShimerHolder.visibility = View.VISIBLE
                mlistShimerHolder.visibility = View.GONE
            } else {
                mCardShimerHolder.visibility = View.GONE
                mlistShimerHolder.visibility = View.VISIBLE
            }
        }

    }

    private fun loadArticlesFromBackEnd() {
        val mainRepositires = MainRepositires(context = activity)
        viewModal = ViewModelProvider(
            activity,
            MainViewModalFactory(mainRepositires = mainRepositires)
        )[MainViewModal::class.java]
        viewModal.loadArticles()

        viewModal.articleLiveData.observe(this) {
            // logInfo(TAG, it.toString())
            when (it) {
                is APIResponses.Error -> {
                    showMessage(activity, "Error ${it.errorMessage}")
                    refreshLiveData.value = false

                }

                is APIResponses.Loading -> {
                  //  showMessage(activity, "Loading")
                    refreshLiveData.value = true
                }

                is APIResponses.Success -> {
                    refreshLiveData.value = false

                    if (it.data!!.isNotEmpty()) {


                        it.data?.forEach { modal ->
                            list.add(modal)
                            logInfo(TAG, it.toString())
                            //  showMessage(activity, "Rrr")
                        }
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.apply {
            mRecycler.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            // showMessage(activity,"layoutManager")
            mRecycler.adapter = adapter
            // showMessage(activity,"adapter")
            mRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!recyclerView.canScrollVertically(1))
                        viewModal.loadArticles()
                }
            })

        }
    }
}
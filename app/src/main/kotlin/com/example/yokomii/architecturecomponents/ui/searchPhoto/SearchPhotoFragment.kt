package com.example.yokomii.architecturecomponents.ui.searchPhoto

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.example.yokomii.architecturecomponents.ui.adapters.PhotoListAdapter
import com.example.yokomii.architecturecomponents.util.MyViewModelFactory
import com.example.yokomii.architecturecomponents.databinding.FragmentSearchPhotoBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * 写真検索画面
 */
class SearchPhotoFragment : LifecycleFragment() {

    @Inject
    lateinit var viewModelFactory: MyViewModelFactory

    private lateinit var binding: FragmentSearchPhotoBinding

    private val photoListAdapter by lazy { PhotoListAdapter() }

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(SearchPhotoViewModel::class.java) }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.list.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = photoListAdapter
        }

        viewModel.model.observe(this, Observer {
            it?.info?.photo?.let { photoListAdapter.list = it }
        })

        viewModel.searchPhoto("dog")
    }
}

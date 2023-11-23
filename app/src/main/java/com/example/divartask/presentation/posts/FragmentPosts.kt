package com.example.divartask.presentation.posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.divartask.R
import com.example.divartask.data.entity.PlacesListData
import com.example.divartask.data.entity.PostsData
import com.example.divartask.data.params.PostsParam
import com.example.divartask.databinding.FragmentPlacesBinding
import com.example.divartask.databinding.FragmentPostsBinding
import com.example.divartask.presentation.util.BaseViewState
import com.example.divartask.presentation.util.flowLife
import com.example.divartask.presentation.util.showToast
import dagger.hilt.android.AndroidEntryPoint
import org.koin.core.parameter.parametersOf
import kotlin.math.log

@AndroidEntryPoint
class FragmentPosts : Fragment() {

    private var _mBinding: FragmentPostsBinding? = null
    private val binding get() = _mBinding!!

    private val viewModel by viewModels<PostsViewModel>()

    private var adapter: PostsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = PostsAdapter(onItemClicked = {
            goToDetailFragment(it)
        })
        viewModel.getPosts(arguments?.getInt("ID") ?: 0)
    }

    private fun goToDetailFragment(token: String) {
        findNavController().navigate(R.id.fragmentDetail, bundleOf("TOKEN" to token))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentPostsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectPostsFlow()
    }


    private fun collectPostsFlow() {
        flowLife(viewModel.postsState) {
            when (it) {
                is BaseViewState.Success -> {
                    showLoading(false)
                    setupRecycler(it.data.widgetList)
                }

                is BaseViewState.ErrorString -> {
                    showLoading(false)
                    showToast(it.message)
                }
                is BaseViewState.Loading -> {
                    showLoading(true)
                }
            }
        }
    }

    private fun setupRecycler(widgetList: List<PostsData.Post>?) {
        binding.rvPosts.adapter = adapter
        adapter?.submitList(widgetList)
    }

    private fun showLoading(isShow: Boolean) {
        if (isShow) {
            binding.rvPosts.visibility = View.GONE
            binding.progressLoading.visibility = View.VISIBLE
        } else {
            binding.rvPosts.visibility = View.VISIBLE
            binding.progressLoading.visibility = View.GONE
        }
    }

}
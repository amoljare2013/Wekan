package com.ankit.jare.view.ui

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ankit.jare.R
import com.ankit.jare.databinding.FragmentRepoListBinding
import com.ankit.jare.model.Fuel_stations
import com.ankit.jare.utils.NetworkConnecitity
import com.ankit.jare.view.adapter.ListAdapter
import com.ankit.jare.viewmodel.BaseViewModel
import com.ankit.jare.viewmodel.RepoListViewModel
import kotlinx.android.synthetic.main.fragment_repo_list.*


class ListFragment : Fragment() {

    lateinit var viewModel: BaseViewModel

    private lateinit var viewDataBinding: FragmentRepoListBinding
    private lateinit var adapter: ListAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentRepoListBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProviders.of(this@ListFragment).get(RepoListViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val decoration = DividerItemDecoration(requireContext(), HORIZONTAL)
        repo_list_rv.addItemDecoration(decoration)

        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                filter(editable.toString())
            }
        })

        if (NetworkConnecitity.isNetworkAvailable(requireContext())) {
            viewDataBinding.viewmodel?.fetchRepoList()
            setupAdapter()
            setupObservers()
        } else {
            Toast.makeText(requireContext(), getString(R.string.network_message), Toast.LENGTH_SHORT).show()
        }
    }

    private fun filter(text: String) {
        val filteredNames = ArrayList<Fuel_stations>()
        viewDataBinding.viewmodel?.repoListLive?.observe(viewLifecycleOwner, Observer {
            if (it.size > 0) {
                for (s in it) {
                    if (s.station_name.toLowerCase().contains(text.toLowerCase())) {
                        filteredNames.add(s)
                    }
                }
            }
        })

        if (filteredNames != null) {
            adapter.updateRepoList(filteredNames)
        }
    }

    private fun setupObservers() {
        viewDataBinding.viewmodel?.repoListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })
    }

    // setting your adapter data
    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = ListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager

            // Setting item decoration for recycler view
            var itemDecoration: RecyclerView.ItemDecoration? = null
            while (repo_list_rv.itemDecorationCount > 0 && (repo_list_rv.getItemDecorationAt(0)?.let { itemDecoration = it }) != null) {
                repo_list_rv.removeItemDecoration(itemDecoration!!)
            }
            repo_list_rv.adapter = adapter
        }
    }

    companion object {
        private var INSTANCE: ListFragment? = null
        fun getInstance() = INSTANCE
                ?: ListFragment().also {
                    INSTANCE = it
                }
    }
}

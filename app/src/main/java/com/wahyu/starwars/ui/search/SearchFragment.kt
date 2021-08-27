package com.wahyu.starwars.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.wahyu.starwars.R
import com.wahyu.starwars.databinding.FragmentSearchBinding
import com.wahyu.starwars.utils.hideKeyboard
import com.wahyu.starwars.utils.toast
import com.wahyu.starwars.viewmodels.FilmViewModel

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var filmViewModel: FilmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            filmViewModel = ViewModelProvider(this).get(FilmViewModel::class.java)

            binding.etSearch.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    val etTitle = binding.etSearch.text

                    if (etTitle?.isNotEmpty() == true) {
                        filmViewModel.searchFilmStarWars(etTitle.toString())
                            .observe(viewLifecycleOwner, { films ->
                                if (films.isEmpty()) {
                                    toast("Film is empty :(")
                                } else {
                                    val listFilms = films.map {
                                        "${it.title}\n\n" + "Release \t\t= ${it.releaseDate}\n" +
                                                "Director \t\t= ${it.director}\n" + "Producer \t= ${it.producer}"
                                    }

                                    binding.lvFilmSearch.adapter =
                                        ArrayAdapter(
                                            this.requireContext(),
                                            R.layout.item_film,
                                            listFilms
                                        )
                                }
                            })

                        filmViewModel.isLoading.observe(viewLifecycleOwner, {
                            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
                        })
                    } else {
                        toast("Please, enter keyword!")
                    }
                    etTitle?.clear()
                    hideKeyboard()
                    return@setOnEditorActionListener true
                }
                false
            }
        }
    }
}
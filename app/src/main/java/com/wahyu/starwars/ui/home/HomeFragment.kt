package com.wahyu.starwars.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.wahyu.starwars.R
import com.wahyu.starwars.databinding.FragmentHomeBinding
import com.wahyu.starwars.utils.toast
import com.wahyu.starwars.viewmodels.FilmViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var filmViewModel: FilmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            filmViewModel = ViewModelProvider(this).get(FilmViewModel::class.java)

            filmViewModel.films.observe(viewLifecycleOwner, { films ->
                if (films.isEmpty()) {
                    toast("Film is empty :(")
                } else {
                    val listFilms = films.map {
                        "${it.title}\n\n" + "Release \t\t= ${it.releaseDate}\n" +
                                "Director \t\t= ${it.director}\n" + "Producer \t= ${it.producer}"
                    }

                    binding.lvFilm.adapter =
                        ArrayAdapter(this.requireContext(), R.layout.item_film, listFilms)
                }
            })

            filmViewModel.isLoading.observe(viewLifecycleOwner, {
                binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
            })
        }
    }
}
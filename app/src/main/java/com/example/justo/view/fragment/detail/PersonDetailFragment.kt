package com.example.justo.view.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.justo.databinding.FragmentPersonDetailBinding
import com.example.justo.viewmodel.PersonViewModel

class PersonDetailFragment : Fragment(){

    //private val navigationArgs: PersonDetailFragmentAr by navArgs()
    private val viewModel: PersonViewModel by activityViewModels()
    lateinit var binding: FragmentPersonDetailBinding
    private var listaPersonas = PersonViewModel.listaPersonas

    private var id: Int?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonDetailBinding.inflate(inflater)
        arguments.let {
            id = (it?.getInt("id"))?: 0
        }
        id?.let { viewModel.getPersonDetails(it) }

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.locationCard.setOnClickListener { viewModel.setContentVisibility(binding.locationContents) }
        binding.datosCard.setOnClickListener { viewModel.setContentVisibility(binding.datosContents) }

    }
}
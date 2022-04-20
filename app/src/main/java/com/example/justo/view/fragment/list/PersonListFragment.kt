package com.example.justo.view.fragment.list

import android.os.Bundle
import android.os.Handler
import android.renderscript.ScriptGroup
import android.text.BoringLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.justo.R
import com.example.justo.databinding.FragmentPersonListBinding
import com.example.justo.model.data.Person
import com.example.justo.view.fragment.list.adapter.ItemAdapter
import com.example.justo.viewmodel.PersonViewModel
import java.util.zip.Inflater

class PersonListFragment : Fragment() {

    private val viewModel: PersonViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPersonListBinding.inflate(inflater)

        val adapter = ItemAdapter { persona: Person, position: Int ->

            val bundle = Bundle()

            bundle.putInt("id", position)
            this.findNavController().navigate(R.id.action_superheroListFragment_to_superheroDetailFragment, bundle)

        }

        binding.lifecycleOwner = this


        binding.viewModel = viewModel

        binding.itemsGrid.adapter = adapter

        adapter.notifyDataSetChanged()

        Handler().postDelayed({
            binding.progressCircular.visibility = View.GONE
        }, 10000)


        return binding.root
    }

    companion object{
        var band : Boolean = false
    }
}
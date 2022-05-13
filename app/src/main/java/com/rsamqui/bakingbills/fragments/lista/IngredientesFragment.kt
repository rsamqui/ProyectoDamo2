package com.rsamqui.bakingbills.fragments.lista

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rsamqui.bakingbills.R
import com.rsamqui.bakingbills.bd.adapters.IngredienteAdapter
import com.rsamqui.bakingbills.bd.viewmodels.IngredienteViewModels
import com.rsamqui.bakingbills.databinding.FragmentIngredientesBinding

class IngredientesFragment : Fragment() {
    lateinit var fBinding: FragmentIngredientesBinding

    private lateinit var viewModel : IngredienteViewModels

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        fBinding = FragmentIngredientesBinding.inflate(layoutInflater)
        val adapter = IngredienteAdapter()
        val recycleView = fBinding.RcvIngrediente
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        viewModel = ViewModelProvider(this).get(IngredienteViewModels::class.java)
        viewModel.lista.observe(viewLifecycleOwner, Observer
        {
                ingrediente -> adapter.setData(ingrediente)
        })

        setHasOptionsMenu(true)
        return fBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        with(fBinding) {
            BtnAgregarIngrediente.setOnClickListener {
                it.findNavController().navigate(R.id.ingredientes_to_add_ingredientes)
            }
        }
    }
}
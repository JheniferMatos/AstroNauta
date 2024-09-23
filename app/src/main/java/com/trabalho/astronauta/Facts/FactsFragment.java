package com.trabalho.astronauta.Facts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.trabalho.astronauta.databinding.FragmentFactsBinding;

import java.util.ArrayList;


public class FactsFragment extends Fragment {
    private FactsViewModel viewModel;
    private FragmentFactsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFactsBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(FactsViewModel.class);

        binding.factsList.setLayoutManager(new LinearLayoutManager(getContext()));
        FactsAdapter adapter = new FactsAdapter(new ArrayList<>());
        binding.factsList.setAdapter(adapter);

        viewModel.getFacts().observe(getViewLifecycleOwner(), facts -> {
            adapter.updateFacts(facts);
        });

        return binding.getRoot();
    }
}




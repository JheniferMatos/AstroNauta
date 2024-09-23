package com.trabalho.astronauta.Facts;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trabalho.astronauta.databinding.ItemFactBinding;

import java.util.List;

public class FactsAdapter extends RecyclerView.Adapter<FactsAdapter.FactViewHolder> {
    private List<Fact> facts;

    public FactsAdapter(List<Fact> facts) {
        this.facts = facts;
    }

    @NonNull
    @Override
    public FactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFactBinding binding = ItemFactBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FactViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FactViewHolder holder, int position) {
        Fact fact = facts.get(position);
        holder.bind(fact);
    }

    @Override
    public int getItemCount() {
        return facts.size();
    }

    public void updateFacts(List<Fact> newFacts) {
        this.facts = newFacts;
        notifyDataSetChanged();
    }

    class FactViewHolder extends RecyclerView.ViewHolder {
        private final ItemFactBinding binding;

        public FactViewHolder(ItemFactBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Fact fact) {
            binding.factIcon.setImageResource(fact.getIconResource());
            binding.factTitle.setText(fact.getTitle());
            binding.factDescription.setText(fact.getDescription());
        }
    }
}



package com.trabalho.astronauta;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.trabalho.astronauta.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private RecyclerView galleryGrid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Inicializa RecyclerView e define o layout em grade com 4 colunas
        galleryGrid = root.findViewById(R.id.galleryGrid);
        galleryGrid.setLayoutManager(new GridLayoutManager(getContext(), 3));

        // Cria a lista de itens da galeria (somente imagens)
        List<GalleryItem> galleryItems = createGalleryItems();

        // Configura o adapter para o RecyclerView
        GalleryAdapter adapter = new GalleryAdapter(galleryItems);
        galleryGrid.setAdapter(adapter);

        return root;
    }

    /**
     * Método para criar a lista de itens da galeria
     * @return Lista de GalleryItem
     */
    private List<GalleryItem> createGalleryItems() {
        List<GalleryItem> items = new ArrayList<>();
        items.add(new GalleryItem(R.drawable.terra));
        items.add(new GalleryItem(R.drawable.marte));
        items.add(new GalleryItem(R.drawable.jupiter));
        items.add(new GalleryItem(R.drawable.saturno));
        items.add(new GalleryItem(R.drawable.venus));
        items.add(new GalleryItem(R.drawable.netuno));
        items.add(new GalleryItem(R.drawable.urano));
        items.add(new GalleryItem(R.drawable.mercurio));
        items.add(new GalleryItem(R.drawable.alien));
        items.add(new GalleryItem(R.drawable.lua));
        items.add(new GalleryItem(R.drawable.planets));
        return items;
    }

    /**
     * Classe interna que representa um item da galeria (somente imagem)
     */
    private static class GalleryItem {
        int imageResource;

        GalleryItem(int imageResource) {
            this.imageResource = imageResource;
        }
    }

    /**
     * Adapter para o RecyclerView da galeria
     */
    private class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
        private List<GalleryItem> items;

        GalleryAdapter(List<GalleryItem> items) {
            this.items = items;
        }

        @NonNull
        @Override
        public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Inflar o layout para cada item da galeria
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);
            return new GalleryViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
            GalleryItem item = items.get(position);
            holder.imageView.setImageResource(item.imageResource);

            // Configura o clique para expandir a imagem
            holder.itemView.setOnClickListener(v -> showImageDialog(item));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        // Método para exibir o Dialog com a imagem expandida
        private void showImageDialog(GalleryItem item) {
            // Criar o Dialog com fundo transparente
            Dialog dialog = new Dialog(getContext(), R.style.TransparentDialog);
            dialog.setContentView(R.layout.dialog_image);

            // Encontrar a ImageView no layout do dialog
            ImageView expandedImage = dialog.findViewById(R.id.expandedImage);

            // Definir a imagem no dialog
            expandedImage.setImageResource(item.imageResource);

            // Exibir o Dialog
            dialog.show();
        }

        // ViewHolder para os itens da galeria (somente imagem)
        class GalleryViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            GalleryViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.galleryImage);
            }
        }
    }
}

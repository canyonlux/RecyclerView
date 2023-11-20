package com.example.recyclerview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adaptador personalizado para el RecyclerView
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<Integer> images;
    private ImageSwitcher imageSwitcher;

    // Constructor del adaptador
    public MyAdapter(Context context, List<Integer> images, ImageSwitcher imageSwitcher) {
        this.context = context;
        this.images = images;
        this.imageSwitcher = imageSwitcher;
    }

    // Crea nuevas vistas (invocado por el layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }
    // Reemplaza el contenido de una vista (invocado por el layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Establece la imagen para el ImageView basado en la posición en la lista
        holder.imageView.setImageResource(images.get(position));
        // Configura un OnClickListener para cada ImageView
        holder.imageView.setOnClickListener(v -> {
            // Cambia la imagen del ImageSwitcher a la imagen seleccionada
            imageSwitcher.setImageResource(images.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
    // Proporciona una referencia a las vistas para cada ítem de datos
    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

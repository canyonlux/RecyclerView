package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Declaración de variables para el RecyclerView, el adaptador, la lista de imágenes y el ImageSwitcher
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Integer> imageList;
    private ImageSwitcher imageSwitcher;
    // Método onCreate se ejecuta cuando se crea la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inicializa el ImageSwitcher y establece su fábrica de vistas
        imageSwitcher = findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(() -> {
            ImageView imageView = new ImageView(getApplicationContext());
            return imageView;
        });
        // Inicializa el RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        // Inicializa la lista de imágenes y agrega imágenes
        imageList = new ArrayList<>();
        imageList.add(R.drawable.image1);
        imageList.add(R.drawable.image2);
        imageList.add(R.drawable.image3);
        imageList.add(R.drawable.image4);
        imageList.add(R.drawable.image5);
        imageList.add(R.drawable.image6);
        imageList.add(R.drawable.image7);
        imageList.add(R.drawable.image8);
        imageList.add(R.drawable.image9);
        imageList.add(R.drawable.image10);

        // Inicializa el adaptador
        adapter = new MyAdapter(this, imageList, imageSwitcher);

        // Configura el RecyclerView con un LinearLayoutManager horizontal y establece su adaptador
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }
}



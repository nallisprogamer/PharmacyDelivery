package com.example.diskremedio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diskremedio.Pattern.CategoriaMain;
import com.example.diskremedio.R;

import java.util.List;

public class AdapterCategorias extends RecyclerView.Adapter<AdapterCategorias.meuViewholder> {
    Context context;
    List<CategoriaMain> categorias;

    public AdapterCategorias(Context context, List<CategoriaMain> lista) {
        this.context = context;
        this.categorias = lista;


    }

    @NonNull
    @Override
    public meuViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categoriapattern, null, false);
        return new meuViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull meuViewholder holder, int position) {
        holder.img.setImageResource(categorias.get(position).getImg());
        holder.txt.setText(categorias.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public class meuViewholder extends RecyclerView.ViewHolder {
        TextView txt;
        ImageView img;

        public meuViewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.categoria_img_pattern);
            txt = itemView.findViewById(R.id.categoria_txt_pattern);
        }
    }

}

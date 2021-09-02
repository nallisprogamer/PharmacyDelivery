package com.example.diskremedio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diskremedio.Pattern.Artigospattern;
import com.example.diskremedio.R;

import java.util.List;

public class AdapterArtigos extends RecyclerView.Adapter<AdapterArtigos.meuViewholder> {

    Context context;
    List<Artigospattern> categorias;

    public AdapterArtigos(Context context, List<Artigospattern> lista) {
        this.context = context;
        this.categorias = lista;


    }

    @NonNull
    @Override
    public meuViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.artigospattern, null, false);
        return new meuViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull meuViewholder holder, int position) {
        holder.img.setImageResource(categorias.get(position).getImg());
        holder.txt.setText(categorias.get(position).getText());
        holder.subtxt.setText(categorias.get(position).getSubtext());
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public class meuViewholder extends RecyclerView.ViewHolder {
        TextView txt;
        TextView subtxt;
        ImageView img;

        public meuViewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.artigos_img_pattern);
            txt = itemView.findViewById(R.id.artigos_txt_pattern);
            subtxt = itemView.findViewById(R.id.artigos_txt2_pattern);
        }
    }

}



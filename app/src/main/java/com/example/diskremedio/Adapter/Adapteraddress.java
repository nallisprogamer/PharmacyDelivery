package com.example.diskremedio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diskremedio.Pattern.Addrespattern;
import com.example.diskremedio.R;

import java.util.ArrayList;

public class Adapteraddress extends RecyclerView.Adapter<Adapteraddress.meuViewHolder> {
    Context context;
    ArrayList<Addrespattern> list;

    public Adapteraddress(Context context, ArrayList<Addrespattern> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public meuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rowaddress, null, false);
        return new meuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull meuViewHolder holder, int position) {
        holder.address.setText(list.get(position).getEndereco());
        holder.nome_address.setText(list.get(position).getNome_endereco());
        if (list.get(position).getifselected().equals("on")) {
            holder.img.setImageResource(R.drawable.on_point);
        } else {
            holder.img.setImageResource(R.drawable.out_point);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class meuViewHolder extends RecyclerView.ViewHolder {
        TextView nome_address;
        TextView address;
        ImageView img;

        public meuViewHolder(@NonNull View itemView) {
            super(itemView);
            nome_address = itemView.findViewById(R.id.apelido_endereco);
            address = itemView.findViewById(R.id.nome_endereco);
            img = itemView.findViewById(R.id.img_ifselected);
        }
    }
}
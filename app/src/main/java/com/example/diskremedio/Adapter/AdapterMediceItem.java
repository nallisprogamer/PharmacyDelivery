

package com.example.diskremedio.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diskremedio.DetalhesActivity;
import com.example.diskremedio.Pattern.MedicineItemPattern;
import com.example.diskremedio.R;


import java.util.ArrayList;


public class AdapterMediceItem extends RecyclerView.Adapter<AdapterMediceItem.meuViewHolder> {
    Context context;
    ArrayList<MedicineItemPattern> lista;

    public AdapterMediceItem(Context context, ArrayList<MedicineItemPattern> list) {
        this.context = context;
        lista = list;
    }

    @NonNull
    @Override
    public meuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rowmedicineitem, null, false);
        return new meuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull meuViewHolder holder, int position) {

        MedicineItemPattern mip = lista.get(position);


        holder.parent_rowmedicineitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent a = new Intent(context, DetalhesActivity.class);
                a.putExtra("nome",mip.getNome());
                a.putExtra("modelo",mip.getModelo());
                a.putExtra("fabricante",mip.getFabricante());
                a.putExtra("preco",mip.getFabricante());
                a.putExtra("preco_original",mip.getPreco_original());
                a.putExtra("quant_cartela",mip.getQuant_cartela());
                a.putExtra("quant_per_cx",mip.getQuant_per_cx());
                a.putExtra("usosindicados",mip.getUsosindicados());
                a.putExtra("usosNindicados",mip.getUsosNindicados());
                a.putExtra("id",mip.getId());
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(a);
            }
        });
        holder.fabricante_remedio.setText(mip.getFabricante());
        holder.nome_remedio.setText(mip.getNome());
        holder.modelo_remedio.setText(mip.getModelo());
        holder.preco_remedio.setText(context.getString(R.string.unidademontaria) + mip.getDesconto());
        holder.Quant_per_cx.setText(mip.getQuant_per_cx() + " p/crt");
        if (!mip.getPreco_original().equals("0")) {

            holder.preco_original_remedio.setPaintFlags(holder.preco_original_remedio.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.preco_original_remedio.setText(context.getString(R.string.unidademontaria) + mip.getPreco_original());
        } else {

            holder.preco_original_remedio.setVisibility(View.GONE);
        }

//        holder.quant_cartela.setText(mip.getQuant_remedio());//no main não vai se usado, mas deixar para ser usado para a cartActivity
//        holder.lessbutton.setOnClickListener(v -> {
//            String value_before = (String) holder.quant_cartela.getText();
//            if (!value_before.equals("1")&&!value_before.equals("0")) {
//                int value_after = Integer.parseInt(value_before) - 1;
//                holder.quant_cartela.setText("" + value_after);
//                sqlite.getINSTANCE(context).deleteItemlistCarrinho(mip.getid());
//                mip.setQuant_remedio(""+value_after);
//            }else{
//                holder.quant_cartela.setText("0");
//            }
//        });

//        holder.morebutton.setOnClickListener(v -> {
//            String value_before = (String) holder.quant_cartela.getText();
//            int value_after = Integer.parseInt(value_before) + 1;
//            mip.setQuant_remedio(""+value_after);
//            holder.quant_cartela.setText("" + value_after);
//            holder.addtocard(mip);
//
//        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class meuViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout parent_rowmedicineitem;
        TextView nome_remedio;
        TextView modelo_remedio;
        TextView quant_medicine_cart;
        TextView fabricante_remedio;
        TextView preco_remedio;
        TextView preco_original_remedio;
        TextView Quant_per_cx;

        public meuViewHolder(@NonNull View itemView) {
            super(itemView);
//insert into Produtos(idinterno,nome_remedio,modelo_remedio,fabricante_remedio,preco_original_remedio,preco_remedio)values
//('2','Dorflex','analgésico','ultrafarma','R$ 23,99','R$ 13,90')
            nome_remedio = itemView.findViewById(R.id.name_medicine);
            parent_rowmedicineitem = itemView.findViewById(R.id.parent_rowmedicineitem);
            quant_medicine_cart = itemView.findViewById(R.id.quant_medicine_cart);
            modelo_remedio = itemView.findViewById(R.id.name_modelo);
            Quant_per_cx = itemView.findViewById(R.id.Quant_per_cx);
            fabricante_remedio = itemView.findViewById(R.id.nome_factory);
            preco_remedio = itemView.findViewById(R.id.nome_value);
            preco_original_remedio = itemView.findViewById(R.id.nome_value_no_discount);


        }

//        private void addtocard(MedicineItemPattern mip) {
//            sqlite.getINSTANCE(context).addlistcarrinho(String.valueOf(System.currentTimeMillis()).substring(5), mip.getNome_remedio(),
//                    mip.getModelo_remedio(), mip.getFabricante_remedio(), mip.getPreco_remedio(), mip.getPreco_original_remedio(),
//                    mip.getQuant_remedio(), mip.getquant_per_cx());
//        }
    }

}

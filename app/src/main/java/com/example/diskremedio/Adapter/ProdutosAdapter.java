package com.example.diskremedio.Adapter;
//arrumar o price
//falar com o jean

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diskremedio.DetalhesActivity;
import com.example.diskremedio.Pattern.MedicineItemPattern;
import com.example.diskremedio.Pattern.Price;
import com.example.diskremedio.R;

import java.util.List;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.meuViewholdere> {
    private Context context;
    private final List<MedicineItemPattern> arrayList;

    public ProdutosAdapter(Context context, List<MedicineItemPattern> collectEventByDate) {
        this.context = context;
        this.arrayList = collectEventByDate;

    }


    @NonNull
    @Override
    public ProdutosAdapter.meuViewholdere onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.capa_produto, parent, false);
        context = view.getContext();
        return new meuViewholdere(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutosAdapter.meuViewholdere holder, int position) {
        MedicineItemPattern mip = arrayList.get(position);
        holder.setData(mip);
        holder.ivfotoProduto.setImageBitmap(StringToBitMap(arrayList.get(position).getBitmapImg()));
        holder.parent_item_remedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(context, DetalhesActivity.class);
                a.putExtra("nome",mip.getNome());
                a.putExtra("modelo",mip.getModelo());
                a.putExtra("fabricante",mip.getFabricante());
                a.putExtra("desconto",mip.getDesconto());
                a.putExtra("preco_original",mip.getPreco_original());
                a.putExtra("quant_cartela",mip.getQuant_cartela());
                a.putExtra("quant_per_cx",mip.getQuant_per_cx());
                a.putExtra("id",mip.getId());
                a.putExtra("usosindicados",mip.getUsosindicados());
                a.putExtra("usosNindicados",mip.getUsosNindicados());
                a.putExtra("quant_produto",mip.getQuant_produto());
                a.putExtra("imgbitmap",mip.getBitmapImg());
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(a);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class meuViewholdere extends RecyclerView.ViewHolder {

        private final ImageView ivfotoProduto;
        private final TextView tvnomeProduto;
        private final LinearLayout llDiscountIV;
        private final RelativeLayout parent_item_remedio;
        private final TextView tvNumberPercentOffer;
        private final TextView tvPriceCurrent;
        private final TextView tvPriceWithoutDiscount;


        public meuViewholdere(@NonNull View itemView) {
            super(itemView);
            ivfotoProduto = itemView.findViewById(R.id.iv_model);
            tvnomeProduto = itemView.findViewById(R.id.tv_model);
            parent_item_remedio = itemView.findViewById(R.id.parent_item_remedio);

            llDiscountIV = itemView.findViewById(R.id.ll_discount);
            tvNumberPercentOffer = itemView.findViewById(R.id.tv_discount);
            tvPriceCurrent = itemView.findViewById(R.id.tv_price_current);
            tvPriceWithoutDiscount = itemView.findViewById(R.id.tv_price_without_discount);

        }

        void setData(MedicineItemPattern produto) {
            tvnomeProduto.setText(produto.getNome());
            String a = produto.getPreco_original().replaceAll("[R$]", "").replace(",", ".").replace(" ", "").trim();
            String b = produto.getDesconto().replaceAll("[R$]", "").replace(",", ".").replace(" ", "").trim();
            if (b.isEmpty()) {
                b = "00";
            }
            setPrice(new Price(Float.parseFloat(a.substring(1)),
                    1,
                    !produto.getPreco_original().equals("R$ 0,00"),
                    Float.parseFloat(b.substring(1))));

        }

        void setPrice(Price price) {


            if (price.setemdesconto) {
                llDiscountIV.setVisibility(View.VISIBLE);
                tvPriceWithoutDiscount.setVisibility(View.VISIBLE);

                tvPriceCurrent.setText(price.getDiscount(context));
                tvPriceWithoutDiscount.setText(price.getDesconto(context));
                tvNumberPercentOffer.setText(price.getPercentNumber());
                System.out.println(" tem disconto");
            } else {
                System.out.println("nao tem disconto");
                llDiscountIV.setVisibility(View.GONE);
                tvPriceWithoutDiscount.setVisibility(View.GONE);

                tvPriceCurrent.setText(price.getDesconto(context));
            }
        }

    }

    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }

    }
}






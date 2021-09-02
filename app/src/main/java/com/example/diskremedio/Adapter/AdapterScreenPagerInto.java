package com.example.diskremedio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.diskremedio.Pattern.ScreenPagerPattern;
import com.example.diskremedio.R;

import java.util.List;

public class AdapterScreenPagerInto extends PagerAdapter {
    List<ScreenPagerPattern> lista;
    Context context;
    public AdapterScreenPagerInto(List<ScreenPagerPattern>lista,Context context) {
        this.context = context;
        this.lista=lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.remedio_onboarding,null);
        Button bnt_avancar =layoutScreen.findViewById(R.id.bnt_search_iniciar);
        TextView titulo =layoutScreen.findViewById(R.id.title_txt_onboarding);
        TextView qunat_of_quant =layoutScreen.findViewById(R.id.qunat_of_quant);
        TextView descicao =layoutScreen.findViewById(R.id.descricao_txt_onboarding);
        titulo.setText(lista.get(position).getTitle());
        if(lista.size()>1){
        qunat_of_quant.setText(position+R.string.of+lista.size());}else{
            qunat_of_quant.setText(R.string.skip);
            qunat_of_quant.setOnClickListener(v -> {
            });
        }
        descicao.setText(lista.get(position).getTitle());
        container.addView(layoutScreen);
        bnt_avancar.setOnClickListener(v -> {

        });
        return layoutScreen;
    }
}

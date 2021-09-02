package com.example.diskremedio.Pattern;

import android.content.Context;

import com.example.diskremedio.R;

import java.util.Locale;

public class Price {
    float semdisconto;
    int parcelas;
    public boolean setemdesconto;
    float comDisconto;

    public Price(float semdisconto, int parcelas, boolean setemdesconto, float comDisconto) {
        this.semdisconto = semdisconto;
        this.parcelas = parcelas;
        this.setemdesconto = setemdesconto;
        this.comDisconto = comDisconto;
    }

    public String getDesconto(Context context){
        return String.format(Locale.GERMAN,"%s %.2f",context.getString(R.string.money_sing), semdisconto);
    }
    public String getDiscount(Context context){
        return String.format(Locale.GERMAN,"%s %.2f",context.getString(R.string.money_sing), comDisconto);
    }
    public String getPercentNumber(){
        Float percent = ((semdisconto-comDisconto)/ semdisconto)*100;
        return String.format("%s%%", Integer.valueOf(String.valueOf(percent.intValue())));    }

}




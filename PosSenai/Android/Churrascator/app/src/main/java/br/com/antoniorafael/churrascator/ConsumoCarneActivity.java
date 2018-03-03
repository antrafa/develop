package br.com.antoniorafael.churrascator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;

import java.io.Serializable;

public class ConsumoCarneActivity extends ActionBarActivity {

    NumberPicker consumoCarne;
    int multiplicador = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumo_carne);

        consumoCarne = (NumberPicker) findViewById(R.id.consumoCarne);
        consumoCarne.setMinValue(1);
        consumoCarne.setMaxValue(20);

        NumberPicker.Formatter formatter = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                int temp = value * multiplicador;
                return "" + temp;
            }
        };
        consumoCarne.setFormatter(formatter);

    }

    public void proximo(View tela){

        Integer valor = consumoCarne.getValue() * multiplicador;

        Churrasco churras = Churrasco.getInstance();
        churras.setCarne(valor);

        Intent intencao = new Intent(this,ConsumoLinguicaActivity.class);
        intencao.putExtra("churrasco",churras);
        startActivity(intencao);

    }

}

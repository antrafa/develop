package br.com.antoniorafael.churrascator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;

public class ConsumoLinguicaActivity extends ActionBarActivity {

    NumberPicker consumoLinguica;
    int multiplicador = 1;
    Churrasco params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumo_linguica);

        params = (Churrasco) getIntent().getSerializableExtra("churrasco");

        Log.i("logs",params.getCarne().toString());

        consumoLinguica = (NumberPicker) findViewById(R.id.consumoLinguica);
        consumoLinguica.setMinValue(1);
        consumoLinguica.setMaxValue(20);

        NumberPicker.Formatter formatter = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                int temp = value * multiplicador;
                return "" + temp;
            }
        };
        consumoLinguica.setFormatter(formatter);

    }

    public void proximo(View tela){

        Integer valor = consumoLinguica.getValue() * multiplicador;

        params.setLinguica(valor);

        Intent intencao = new Intent(this,ConsumoRefriActivity.class);
        intencao.putExtra("churrasco",params);
        startActivity(intencao);

    }


}

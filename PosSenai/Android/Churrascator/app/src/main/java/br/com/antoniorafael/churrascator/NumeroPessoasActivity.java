package br.com.antoniorafael.churrascator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;

public class NumeroPessoasActivity extends ActionBarActivity {

    NumberPicker numeroPessoas;
    int multiplicador = 1;
    Churrasco params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero_pessoas);

        params = (Churrasco) getIntent().getSerializableExtra("churrasco");

        Log.i("logs", params.getCarne().toString());
        Log.i("logs",params.getLinguica().toString());
        Log.i("logs",params.getRefrigerante().toString());

        numeroPessoas = (NumberPicker) findViewById(R.id.numeroPessoas);
        numeroPessoas.setMinValue(1);
        numeroPessoas.setMaxValue(40);

        NumberPicker.Formatter formatter = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                int temp = value * multiplicador;
                return "" + temp;
            }
        };
        numeroPessoas.setFormatter(formatter);

    }

    public void proximo(View tela){

        Integer valor = numeroPessoas.getValue() * multiplicador;

        params.setPessoas(valor);

        Intent intencao = new Intent(this,ResultadoActivity.class);
        intencao.putExtra("churrasco", params);
        startActivity(intencao);

    }
}

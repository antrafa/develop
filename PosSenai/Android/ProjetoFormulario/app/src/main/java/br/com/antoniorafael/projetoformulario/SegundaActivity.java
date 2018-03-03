package br.com.antoniorafael.projetoformulario;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Bundle dados = getIntent().getExtras();

        if(dados != null){
            String nome = dados.getString("nome");
            Toast.makeText(this,nome,Toast.LENGTH_LONG).show();

            TextView nomeTextview = (TextView) findViewById(R.id.nome_text);
            nomeTextview.setText(nome);
        }
    }
}

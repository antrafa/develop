package br.com.antoniorafael.projetoformulario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button btnSalvar;
    EditText campoNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = (EditText) findViewById(R.id.nome);
        btnSalvar = (Button) findViewById(R.id.botao);

        // this, exemplo implementando a interface
        btnSalvar.setOnClickListener(this);

        /*
        //Exemplo sem implentar interface

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

    }

    @Override
    public void onClick(View v) {
        // toString porque ele retorna um Editable
        String nome = campoNome.getText().toString();

        Intent intencao = new Intent(this,SegundaActivity.class);
        intencao.putExtra("nome", nome);
        startActivity(intencao);

    }
}

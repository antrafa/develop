package br.com.antoniorafael.segundoprojeto;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SegundaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        // recebendo parametros da activity anterior
        Bundle params = getIntent().getExtras();

        if(params != null){
            String mensagem = params.getString("mensagem");
            TextView textView = (TextView) findViewById(R.id.mensagem_tela2);
            textView.setText(mensagem);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_segunda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_finalizar) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

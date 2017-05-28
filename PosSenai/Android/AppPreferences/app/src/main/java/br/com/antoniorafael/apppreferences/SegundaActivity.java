package br.com.antoniorafael.apppreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class SegundaActivity extends ActionBarActivity {

    String nome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences preferences = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        nome = preferences.getString("nome", "Antonio");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Teste", "Lendo " + nome);
        Toast.makeText(this, nome, Toast.LENGTH_SHORT).show();
    }
}

package br.com.antoniorafael.todo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.antoniorafael.todo.dao.TarefaDAO;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private Tarefa tarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,CadastrarTarefaActivity.class);
                startActivity(i);
            }
        });

        lista = (ListView) findViewById(R.id.lista_tarefas);
        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //pegando a tarefa clicada (botão deletar da tarefa)
                tarefa = (Tarefa) parent.getItemAtPosition(position);
                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
        registerReceiver(broadcastAtualizar,new IntentFilter("ATUALIZAR_LISTAGEM"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastAtualizar);
    }

    public void atualizarLista(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final TarefaDAO dao = new TarefaDAO(MainActivity.this);
                final List<Tarefa> tarefas = dao.getLista();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<Tarefa> adapter = new ArrayAdapter<Tarefa>(MainActivity.this, android.R.layout.simple_list_item_1,tarefas);
                        lista.setAdapter(adapter);
                    }
                });

                dao.close();
            }
        }).start();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("Excluir");
        //MenuItem detalhes = menu.add("Detalhes");

        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        TarefaDAO dao = new TarefaDAO(MainActivity.this);
                        dao.excluir(tarefa);

                        Intent it = new Intent("ABRIR_TAREFA_AGENDADA");
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,(int) tarefa.getId(),it,PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarme = (AlarmManager) MainActivity.this.getSystemService(Context.ALARM_SERVICE);
                        alarme.cancel(pendingIntent);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Tarefa excluida", Toast.LENGTH_SHORT).show();
                                atualizarLista();
                            }
                        });

                        dao.close();

                    }
                }).start();

                return false;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private BroadcastReceiver broadcastAtualizar = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            atualizarLista();
        }
    };
}

package br.com.antoniorafael.todo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import br.com.antoniorafael.todo.dao.TarefaDAO;

/**
 * Created by AntRafa on 23/10/15.
 */
//CHAMADA PALO BROADCAST "NOTICIACAO_TAREFA_CLICADA",
//QUANDO O USUÁRIO CLICA NA NOTIFICAÇÃO QUE APARECEU
public class UsuarioNotificado extends BroadcastReceiver {

    private static Tarefa tarefa;

    @Override
    public void onReceive(final Context context, Intent intent) {

        tarefa = (Tarefa) intent.getExtras().get("tarefa");

        new Thread(new Runnable() {
            @Override
            public void run() {
                TarefaDAO dao = new TarefaDAO(context);
                dao.excluir(UsuarioNotificado.tarefa);
                dao.close();
                //lançando para atualizar listagem da MainActivity
                context.sendBroadcast(new Intent("ATUALIZAR_LISTAGEM"));
            }
        }).start();

    }
}

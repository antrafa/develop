package br.com.antoniorafael.todo;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class NotificarUsuario extends BroadcastReceiver {

    //SERÁ CHAMADA PELO BROADCAST "ABRIR_TAREFA_AGENDADA" DISPARADO PELO ALARME

    private static Tarefa tarefa;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {

        //Recuperando a tarefa enviada pelo alarm
        tarefa = (Tarefa) intent.getExtras().get("tarefa");

        //CRIANDO O BROADCAST PARA EXCLUIR A TAREFA
        Intent it = new Intent("NOTICIACAO_TAREFA_CLICADA");
        it.putExtra("tarefa", tarefa);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,(int) tarefa.getId(),it,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new Notification.Builder(context)
                .setTicker("Você tem uma nova tarefa!")
                .setContentTitle(tarefa.getTitulo())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(tarefa.getDescricao())
                .setContentIntent(pendingIntent)
                .setWhen(tarefa.getData())
                .setAutoCancel(true)
                .build();

        notificationManager.notify((int) tarefa.getId(), notification);

    }
}
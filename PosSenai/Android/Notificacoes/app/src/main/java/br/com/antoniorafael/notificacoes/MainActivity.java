package br.com.antoniorafael.notificacoes;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, ExecutarNotificacao.class), 0);

        //Disparando broadcast
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, new Intent("DISPARANDO_BROADCAST"),0);

        Notification n = new Notification.Builder(this)
                                .setTicker("Aqui vai um Broadcast")
                                .setContentText("Aqui vai a mensagem da notificação")
                                .setContentTitle("Aqui vai o titulo do conteudo")
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setWhen(System.currentTimeMillis())
                                .setContentIntent(pi)
                                .setPriority(Notification.PRIORITY_MAX)
                                .setVibrate(new long[0])
                                .build();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.notify(R.string.app_name,n);

        Toast.makeText(this,"Notificação criada",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(this.myReceiver, new IntentFilter("DISPARANDO_BROADCAST"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.myReceiver);
    }

    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"Recebendo Broad na notificação",Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

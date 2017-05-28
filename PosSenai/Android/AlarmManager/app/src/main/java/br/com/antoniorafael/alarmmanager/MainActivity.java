package br.com.antoniorafael.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciar(View v){
        agendarParaDezSegundos();
    }

    public void parar(View v){
        cancelarAgendamento();
        Log.i("Teste", "Cancelando");
    }

    public void agendarParaDezSegundos(){
        Intent it = new Intent(this,MyReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this,0,it,PendingIntent.FLAG_UPDATE_CURRENT);

        long dezSegundos = System.currentTimeMillis() + 2000;
        int trintaSegundos = 5 * 1000;

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //alarmManager.set(AlarmManager.RTC_WAKEUP,dezSegundos,pi);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,dezSegundos,trintaSegundos,pi);

    }

    private void cancelarAgendamento(){
        Intent it = new Intent(this,MyReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this,0,it,PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pi);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Teste", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Teste", "onDestroy");
        cancelarAgendamento();
    }
}

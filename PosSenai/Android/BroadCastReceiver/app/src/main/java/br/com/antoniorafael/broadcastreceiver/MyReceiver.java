package br.com.antoniorafael.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Recebendo broadcast",Toast.LENGTH_SHORT).show();

        /*ABRINDO UMA NOVA INTENT NO RECEIVER
        Intent i = new Intent(context, AbrindoBroadcast.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);*/
    }

}

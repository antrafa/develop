package br.com.antoniorafael.churrascatorpreferences;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashScreenActivity extends Activity {

    Handler handler = new SplashScreenHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler.sendMessageDelayed(new Message(),3000);

    }

    private class SplashScreenHandler extends Handler {

        public void handleMessage(Message msg){
            Intent i = new Intent(SplashScreenActivity.this,InicialActivity.class);
            startActivity(i);
            finish();
            
        }

    }
}

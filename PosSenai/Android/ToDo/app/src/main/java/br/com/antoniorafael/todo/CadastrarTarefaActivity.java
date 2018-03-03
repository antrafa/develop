package br.com.antoniorafael.todo;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import br.com.antoniorafael.todo.dao.TarefaDAO;

public class CadastrarTarefaActivity extends AppCompatActivity {

    int ano, mes, dia, hora, minuto;
    static final int DATA_ID = 0;
    static final int HORARIO_ID = 1;

    private TextView tituloText;
    private TextView descricaoText;
    private TextView dataText;
    private TextView horarioText;

    private Tarefa tarefa = new Tarefa();
    private Calendar cal = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_tarefa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //INICIANDO COM AS DATAS
        ano = cal.get(Calendar.YEAR);
        mes = cal.get(Calendar.MONTH) + 1;
        dia = cal.get(Calendar.DAY_OF_MONTH);
        hora = cal.get(Calendar.HOUR_OF_DAY);
        minuto = cal.get(Calendar.MINUTE);

        //BOTOES
        Button btnData = (Button) findViewById(R.id.btnData);
        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATA_ID);
            }
        });

        Button btnHorario = (Button) findViewById(R.id.btnHorario);
        btnHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(HORARIO_ID);
            }
        });

        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarTarefa();
            }
        });

        //PEGANDO CAMPOS DE TEXTO
        tituloText = (TextView) findViewById(R.id.titulo);
        descricaoText = (TextView) findViewById(R.id.descricao);
        dataText = (TextView) findViewById(R.id.data);
        horarioText = (TextView) findViewById(R.id.horario);

        //ESCREVENDO DATA E HORARIO INICIAL
        dataText.setText(editarValor(dia) + "/" + editarValor(mes) + "/" + editarValor(ano));
        horarioText.setText(editarValor(hora) + ":" + editarValor(minuto));

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        int mesTemp = mes - 1;
        if(id == DATA_ID)
            return new DatePickerDialog(CadastrarTarefaActivity.this,dateListener,ano,mesTemp,dia);
        if(id == HORARIO_ID)
            return new TimePickerDialog(CadastrarTarefaActivity.this,horarioListener,hora,minuto,false);
        return null;
    };

    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            ano = year;
            mes = monthOfYear + 1;
            dia = dayOfMonth;
            dataText.setText(editarValor(dia) + "/" + editarValor(mes) + "/" + ano);
        }
    };

    private TimePickerDialog.OnTimeSetListener horarioListener = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hora = hourOfDay;
            minuto = minute;
            horarioText.setText(editarValor(hora)+":"+editarValor(minuto));
        }
    };

    //ARRUMANDO VALOR PARA SER MOSTRADO, COM ZERO
    private String editarValor(int valor){
        String val = "";
        if(valor < 10){
            val = "0" + String.valueOf(valor);
            return val;
        }else{
            return String.valueOf(valor);
        }

    };

    //CADASTRAR TAREFA
    private void cadastrarTarefa(){
        int mesTemp = mes - 1;
        cal.set(ano, mesTemp, dia, hora, minuto);
        cal.set(Calendar.SECOND, 0);//tirando os segundos, para ser preciso no minuto

        tarefa.setData(cal.getTimeInMillis());
        tarefa.setTitulo(tituloText.getText().toString());
        tarefa.setDescricao(descricaoText.getText().toString());
        //tarefa.setData(Long.valueOf(tarefa.getData()));

        new Thread(new Runnable() {
            @Override
            public void run() {

                TarefaDAO dao = new TarefaDAO(CadastrarTarefaActivity.this);
                tarefa.setId(dao.inserir(tarefa));//já setando o id dessa tarefa
                dao.close();

                // Alarme
                Intent it = new Intent("ABRIR_TAREFA_AGENDADA");
                it.putExtra("tarefa", tarefa);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(CadastrarTarefaActivity.this, (int) tarefa.getId(), it, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, tarefa.getData(), pendingIntent);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                });
            }
        }).start();

    }

}
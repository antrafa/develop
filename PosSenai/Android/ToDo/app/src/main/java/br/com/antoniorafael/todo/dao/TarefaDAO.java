package br.com.antoniorafael.todo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.antoniorafael.todo.Tarefa;

/**
 * Created by AntRafa on 12/10/15.
 */
public class TarefaDAO extends SQLiteOpenHelper{

    private static final String DATABASE = "ListaTarefas";
    private static final int VERSAO = 1;
    private static final String TABELA = "tarefas";

    public TarefaDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ TABELA + "("
                    + " id INTEGER PRIMARY KEY, "
                    + "titulo TEXT, "
                    + "descricao TEXT, "
                    + "data INTEGER"
                    + ");";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        db.execSQL(sql);
        onCreate(db);
    }

    public long inserir(Tarefa tarefa){
        ContentValues cv = new ContentValues();
        cv.put("titulo",tarefa.getTitulo());
        cv.put("descricao",tarefa.getDescricao());
        cv.put("data", tarefa.getData());

        return getWritableDatabase().insert(TABELA, null, cv);
    }

    public void excluir(Tarefa tarefa) {
        String[] args = {String.valueOf(tarefa.getId())};
        getWritableDatabase().delete(TABELA, "id=?", args);
    }

    public List<Tarefa> getLista(){
        List<Tarefa> tarefas = new ArrayList<Tarefa>();

        String sql = "SELECT * FROM " + TABELA + ";";
        Cursor c = getReadableDatabase().rawQuery(sql,null);

        while (c.moveToNext()){
            Tarefa tarefa = new Tarefa();
            tarefa.setId(c.getInt(c.getColumnIndex("id")));
            tarefa.setTitulo(c.getString(c.getColumnIndex("titulo")));
            tarefa.setDescricao(c.getString(c.getColumnIndex("descricao")));
            tarefa.setData(c.getLong(c.getColumnIndex("data")));

            tarefas.add(tarefa);
        }

        return tarefas;
    }

}

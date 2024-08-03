package com.example.myapplication1.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private Context context;
    private DbHelper DbHelper;
    private SQLiteDatabase db;

    public DbManager (Context context) {
        this.context = context;
        DbHelper = new DbHelper(this.context);
    }
    public void openDb()
    {
        db = DbHelper.getWritableDatabase();
    }

    public void insertToDb(String name, String description) {
        ContentValues cv = new ContentValues();
        cv.put(CostantasDB.NAME, name);
        cv.put(CostantasDB.DESCRIPTION, description);
        db.insert(CostantasDB.TABLE_NAME, null, cv);
    }
    public List<String> getFromDb(){
        List<String> templist = new ArrayList<>();
        String columns[] = {CostantasDB.NAME};
        Cursor cursor = db.query(CostantasDB.TABLE_NAME,
                columns, null,null,null,null,null);

        int nameColumnIndex = cursor.getColumnIndex(CostantasDB.NAME);
        if (nameColumnIndex >= 0) {
            while (cursor.moveToNext()){
                String name = cursor.getString(nameColumnIndex);
                templist.add(name);
            }
        }
        cursor.close();
        return templist;
    }

    public List<Integer> getFromDbProteins(){
        List<Integer> templist = new ArrayList<>();
        String columns[] = {Integer.toString(CostantasDB.PROTEIN), Integer.toString(CostantasDB.PROTEIN)};
        Cursor cursor = db.query(CostantasDB.TABLE_NAME,
                columns, null,null,null,null,null);

        int nameColumnIndex = cursor.getColumnIndex(Integer.toString(CostantasDB.PROTEIN));
        if (nameColumnIndex >= 0) {
            while (cursor.moveToNext()){
                Integer proteins = cursor.getInt(nameColumnIndex);
                templist.add(proteins);
            }
        }
        cursor.close();
        return templist;
    }



    public void closeDb(){
        DbHelper.close();
    }
}

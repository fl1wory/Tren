package com.example.myapplication1.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
        db.execSQL(CostantasDB.TABLE_STRUCTURE);
    }

    public void insertToDb(String name, Integer protein, Integer fat, Integer carbohydrates) {
        ContentValues cv = new ContentValues();
        cv.put(CostantasDB.NAME, name);
        cv.put(CostantasDB.PROTEIN, protein);
        cv.put(CostantasDB.FAT, fat);
        cv.put(CostantasDB.CARBOHYDRATES, carbohydrates);
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

    public List<Integer> getFromDb(String columnName){
        List<Integer> templist = new ArrayList<>();
        db = DbHelper.getReadableDatabase();
        db.execSQL(CostantasDB.TABLE_STRUCTURE);
        Cursor cursor = db.rawQuery("SELECT " + columnName + " FROM " + CostantasDB.TABLE_NAME, null);

        int columnIndex = cursor.getColumnIndex(columnName);
        System.out.println(columnIndex);

        if (columnIndex >= 0 && cursor.moveToFirst()) {
            do {
                templist.add(cursor.getInt(columnIndex));
                System.out.println(templist);
            } while (cursor.moveToNext());
        } else {
            // Log an error message or throw an exception if the cursor is empty
            Log.e("Database", "Cursor is empty");
        }

        cursor.close();
        return templist;
    }




    public void closeDb(){
        DbHelper.close();
    }
}

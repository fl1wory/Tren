package com.example.myapplication1.DatabaseHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import java.util.ArrayList;

public class DatabaseHelper {
    private static final String DATABASE_NAME = "your_database_name";
    private static final String TABLE_NAME = "productsCurrent";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PROTEINS = "proteins";
    private static final String COLUMN_FATS = "fats";
    private static final String COLUMN_CARBOHYDRATES = "carbohydrates";


    private SQLiteDatabase database;

    public DatabaseHelper(Context context) {
        database = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
        createTableIfNotExists();
    }


    private void createTableIfNotExists() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + COLUMN_NAME + " TEXT, "
                + COLUMN_PROTEINS + " INTEGER, "
                + COLUMN_FATS + " INTEGER, "
                + COLUMN_CARBOHYDRATES + " INTEGER)";
        database.execSQL(createTableQuery);
    }

    public ArrayList<ArrayList> setProductData()
    {
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = database.rawQuery(selectQuery, null);

        ArrayList<Integer> proteins = new ArrayList<>();
        ArrayList<Integer> fats = new ArrayList<>();
        ArrayList<Integer> carbohydrates = new ArrayList<>();


        proteins.clear();
        fats.clear();
        carbohydrates.clear();


        if (cursor.moveToFirst()) {
            int proteinsIndex = cursor.getColumnIndex(COLUMN_PROTEINS);
            int fatsIndex = cursor.getColumnIndex(COLUMN_FATS);
            int carbohydratesIndex = cursor.getColumnIndex(COLUMN_CARBOHYDRATES);

            do {
                proteins.add(cursor.getInt(proteinsIndex));
                fats.add(cursor.getInt(fatsIndex));
                carbohydrates.add(cursor.getInt(carbohydratesIndex));
            } while (cursor.moveToNext());
        }

        ArrayList<ArrayList> data = new ArrayList<>();
        data.add(proteins);
        data.add(fats);
        data.add(carbohydrates);

        cursor.close();
        return data;
    }
}
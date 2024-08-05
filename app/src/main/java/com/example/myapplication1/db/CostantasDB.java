package com.example.myapplication1.db;

public class CostantasDB {
    public static final String TABLE_NAME = "Prot_Fat_Carbo";
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";


    /////////////////////////////////////
    public static final String PROTEIN = "protein";
    public static final String FAT = "fat";
    public static final String CARBOHYDRATES = "carbohydrates";
    //Я якщо що потім додам, я зараз не хочу з цим мучатися

    public static final String DB_NAME = "food.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + "(" + _ID + " INTEGER," + NAME + " TEXT," +
            PROTEIN + " INTEGER, " + FAT  + " INTEGER, " + CARBOHYDRATES  + " INTEGER, " + "PRIMARY KEY(" + _ID + "))" ;
    public static final String DROP_TABLE = "DROP TABLE IF  EXISTS " + TABLE_NAME;
}

package db;

public class CostantasDB {
    public static final String TABLE_NAME = "Prot_Fat_Carbo";
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    /*
    public static final int PROTEIN = 0;
    public static final int FAT = 0;
    public static final int CARBOHYDRATES = 0;
    Я якщо що потім додам, я зараз не хочу з цим мучатися
     */
    public static final String DB_NAME = "food.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXESTS" +
            TABLE_NAME + "(" + _ID + " INTEGER PRIMARY KEY," + NAME + " TEXT," +
            DESCRIPTION + " TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF  EXISTS " + TABLE_NAME;
}

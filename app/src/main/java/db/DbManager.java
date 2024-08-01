package db;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class DbManager {
    private Context context;
    private DbHelper DbHelper;
    private SQLiteDatabase db;

    public DbManager (Context context) {
            this.context = context;
            DbHelper = new DbHelper(context);
    }
    public void openDb(){
        db = DbHelper.getWritableDatabase();
    }
    public void insertToDb(String name, String description){
        ContentValues cv = new ContentValues();
        cv.put(CostantasDB.NAME, name);
        cv.put(CostantasDB.DESCRIPTION, description);
        db.insert(CostantasDB.TABLE_NAME, null, cv);
    }
    public List<String> getFromDb();
}

package com.example.grocerystore_app;


import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

class SQLiteHelper2 extends SQLiteOpenHelper {

    static String DATABASE_NAME="UserDataBase2";

    public static final String TABLE_NAME="OrderTable";

    public static final String Table_Column_ID="id";

    public static final String Table_Column_1_PName="name";

    public static final String Table_Column_2_PPrice="price";

    public static final String Table_Column_3_PImage="img";
    public static final String Table_Column_4_PQuantity="quantity";

    public SQLiteHelper2(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Table_Column_1_PName+" VARCHAR, "+Table_Column_2_PPrice+" VARCHAR, "+Table_Column_3_PImage+" VARCHAR, "+Table_Column_4_PQuantity+" VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}
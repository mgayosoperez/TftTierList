package com.example.tfttierlist.Core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Sqlito extends SQLiteOpenHelper{
    private static String LOG_TAG = "SQULITO";
    private static String NOMBRE = "TFTierList";
    private static int VERSION = 1;

    private static final String CHAMP_TABLE = "champ";
    private static final String NAME = "name";
    private static final String ORIGIN = "origin";
    private static final String CHAMPCLASS = "champclass";
    private static final String ORIGINCLASS = "originclass";
    private static final String DESCRIPTION = "description";
    private static final String TIER = "tier";
    private static final String COST = "coste";
    private static final String HEALTH = "health";
    private static final String MANA = "mana";
    private static final String INITIALMANA = "initialmana";
    private static final String ARMOR = "armor";
    private static final String MR = "mr";
    private static final String DPS = "dps";
    private static final String DAMAGE = "damage";
    private static final String ATKSPD = "atkspd";
    private static final String CRITRATE = "critrate";
    private static final String RANGE = "range";

    public Sqlito(Context c){
        super( c, NOMBRE, null, VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try {
            db.beginTransaction();

            db.execSQL( "CREATE TABLE " + CHAMP_TABLE + "("
                    + NAME + "TEXT PRIMARY KEY,"
                    + ORIGIN + "TEXT NOT NULL,"
                    + CHAMPCLASS + "TEXT NOT NULL,"
                    + ORIGINCLASS + "TEXT NOT NULL,"
                    + DESCRIPTION + "TEXT NOT NULL,"
                    + TIER + "TEXT NOT NULL,"
                    + COST + "TEXT NOT NULL,"
                    + HEALTH + "TEXT NOT NULL,"
                    + MANA + "TEXT NOT NULL,"
                    + INITIALMANA + "TEXT NOT NULL,"
                    + ARMOR + "TEXT NOT NULL,"
                    + MR + "TEXT NOT NULL,"
                    + DPS + "TEXT NOT NULL,"
                    + DAMAGE + "TEXT NOT NULL,"
                    + ATKSPD + "TEXT NOT NULL,"
                    + CRITRATE + "TEXT NOT NULL,"
                    + RANGE + "TEXT NOT NULL,"
                    + "UNIQUE (" + NAME + "))");

            db.setTransactionSuccessful();
            mockData(db);

        }
        catch(SQLException exc) {
            Log.e( LOG_TAG, "creando base de datos: " + exc.getMessage() );
        } finally {
            db.endTransaction();
        }

        return;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        try {
            db.beginTransaction();

            db.execSQL( "DROP TABLE IF EXISTS " + "CAMPEON" );

            db.setTransactionSuccessful();
        } catch(SQLException exc) {
            Log.e(LOG_TAG, "eliminando la base de datos: " + exc.getMessage() );
        } finally {
            db.endTransaction();
        }

        this.onCreate( db );
    }

    public long saveChamp (Champion Champ){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.insert(CHAMP_TABLE,null,Champ.toContentValues());
    }

    public void mockData(SQLiteDatabase sqLiteDatabase){
        mockChamp(sqLiteDatabase, new Champion("Zed", "Eléctrico", "Asesino", "Invocador", "-", "S", "5", "850/1530/3060", "150", "0", "30", "20" ,"80/144/288" ,"80/144/288" ,"1" ,"25%" ,"1"));
        mockChamp(sqLiteDatabase, new Champion("Singed", "Poison", "Alchemist", "-", "Singed leaves a poison cloud behind him damaging enemies in the area over 4 seconds.", "S", "5", "950 / 1710 / 3420", "0", "0", "50", "20" ,"0/0/0" ,"0/0/0" ,"0" ,"25%" ,"0"));
        mockChamp(sqLiteDatabase, new Champion("Olaf", "Glacial", "Berserker", "-", "Olaf gains attack speed, lifesteal based on missing health, and immunity to crowd control for the rest of combat. Attack Speed Bonus: 100% / 150% / 300%. Lifesteal: 50%.", "S", "4", "750 / 1350 / 2700", "90", "0", "35", "20" ,"60 / 107 / 214" ,"70 / 126 / 252" ,"0.85" ,"25%" ,"1"));
        mockChamp(sqLiteDatabase, new Champion("Nocturne", "Steel", "Assassin", "-", "Every third attack, Nocturne deals additional damage to enemies around him and heals for a portion of the damage. Heal Amount: 40% / 60% / 80%", "S","3", "650 / 1170 / 2340", "0", "0", "25", "20", "45 / 81 / 162", "60 / 108 / 216" ,"0.75" ,"25%" ,"1" ));
        mockChamp(sqLiteDatabase, new Champion("Nami", "Ocean", "Mystic", "-", "Nami sends a massive wave toward a random enemy, damaging and knocking up enemies it passes through and granting allies it passes through bonus magic damage on hit. Damage: 150 / 250 / 350 Stun Duration: 1.5 / 2 / 2.5 Bonus Damage: 25 / 50 / 300", "S", "5", "750 / 1350 / 2700", "125", "50", "25" ,"20" ,"38 / 68 / 135" ,"50 / 90 / 180" ,"0.75" ,"25%", "4"));



    }

    public long mockChamp (SQLiteDatabase db, Champion champ){
        return db.insert(CHAMP_TABLE, null, champ.toContentValues());
    }

    public List<Champion> recuperaTodo()
    {
        final List<Champion> TORET = new ArrayList<>();
        final SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.query( "CAMPEON",
                null,
                null,
                null,
                null,
                null,
                null );

        if ( cursor.moveToFirst() ) {
            do {




            } while( cursor.moveToNext() );
        }

        cursor.close();
        return TORET;
    }
}


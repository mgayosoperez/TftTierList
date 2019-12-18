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

    private static final String CHAMP_TABLE = "champion";
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
                    + NAME + " TEXT PRIMARY KEY,"
                    + ORIGIN + " TEXT NOT NULL,"
                    + CHAMPCLASS + " TEXT NOT NULL,"
                    + ORIGINCLASS + " TEXT NOT NULL,"
                    + DESCRIPTION + " TEXT NOT NULL,"
                    + TIER + " TEXT NOT NULL,"
                    + COST + " TEXT NOT NULL,"
                    + HEALTH + " TEXT NOT NULL,"
                    + MANA + " TEXT NOT NULL,"
                    + INITIALMANA + " TEXT NOT NULL,"
                    + ARMOR + " TEXT NOT NULL,"
                    + MR + " TEXT NOT NULL,"
                    + DPS + " TEXT NOT NULL,"
                    + DAMAGE + " TEXT NOT NULL,"
                    + ATKSPD + " TEXT NOT NULL,"
                    + CRITRATE + " TEXT NOT NULL,"
                    + RANGE + " TEXT NOT NULL,"
                    + "UNIQUE (" + NAME + "))");


            db.setTransactionSuccessful();
        } catch(SQLException exc) {
            Log.e(LOG_TAG, "ERROR al crear la base de datos: " + exc.getMessage() );
        } finally {
            db.endTransaction();
        }


        mockData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        try {
            db.beginTransaction();

            db.execSQL( "DROP TABLE IF EXISTS " + CHAMP_TABLE );

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
        mockChamp(sqLiteDatabase, new Champion("Zed", "Eléctrico", "Asesino", "Invocador", "-", "1", "5", "850/1530/3060", "150", "0", "30", "20" ,"80/144/288" ,"80/144/288" ,"1" ,"25%" ,"1"));
        mockChamp(sqLiteDatabase, new Champion("Singed", "Poison", "Alchemist", "-", "Singed leaves a poison cloud behind him damaging enemies in the area over 4 seconds.", "A", "5", "950 / 1710 / 3420", "0", "0", "50", "20" ,"0/0/0" ,"0/0/0" ,"0" ,"25%" ,"0"));
        mockChamp(sqLiteDatabase, new Champion("Olaf", "Glacial", "Berserker", "-", "Olaf gains attack speed, lifesteal based on missing health, and immunity to crowd control for the rest of combat. Attack Speed Bonus: 100% / 150% / 300%. Lifesteal: 50%.", "B", "4", "750 / 1350 / 2700", "90", "0", "35", "20" ,"60 / 107 / 214" ,"70 / 126 / 252" ,"0.85" ,"25%" ,"1"));
        mockChamp(sqLiteDatabase, new Champion("Nocturne", "Steel", "Assassin", "-", "Every third attack, Nocturne deals additional damage to enemies around him and heals for a portion of the damage. Heal Amount: 40% / 60% / 80%", "C","3", "650 / 1170 / 2340", "0", "0", "25", "20", "45 / 81 / 162", "60 / 108 / 216" ,"0.75" ,"25%" ,"1" ));
    }

    public long mockChamp (SQLiteDatabase db, Champion champ){
        return db.insert(CHAMP_TABLE, null, champ.toContentValues());
    }

    public List<Champion> recuperaTodo()
    {
        final List<Champion> TORET = new ArrayList<>();
        final SQLiteDatabase DB = this.getReadableDatabase();
        Cursor CURSOR = DB.query( CHAMP_TABLE,
                null,
                null,
                null,
                null,
                null,
                "1" );

        if ( CURSOR.moveToFirst() ) {
            do {

                String Name = CURSOR.getString(CURSOR.getColumnIndexOrThrow(NAME));
                String Origin = CURSOR.getString(CURSOR.getColumnIndexOrThrow(ORIGIN));
                String ChampClass = CURSOR.getString(CURSOR.getColumnIndexOrThrow(CHAMPCLASS));
                String OriginClass = CURSOR.getString(CURSOR.getColumnIndexOrThrow(ORIGINCLASS));
                String Description = CURSOR.getString(CURSOR.getColumnIndexOrThrow(DESCRIPTION));
                String Tier = CURSOR.getString(CURSOR.getColumnIndexOrThrow(TIER));
                String Cost = CURSOR.getString(CURSOR.getColumnIndexOrThrow(COST));
                String Health = CURSOR.getString(CURSOR.getColumnIndexOrThrow(HEALTH));
                String Mana = CURSOR.getString(CURSOR.getColumnIndexOrThrow(MANA));
                String InitialMana = CURSOR.getString(CURSOR.getColumnIndexOrThrow(INITIALMANA));
                String Armor = CURSOR.getString(CURSOR.getColumnIndexOrThrow(ARMOR));
                String Mr = CURSOR.getString(CURSOR.getColumnIndexOrThrow(MR));
                String Dps = CURSOR.getString(CURSOR.getColumnIndexOrThrow(DPS));
                String Damage = CURSOR.getString(CURSOR.getColumnIndexOrThrow(DAMAGE));
                String AtkSpd =CURSOR.getString(CURSOR.getColumnIndexOrThrow(ATKSPD));
                String CritRate = CURSOR.getString(CURSOR.getColumnIndexOrThrow(CRITRATE));
                String Range = CURSOR.getString(CURSOR.getColumnIndexOrThrow(RANGE));

                TORET.add(new Champion(Name,Origin,ChampClass,OriginClass,Description,Tier,Cost,Health,Mana,InitialMana,Armor,Mr,Dps,Damage,AtkSpd,CritRate,Range));


            } while( CURSOR.moveToNext() );
        }

        CURSOR.close();
        return TORET;
    }
}


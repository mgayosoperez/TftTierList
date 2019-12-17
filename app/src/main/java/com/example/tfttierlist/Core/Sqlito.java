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
    private static String Nombre = "TFTierList";
    private static int Version = 3;

    public Sqlito(Context c)
    {
        super( c, Nombre, null, Version );

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try {
            db.beginTransaction();

            db.execSQL( "CREATE TABLE IF NOT EXISTS CAMPEON(" + "nombre string(15) PRIMARY KEY"+")" );

            db.execSQL( "INSERT INTO CAMPEON (nombre) VALUES ("+"Zed"+")" );

            db.setTransactionSuccessful();

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


    /** @return un array con todos los objetos de la base de datos. NO RECOMENDADO. */
    public List<Champion> recuperaTodo()
    {
        Log.d("STATE","nepe4");
        final List<Champion> TORET = new ArrayList<>();
        final SQLiteDatabase DB = this.getReadableDatabase();
        Log.d("STATE","nepe");
        Cursor cursor = DB.query( "CAMPEON",
                null,
                null,
                null,
                null,
                null,
                null );

        if ( cursor.moveToFirst() ) {
            do {
                String asignatura = cursor.getString(
                        cursor.getColumnIndexOrThrow( "nombre" ) );
                Log.d("STATE",asignatura);

            } while( cursor.moveToNext() );
        }

        cursor.close();
        return TORET;
    }
}


package com.example.tfttierlist.Core;

import android.content.Context;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SqlIO extends SQLiteOpenHelper {
    public static String LOG_TAG = SqlIO.class.getSimpleName();
    public static final String DATABASE_NAME = "Tft Tier List";
    public static final int DATABASE_VERSION = 1;


    public SqlIO(Context context)
    {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();

        try {
            db.execSQL( "CREATE TABLE IF NOT EXISTS item("
                    + "nombre varchar(15) PRIMARY KEY,"
                    + "objeto1 varchar(15),"
                    + "objeto2 varchar(15),"
                    + "descripcion varchar(500) NOT NULL,"
                    + "tier char,"
                    + "imagen varchar(80)"
                    +")"  );

            db.execSQL( "CREATE TABLE IF NOT EXISTS campeon("
                    + "nombre varchar(15) PRIMARY KEY,"
                    + "origen varchar(15) NOT NULL,"
                    + "clase varchar(15) NOT NULL,"
                    + "claseOrigen varchar(15),"
                    + "descripcion varchar(500) NOT NULL,"
                    + "tier char NOT NULL,"
                    + "imagen varchar(80) NOT NULL,"
                    + "vida int(5) NOT NULL,"
                    + "coste int(1) NOT NULL,"
                    + "mana int(5) NOT NULL,"
                    + "armadura int(5) NOT NULL,"
                    + "mr int(5) NOT NULL,"
                    + "dps int(5) NOT NULL,"
                    + "daño int(5) NOT NULL,"
                    + "vAtaque int(5) NOT NULL,"
                    + "critico int(5) NOT NULL,"
                    + "alcance int(5) NOT NULL"
                    +")"  );

            db.execSQL( "CREATE TABLE IF NOT EXISTS clase("
                    + "nombre varchar(15) PRIMARY KEY,"
                    + "descripcion varchar(500) NOT NULL,"
                    + "imagen varchar(80)"
                    +")"  );

            db.execSQL( "CREATE TABLE IF NOT EXISTS origin("
                    + "nombre varchar(15) PRIMARY KEY,"
                    + "descripcion varchar(500) NOT NULL,"
                    + "imagen varchar(80)"
                    +")"  );

            final String datosClase ="INSERT INTO `CLASE` (`nombre`, `descripcion`, `imagen`) VALUES  (`Asesino`, `-`, `-`),(`Invocador`, `-`, `-`);";
            db.execSQL(datosClase);

            final String datosOrigen ="INSERT INTO `ORIGEN` (`nombre`, `descripcion`, `imagen`) VALUES (`Eléctrico`, `-`, `-`);";
            db.execSQL(datosOrigen);

            final String datosItem ="INSERT INTO `ITEM` (`nombre`, `objeto1`, `objeto2`, `descripcion`, `tier`, `imagen`) VALUES ('Espátula', '', '', 'Tiene que hacer algo...', 'S', '-');";
            db.execSQL(datosItem);

            final String datosCampeon ="INSERT INTO `CAMPEON` (`nombre`, `origen`, `clase`, `claseOrigen`, `descripcion`, `tier`, `imagen`, `coste`, `vida`, `mana`, `armadura`, `mr`, `dps`, `daño`, `vAtaque`, `critico`, `alcance`) VALUES" +
                    "                      ('Zed', 'Eléctrico', 'Asesino', 'Invocador', '-', 'S', '-', '5', '850/1530/3060', '150', '30', '20' ,'80/144/288' ,'80/144/288' ,'1' ,'25%' ,'1');";
            db.execSQL(datosCampeon);

            db.setTransactionSuccessful();
        }catch (SQLException exc){
            Log.e(LOG_TAG, "error creando tabla" + exc.getMessage());
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.beginTransaction();

        try {
            db.execSQL( "DROP TABLE IF EXISTS item" );
            db.execSQL( "DROP TABLE IF EXISTS campeon" );
            db.execSQL( "DROP TABLE IF EXISTS origin" );
            db.execSQL( "DROP TABLE IF EXISTS origin" );
            db.setTransactionSuccessful();
        }catch (SQLException exc) {
            Log.e(LOG_TAG, "error borrando la tabla" + exc.getMessage());
        }finally {
            db.endTransaction();
        }

        this.onCreate( db  );
    }


}

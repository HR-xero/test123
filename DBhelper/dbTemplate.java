package com.example.acer.bagasproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.acer.bagasproject.constructor.constructorTemplate;

import java.util.ArrayList;
import java.util.Date;

public class dbTemplate extends SQLiteOpenHelper {
    public static final String namaDB= "bagasDB.db";
    public static final String namaTable= "DataBarang";
    public static final String Kol1 = "ID";
    public static final String Kol2 = "NAMABARANG";
    public static final String Kol3 = "HARGAPRODUK";
    public static final String Kol4 = "TANGGAL";
    public static final String Kol5 = "JUMLAH";
    public static final String Kol6 = "KETERANGAN";
    public dbTemplate(Context ctx){ super(ctx, namaDB, null, 1); }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String buatTable =
                "CREATE TABLE "+namaTable +"(" +
                        Kol1+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        Kol2+" TEXT, " +
                        Kol3+" DECIMAL(12,3), " +
                        Kol4+" DATETIME, " +
                        Kol5+" INT, " +
                        Kol6+" TEXT)";
        db.execSQL(buatTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+namaTable);
    }
    public boolean TambahData(String namaBarang, String hargaProduk, String tanggal, String jumlah, String keterangan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put(Kol2, namaBarang);
        cValues.put(Kol3, hargaProduk);
        cValues.put(Kol4, tanggal);
        cValues.put(Kol5, jumlah);
        cValues.put(Kol6, keterangan);

        long hasil = db.insert(namaTable, null, cValues);
        if(hasil == -1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getListContents(String user, String pass){


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+namaTable, null);
        return data;
    }

    public String testQuery(String user, String pass){

        String data="SELECT * FROM "+namaTable;
        return data;
    }
    public ArrayList<constructorTemplate>dapatkanData(){
        ArrayList<constructorTemplate>arrayList=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crs = db.rawQuery("SELECT * FROM "+namaTable, null);
        while(crs.moveToNext()){
            String id_ = crs.getString(0);
            String namaBarang = crs.getString(1);
            String hargaProduk = crs.getString(2);
            String Tanggal = crs.getString(3);
            String jumlah = crs.getString(4);
            String keterangan= crs.getString(5);
            constructorTemplate bC = new constructorTemplate(id_,namaBarang, hargaProduk, Tanggal, jumlah, keterangan );
            arrayList.add(bC);
        }
        return arrayList;
    }
}
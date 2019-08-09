package com.example.acer.bagasproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.bagasproject.RecyclerAdapater.adapterTemplate;
import com.example.acer.bagasproject.constructor.constructorTemplate;
import com.example.acer.bagasproject.db.dbTemplate;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class FormDisplay extends AppCompatActivity {

    String hasil;
    TextView txthasil;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter_;
    private ArrayList<constructorTemplate> constructorTemplatesItem;
    dbTemplate sqlitehelper;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_hasil);
        recyclerView = findViewById(R.id.rcSQLITE);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        intent = getIntent();
        txthasil=findViewById(R.id.txthasil);
        sqlitehelper = new dbTemplate(this);
        constructorTemplatesItem = new ArrayList<>();
        Cursor cursor = sqlitehelper.getListContents("","");
        if(cursor.getCount()==0){
            Toast.makeText(this, "Data masih kosong", Toast.LENGTH_LONG).show();
        }else{
            while(cursor.moveToNext()){
                constructorTemplatesItem.add(new constructorTemplate(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)));
            }

        }
        adapter_=new adapterTemplate(constructorTemplatesItem, getApplicationContext());
        recyclerView.setAdapter(adapter_);

        txthasil.setText(intent.getStringExtra("hasil"));

        /*Intent intent = getIntent();
        hasil= intent.getStringExtra("hasil");
        txthasil.setText(hasil);*/
    }


}

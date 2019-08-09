package com.example.acer.bagasproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.bagasproject.db.dbTemplate;

public class FormInput extends AppCompatActivity {
    Button btSimpan;
    EditText txtNama, txtHarga, txtTanggal, txtJumlah, txtKeterangan ;
    dbTemplate dbtemplate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btSimpan = findViewById(R.id.btSimpan);
        txtNama = findViewById(R.id.txtNama);
        txtHarga = findViewById(R.id.txtHarga);
        txtTanggal = findViewById(R.id.txtTanggal);
        txtJumlah = findViewById(R.id.txtJumlah);
        txtKeterangan = findViewById(R.id.txtKeterangan);

        dbtemplate = new dbTemplate(this);

        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tambahData(txtNama.getText().toString(),
                        txtHarga.getText().toString(),
                        txtTanggal.getText().toString(),
                        txtJumlah.getText().toString(),
                        txtKeterangan.getText().toString()
                        );
            }
        });
    }

    public void tambahData(String nama, String Harga, String tanggal, String jumlah, String keterangan){
        boolean simpanData = dbtemplate.TambahData(nama,Harga,tanggal,jumlah,keterangan);
        if(simpanData){
            Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Data gagal disimopan", Toast.LENGTH_LONG).show();
        }
    }
	
//untuk membuat menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudata, menu);
        menu.getItem(0).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ( item.getItemId()){
            case R.id.mn_tambah_setting:
                Intent intent  =new Intent(this, formHasil.class);
                intent.putExtra("hasil", "abc");
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}

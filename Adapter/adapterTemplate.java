package com.example.acer.bagasproject.RecyclerAdapater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acer.bagasproject.MainActivity;
import com.example.acer.bagasproject.R;
import com.example.acer.bagasproject.constructor.constructorTemplate;

import java.util.List;

public class adapterTemplate extends RecyclerView.Adapter<adapterTemplate.ViewHolder> {
    private List<constructorTemplate> listItem;
    private Context ctx;

    public adapterTemplate(List<constructorTemplate>listItem, Context ctx) {
        this.listItem = listItem;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_ui_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        constructorTemplate bgC = listItem.get(position);
        holder.id_.setText(bgC.getId());
        holder.txtnamaBarang.setText(bgC.getNamaBarang());
        holder.txthargaProduk.setText(bgC.getHargaProduk());
        holder.txtTanggal.setText(bgC.getTanggal());
        holder.txtjumlah.setText(bgC.getJumlah());
        holder.txtketerangan.setText(bgC.getKeterangan());
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView id_, txtnamaBarang, txthargaProduk, txtTanggal, txtjumlah, txtketerangan;
        public ViewHolder(final View itemV){
            super(itemV);
            id_=itemV.findViewById(R.id.txtID);
            txtnamaBarang= itemV.findViewById(R.id.txtNama);
            txthargaProduk=itemV.findViewById(R.id.txtHarga);
            txtTanggal=itemV.findViewById(R.id.txtTanggal);
            txtjumlah=itemV.findViewById(R.id.txtJumlah);
            txtketerangan= itemV.findViewById(R.id.txtKeterangan);
            itemV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ctx, MainActivity.class);
                    intent.putExtra("id", id_.getText().toString());
                    intent.putExtra("namabarang", txtnamaBarang.getText().toString());
                    intent.putExtra("hargaproduk", txthargaProduk.getText().toString());
                    intent.putExtra("tanggal", txtTanggal.getText().toString());
                    intent.putExtra("jumlah", txtjumlah.getText().toString());
                    intent.putExtra("keterangan", txtketerangan.getText().toString());

                    ctx.startActivity(intent);
                }
            });
        }
    }
}

package com.example.acer.bagasproject.constructor;

public class constructorTemplate {
    String id, namaBarang, hargaProduk, tanggal, jumlah, keterangan;

    public constructorTemplate(String id, String namaBarang, String hargaProduk, String tanggal, String jumlah, String keterangan) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.hargaProduk = hargaProduk;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
    }
    public constructorTemplate(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(String hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }


}
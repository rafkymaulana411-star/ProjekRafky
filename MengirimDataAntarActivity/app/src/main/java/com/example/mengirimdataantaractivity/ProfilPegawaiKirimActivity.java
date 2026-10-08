package com.example.mengirimdataantaractivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfilPegawaiKirimActivity extends AppCompatActivity {

    private TextView tvNamaPegawai, tvAlamat, tvUmur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_pegawai_kirim_xml);

        tvNamaPegawai = findViewById(R.id.tvNamaPegawai);
        tvAlamat = findViewById(R.id.tvAlamat);
        tvUmur = findViewById(R.id.tvUmur);

        // Ambil data dari Intent
        Intent intent = getIntent();
        if (intent != null) {
            String nama = intent.getStringExtra("nama");
            String alamat = intent.getStringExtra("alamat");
            float umur = intent.getFloatExtra("umur", 0f);

            tvNamaPegawai.setText("Nama Pegawai: " + (nama != null ? nama : "-"));
            tvAlamat.setText("Alamat: " + (alamat != null ? alamat : "-"));
            tvUmur.setText("Umur: " + umur + " tahun");
        }
    }
}

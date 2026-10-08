package com.example.menghitungnilaimahasiswa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button btNilai, btPetunjuk, btTentang, btExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btNilai = findViewById(R.id.btNilai);
        btPetunjuk = findViewById(R.id.btPetunjuk);
        btTentang = findViewById(R.id.btTentang);
        btExit = findViewById(R.id.btExit);

        // Pindah ke KonversiNilaiActivity saat tombol Nilai Mahasiswa diklik
        btNilai.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, KonversiNilaiActivity.class);
            startActivity(intent);
        });

        // Menampilkan petunjuk penggunaan
        btPetunjuk.setOnClickListener(v -> {
            new AlertDialog.Builder(HomeActivity.this)
                    .setTitle("Petunjuk Penggunaan")
                    .setMessage("1. Masukkan Nama Mahasiswa.\n2. Masukkan nilai Tugas (Bobot 20%).\n3. Masukkan nilai Kehadiran (Bobot 10%).\n4. Masukkan nilai UTS (Bobot 30%).\n5. Masukkan nilai UAS (Bobot 40%).\n6. Klik 'Hitung Nilai' untuk melihat Nilai Angka dan Nilai Huruf.")
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });

        // Menampilkan informasi tentang aplikasi
        btTentang.setOnClickListener(v -> {
            new AlertDialog.Builder(HomeActivity.this)
                    .setTitle("Tentang Aplikasi")
                    .setMessage("Aplikasi Penghitung Nilai Mahasiswa\nUniversitas Hang Tuah Pekanbaru\n\nVersi 1.0\nDibuat untuk memudahkan perhitungan nilai akhir mahasiswa berdasarkan bobot komponen penilaian.")
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });

        // Keluar dari aplikasi
        btExit.setOnClickListener(v -> finish());
    }
}

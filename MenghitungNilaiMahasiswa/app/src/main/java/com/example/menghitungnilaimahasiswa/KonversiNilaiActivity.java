package com.example.menghitungnilaimahasiswa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class KonversiNilaiActivity extends AppCompatActivity {

    private EditText edNama, edTugas, edKehadiran, edUTS, edUAS, edNilaiAngka, edNilaiHuruf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konversi_nilai);

        // Inisialisasi komponen View
        edNama = findViewById(R.id.edNama);
        edTugas = findViewById(R.id.edTugas);
        edKehadiran = findViewById(R.id.edKehadiran);
        edUTS = findViewById(R.id.edUTS);
        edUAS = findViewById(R.id.edUAS);
        edNilaiAngka = findViewById(R.id.edNilaiAngka);
        edNilaiHuruf = findViewById(R.id.edNilaiHuruf);
        Button btHitung = findViewById(R.id.btHitung);

        btHitung.setOnClickListener(v -> hitungNilai());
    }

    private void hitungNilai() {
        // Mengambil teks dari input
        String strNama = edNama.getText().toString().trim();
        String strTugas = edTugas.getText().toString().trim();
        String strKehadiran = edKehadiran.getText().toString().trim();
        String strUTS = edUTS.getText().toString().trim();
        String strUAS = edUAS.getText().toString().trim();

        // Validasi agar tidak crash jika ada field yang kosong
        if (strNama.isEmpty() || strTugas.isEmpty() || strKehadiran.isEmpty() || strUTS.isEmpty() || strUAS.isEmpty()) {
            Toast.makeText(this, "Harap isi nama dan semua nilai terlebih dahulu!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Konversi String ke Double
        double nilaiTugas = Double.parseDouble(strTugas);
        double nilaiKehadiran = Double.parseDouble(strKehadiran);
        double nilaiUTS = Double.parseDouble(strUTS);
        double nilaiUAS = Double.parseDouble(strUAS);

        // Validasi rentang nilai (0 - 100)
        if ((nilaiTugas < 0 || nilaiTugas > 100) ||
            (nilaiKehadiran < 0 || nilaiKehadiran > 100) ||
            (nilaiUTS < 0 || nilaiUTS > 100) ||
            (nilaiUAS < 0 || nilaiUAS > 100)) {
            Toast.makeText(this, "Nilai harus berada di antara 0 dan 100!", Toast.LENGTH_SHORT).show();
            return;
        }

        /*
           Bobot Perhitungan Nilai:
           - Kehadiran: 10% (0.10)
           - Tugas: 20% (0.20)
           - UTS: 30% (0.30)
           - UAS: 40% (0.40)
        */
        double nilaiAkhir = (nilaiKehadiran * 0.10) + (nilaiTugas * 0.20) + (nilaiUTS * 0.30) + (nilaiUAS * 0.40);

        // Menentukan Nilai Huruf dengan kondisi IF-ELSE
        String nilaiHuruf;
        if (nilaiAkhir >= 80) {
            nilaiHuruf = "A";
        } else if (nilaiAkhir >= 70) {
            nilaiHuruf = "B";
        } else if (nilaiAkhir >= 60) {
            nilaiHuruf = "C";
        } else if (nilaiAkhir >= 50) {
            nilaiHuruf = "D";
        } else {
            nilaiHuruf = "E";
        }

        // Menampilkan Hasil ke View
        edNilaiAngka.setText(String.format(Locale.getDefault(), "%.2f", nilaiAkhir));
        edNilaiHuruf.setText(nilaiHuruf);

        Toast.makeText(this, "Hasil perhitungan untuk " + strNama + " berhasil ditampilkan.", Toast.LENGTH_SHORT).show();
    }
}

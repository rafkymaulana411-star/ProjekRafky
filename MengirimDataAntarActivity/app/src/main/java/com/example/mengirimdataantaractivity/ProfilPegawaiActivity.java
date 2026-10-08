package com.example.mengirimdataantaractivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ProfilPegawaiActivity extends AppCompatActivity {

    private EditText edNamaPegawai, edAlamat, edUmur;
    private Button btnKirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_pegawai_xml);

        edNamaPegawai = findViewById(R.id.edNamaPegawai);
        edAlamat = findViewById(R.id.edAlamat);
        edUmur = findViewById(R.id.edUmur);
        btnKirim = findViewById(R.id.btnKirim);

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = edNamaPegawai.getText().toString().trim();
                String alamat = edAlamat.getText().toString().trim();

                float umurVal = 0f;
                String umurStr = edUmur.getText().toString().trim();
                if (!umurStr.isEmpty()) {
                    try {
                        umurVal = Float.parseFloat(umurStr);
                    } catch (NumberFormatException e) {
                        umurVal = 0f;
                    }
                }

                Intent intent = new Intent(ProfilPegawaiActivity.this, ProfilPegawaiKirimActivity.class);
                intent.putExtra("nama", nama);
                intent.putExtra("alamat", alamat);
                intent.putExtra("umur", umurVal);
                startActivity(intent);
            }
        });
    }
}

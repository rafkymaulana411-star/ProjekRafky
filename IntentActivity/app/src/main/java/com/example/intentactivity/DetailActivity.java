package com.example.intentactivity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvHasil = findViewById(R.id.tvHasil);

        // Mengambil data yang dikirim dari MainActivity
        if (getIntent().hasExtra("DATA_PESAN")) {
            String pesan = getIntent().getStringExtra("DATA_PESAN");
            tvHasil.setText(pesan);
        }
    }
}

package com.example.koreanclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    private static final String[] prov = new String[]{"Jawa Timur", "Jawa Barat", "Jawa Tengah", "DKI Jakarta", "DIY Yogyakarta"};
    private static final String[] city = new String[]{"Jember", "Nganjuk", "Banyuwangi", "DKI Jakarta", "Situbondo", "Madiun"};

    AutoCompleteTextView provinsi;
    AutoCompleteTextView kota;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnertgl);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.date, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner = findViewById(R.id.spinnerbln);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter2);

        spinner = findViewById(R.id.spinnerthn);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter3);

        provinsi = findViewById(R.id.ectProv);

        ArrayAdapter<String> adapterprov = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prov);
        adapterprov.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provinsi.setAdapter(adapterprov);

        provinsi = findViewById(R.id.ectKota);

        ArrayAdapter<String> adapterkota = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, city);
        adapterkota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provinsi.setAdapter(adapterkota);

        button = (Button) findViewById(R.id.btnDaftar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });

    }
    public void openMainActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
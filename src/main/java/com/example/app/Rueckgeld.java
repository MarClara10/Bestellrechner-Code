package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class Rueckgeld extends AppCompatActivity {

    //<editor-fold desc="Variablen inizialisieren">
    public Float finalTotal;
    public EditText gegeben, pfand_2;
    public TextView geld_zurück;
    public Button rueckgeld_back, berechnen;
    public boolean doubleBackToExitPressedOnce = false;
    //</editor-fold>

    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.rueckgeld);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //<editor-fold desc="Elemente finden">
        rueckgeld_back = findViewById(R.id.rueckgeld_back);
        berechnen = findViewById(R.id.berechnen);
        gegeben = findViewById(R.id.gegeben);
        geld_zurück = findViewById(R.id.geld_zurück);
        pfand_2 = findViewById(R.id.pfand_2);
        //</editor-fold>


        //<editor-fold desc="Layoutwechseln">
        rueckgeld_back.setOnClickListener(v -> {

            // Zuerst alle Daten speichern
            shared_preferences();

            Intent intent = new Intent(Rueckgeld.this, Page1.class);
            startActivity(intent);
        });
        //</editor-fold>

    }

    //<editor-fold desc="Zurück-Button">
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            // Schließt alle Aktivitäten und damit die App
            finishAffinity();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Drücke noch einmal, um die App zu schließen", Toast.LENGTH_SHORT).show();

        // Nach 2 Sekunden wird das Flag zurückgesetzt, falls der Nutzer nicht erneut drückt
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
    //</editor-fold>

    public void berechnen(View x) {


            SharedPreferences sharedPreferences = getSharedPreferences("Names & Prices", MODE_PRIVATE);

            finalTotal = sharedPreferences.getFloat("gesamt_preis", 0);

            String gegebenStr = gegeben.getText().toString();
            String becherStr = pfand_2.getText().toString();
            String pfandStr = sharedPreferences.getString("savedpfand", "0");

            float gegebenVal;
            int becherVal;
            float pfandVal;

            try {
                gegebenVal = Float.parseFloat(gegebenStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Bitte gültigen Betrag bei 'gegeben' eingeben!", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                becherVal = Integer.parseInt(becherStr);
            } catch (NumberFormatException e) {
                becherVal = 0;
            }

            try {
                pfandVal = Float.parseFloat(pfandStr);
            } catch (NumberFormatException e) {
                pfandVal = 0;
            }

            // Gesamter Pfandbetrag (z. B. 1€ * 2 Becher)
            float gesamtPfand = pfandVal * becherVal;

            // Rückgeld = Gegeben - (Preis - Pfand)
            float rueckgeld = gegebenVal - (finalTotal - gesamtPfand);

            geld_zurück.setText(String.format(Locale.getDefault(), "%.2f", rueckgeld));

            // Zwischenspeichern
            shared_preferences();

    }

    public void loadSavedValues() {

        TextView pfand_3 = findViewById(R.id.pfand_3);

        SharedPreferences sharedPreferences = getSharedPreferences("Names & Prices", MODE_PRIVATE);

        finalTotal = sharedPreferences.getFloat("gesamt_preis", 0);

        gegeben.setText(sharedPreferences.getString("savedgegeben", ""));
        geld_zurück.setText(sharedPreferences.getString("savedgeld_zurück", ""));
        pfand_2.setText(sharedPreferences.getString("savedpfand_anzahl", ""));
        pfand_3.setText(String.format("%.2f ", finalTotal));

    }

    public void shared_preferences() {

        String gegeben_ = gegeben.getText().toString();
        String rueckgeld_ = geld_zurück.getText().toString();
        String pfandAnzahl_ = pfand_2.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("Names & Prices", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("savedgegeben", gegeben_);
        editor.putString("savedgeld_zurück", rueckgeld_);
        editor.putString("savedpfand_anzahl", pfandAnzahl_);

        editor.apply();

    }

    public void onResume() {
        super.onResume();
        loadSavedValues();
        shared_preferences();
    }

    @Override
    protected void onPause() {
        super.onPause();
        shared_preferences();
    }
}

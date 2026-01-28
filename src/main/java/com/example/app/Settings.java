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

public class Settings extends AppCompatActivity {

    //<editor-fold desc="Variablen inizialisieren">
    public int button_numbers = 0;
    public TextView pfand_tx2, euro13;
    public boolean doubleBackToExitPressedOnce = false;
    public EditText preis1, preis2, preis3, preis4, preis5, preis6, preis7, preis8, preis9, preis10, preis11, preis12, pfand, showNumberOfButtons;
    public Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, add_buttons, delete_buttons, back, tutorial;
    //</editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.settings);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //<editor-fold desc="Elemente finden">
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);

        preis1 = findViewById(R.id.preis1);
        preis2 = findViewById(R.id.preis2);
        preis3 = findViewById(R.id.preis3);
        preis4 = findViewById(R.id.preis4);
        preis5 = findViewById(R.id.preis5);
        preis6 = findViewById(R.id.preis6);
        preis7 = findViewById(R.id.preis7);
        preis8 = findViewById(R.id.preis8);
        preis9 = findViewById(R.id.preis9);
        preis10 = findViewById(R.id.preis10);
        preis11 = findViewById(R.id.preis11);
        preis12 = findViewById(R.id.preis12);

        pfand = findViewById(R.id.pfand);
        pfand_tx2 = findViewById(R.id.pfand_tx2);
        euro13 = findViewById(R.id.euro13);

        add_buttons = findViewById(R.id.add_buttons);
        delete_buttons = findViewById(R.id.delete_buttons);
        showNumberOfButtons = findViewById(R.id.showNumberOfButtons);

        back = findViewById(R.id.back);
        tutorial = findViewById(R.id.tutorial);
        //</editor-fold>


        //<editor-fold desc="Layoutwechseln">
        back.setOnClickListener(v -> {

            // Zuerst alle Daten speichern
            shared_preferences();

            Intent intent = new Intent(Settings.this, Page1.class);
            startActivity(intent);
        });

        tutorial.setOnClickListener(v -> {

            // Zuerst alle Daten speichern
            shared_preferences();

            Intent intent = new Intent(Settings.this, Video.class);
            startActivity(intent);
        });
        //</editor-fold>


        //<editor-fold desc="Buttons hinzufügen">

        // Anfangszustand: buttons ausblenden
        show_content();
        buttons_visibility();

        add_buttons.setOnClickListener(v -> {
            if (button_numbers < 12) {
                button_numbers++;
                show_content();
                saveButtonNumbers();
                buttons_visibility();
                showNumberOfButtons.setText(String.valueOf(button_numbers));

            }
        });

        delete_buttons.setOnClickListener(v -> {
            if (button_numbers > 0) {
                button_numbers--;
                show_content();
                saveButtonNumbers();
                buttons_visibility();
                showNumberOfButtons.setText(String.valueOf(button_numbers));
            }
        });
        //</editor-fold>*/


        loadSavedValues();
        showNumberOfButtons.setText(String.valueOf(button_numbers));
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

    public void buttons_visibility() {
        if (button_numbers > 0) {
            delete_buttons.setVisibility(View.VISIBLE);
            showNumberOfButtons.setVisibility(View.VISIBLE);

            pfand.setVisibility(View.VISIBLE);
            pfand_tx2.setVisibility(View.VISIBLE);
            euro13.setVisibility(View.VISIBLE);

        } else {
            delete_buttons.setVisibility(View.GONE);
            showNumberOfButtons.setVisibility(View.GONE);

            pfand.setVisibility(View.GONE);
            pfand_tx2.setVisibility(View.GONE);
            euro13.setVisibility(View.GONE);
        }
    }

    public void show_content() {

        // Buttons
        Button[] buttons = new Button[]{
                findViewById(R.id.button1),
                findViewById(R.id.button2),
                findViewById(R.id.button3),
                findViewById(R.id.button4),
                findViewById(R.id.button5),
                findViewById(R.id.button6),
                findViewById(R.id.button7),
                findViewById(R.id.button8),
                findViewById(R.id.button9),
                findViewById(R.id.button10),
                findViewById(R.id.button11),
                findViewById(R.id.button12)
        };

        for (int i = 0; i < buttons.length; i++) {
            if (button_numbers >= (i + 1)) {
                buttons[i].setVisibility(View.VISIBLE);
            } else {
                buttons[i].setVisibility(View.GONE);
            }
        }


        // Euros
        View[] euros = new View[]{
                findViewById(R.id.euro1),
                findViewById(R.id.euro2),
                findViewById(R.id.euro3),
                findViewById(R.id.euro4),
                findViewById(R.id.euro5),
                findViewById(R.id.euro6),
                findViewById(R.id.euro7),
                findViewById(R.id.euro8),
                findViewById(R.id.euro9),
                findViewById(R.id.euro10),
                findViewById(R.id.euro11),
                findViewById(R.id.euro12)
        };

        for (int i = 0; i < euros.length; i++) {
            if (button_numbers >= (i + 1)) {
                euros[i].setVisibility(View.VISIBLE);
            } else {
                euros[i].setVisibility(View.GONE);
            }
        }


        // Preise
        EditText[] numbers = new EditText[]{
                findViewById(R.id.preis1),
                findViewById(R.id.preis2),
                findViewById(R.id.preis3),
                findViewById(R.id.preis4),
                findViewById(R.id.preis5),
                findViewById(R.id.preis6),
                findViewById(R.id.preis7),
                findViewById(R.id.preis8),
                findViewById(R.id.preis9),
                findViewById(R.id.preis10),
                findViewById(R.id.preis11),
                findViewById(R.id.preis12)

        };

        for (int i = 0; i < numbers.length; i++) {
            if (button_numbers >= (i + 1)) {
                numbers[i].setVisibility(View.VISIBLE);
            } else {
                numbers[i].setVisibility(View.GONE);
            }
        }
    }

    public void loadSavedValues() {
        SharedPreferences sharedPreferences = getSharedPreferences("Names & Prices", MODE_PRIVATE);

        button1.setText(sharedPreferences.getString("savedProduct1", ""));
        button2.setText(sharedPreferences.getString("savedProduct2", ""));
        button3.setText(sharedPreferences.getString("savedProduct3", ""));
        button4.setText(sharedPreferences.getString("savedProduct4", ""));
        button5.setText(sharedPreferences.getString("savedProduct5", ""));
        button6.setText(sharedPreferences.getString("savedProduct6", ""));
        button7.setText(sharedPreferences.getString("savedProduct7", ""));
        button8.setText(sharedPreferences.getString("savedProduct8", ""));
        button9.setText(sharedPreferences.getString("savedProduct9", ""));
        button10.setText(sharedPreferences.getString("savedProduct10", ""));
        button11.setText(sharedPreferences.getString("savedProduct11", ""));
        button12.setText(sharedPreferences.getString("savedProduct12", ""));

        preis1.setText(sharedPreferences.getString("savedpreis1", ""));
        preis2.setText(sharedPreferences.getString("savedpreis2", ""));
        preis3.setText(sharedPreferences.getString("savedpreis3", ""));
        preis4.setText(sharedPreferences.getString("savedpreis4", ""));
        preis5.setText(sharedPreferences.getString("savedpreis5", ""));
        preis6.setText(sharedPreferences.getString("savedpreis6", ""));
        preis7.setText(sharedPreferences.getString("savedpreis7", ""));
        preis8.setText(sharedPreferences.getString("savedpreis8", ""));
        preis9.setText(sharedPreferences.getString("savedpreis9", ""));
        preis10.setText(sharedPreferences.getString("savedpreis10", ""));
        preis11.setText(sharedPreferences.getString("savedpreis11", ""));
        preis12.setText(sharedPreferences.getString("savedpreis12", ""));
        pfand.setText(sharedPreferences.getString("savedpfand", ""));
        button_numbers = sharedPreferences.getInt("button_numbers", 0);


        show_content();
        buttons_visibility();

    }

    public void saveButtonNumbers() {
        SharedPreferences sp = getSharedPreferences("Names & Prices", MODE_PRIVATE);
        sp.edit().putInt("button_numbers", button_numbers).apply();
    }

    public void shared_preferences() {
        // Buttontexte auslesen

        String Product1 = button1.getText().toString();
        String Product2 = button2.getText().toString();
        String Product3 = button3.getText().toString();
        String Product4 = button4.getText().toString();
        String Product5 = button5.getText().toString();
        String Product6 = button6.getText().toString();
        String Product7 = button7.getText().toString();
        String Product8 = button8.getText().toString();
        String Product9 = button9.getText().toString();
        String Product10 = button10.getText().toString();
        String Product11 = button11.getText().toString();
        String Product12 = button12.getText().toString();
        int button_numbers1 = button_numbers;


        // Preise auslesen
        String price1 = preis1.getText().toString();
        String price2 = preis2.getText().toString();
        String price3 = preis3.getText().toString();
        String price4 = preis4.getText().toString();
        String price5 = preis5.getText().toString();
        String price6 = preis6.getText().toString();
        String price7 = preis7.getText().toString();
        String price8 = preis8.getText().toString();
        String price9 = preis9.getText().toString();
        String price10 = preis10.getText().toString();
        String price11 = preis11.getText().toString();
        String price12 = preis12.getText().toString();
        String deposit = pfand.getText().toString();

        // Mit konsistentem SharedPreferences-Namen speichern
        SharedPreferences sharedPreferences = getSharedPreferences("Names & Prices", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Texte der Buttons speichern
        editor.putString("savedProduct1", Product1);
        editor.putString("savedProduct2", Product2);
        editor.putString("savedProduct3", Product3);
        editor.putString("savedProduct4", Product4);
        editor.putString("savedProduct5", Product5);
        editor.putString("savedProduct6", Product6);
        editor.putString("savedProduct7", Product7);
        editor.putString("savedProduct8", Product8);
        editor.putString("savedProduct9", Product9);
        editor.putString("savedProduct10", Product10);
        editor.putString("savedProduct11", Product11);
        editor.putString("savedProduct12", Product12);

        // Preise speichern
        editor.putString("savedpreis1", price1);
        editor.putString("savedpreis2", price2);
        editor.putString("savedpreis3", price3);
        editor.putString("savedpreis4", price4);
        editor.putString("savedpreis5", price5);
        editor.putString("savedpreis6", price6);
        editor.putString("savedpreis7", price7);
        editor.putString("savedpreis8", price8);
        editor.putString("savedpreis9", price9);
        editor.putString("savedpreis10", price10);
        editor.putString("savedpreis11", price11);
        editor.putString("savedpreis12", price12);
        editor.putString("savedpfand", deposit);

        editor.putInt("button_numbers", button_numbers1);

        editor.apply();
    }

    public void reset(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("Names & Prices", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();

        loadSavedValues();

        Toast.makeText(this, "Alle Einstellungen wurden auf Werkseinstellungen zurück gesetzt", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadSavedValues();
        show_content();
        showNumberOfButtons.setText(String.valueOf(button_numbers));
    }

    @Override
    protected void onPause() {
        super.onPause();
        shared_preferences();
    }

}

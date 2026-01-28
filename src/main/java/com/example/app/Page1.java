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
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Page1 extends AppCompatActivity {


    //<editor-fold desc="Variablen inizialisieren">
    public ImageView setting_page;
    public TextView pfand_tx, pfand_, euro;
    public int button_numbers, a, b, c, d, e, f, g, h, i, j, k, l;
    public boolean doubleBackToExitPressedOnce = false;
    public Button reduce_1, reduce_2, reduce_3, reduce_4, reduce_5, reduce_6, reduce_7, reduce_8, reduce_9, reduce_10, reduce_11, reduce_12;
    public EditText number_1, number_2, number_3, number_4, number_5, number_6, number_7, number_8, number_9, number_10, number_11, number_12;
    public double preis1, preis2, preis3, preis4, preis5, preis6, preis7, preis8, preis9, preis10, preis11, preis12, pfand, gesamt_preis, finalTotal;
    public Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_10, button_11, button_12, bestell_button, reset_page1;
    //</editor-fold>


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page1);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //<editor-fold desc="Elemente finden">
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_10 = findViewById(R.id.button_10);
        button_11 = findViewById(R.id.button_11);
        button_12 = findViewById(R.id.button_12);

        number_1 = findViewById(R.id.number_1);
        number_2 = findViewById(R.id.number_2);
        number_3 = findViewById(R.id.number_3);
        number_4 = findViewById(R.id.number_4);
        number_5 = findViewById(R.id.number_5);
        number_6 = findViewById(R.id.number_6);
        number_7 = findViewById(R.id.number_7);
        number_8 = findViewById(R.id.number_8);
        number_9 = findViewById(R.id.number_9);
        number_10 = findViewById(R.id.number_10);
        number_11 = findViewById(R.id.number_11);
        number_12 = findViewById(R.id.number_12);

        reduce_1 = findViewById(R.id.reduce_1);
        reduce_2 = findViewById(R.id.reduce_2);
        reduce_3 = findViewById(R.id.reduce_3);
        reduce_4 = findViewById(R.id.reduce_4);
        reduce_5 = findViewById(R.id.reduce_5);
        reduce_6 = findViewById(R.id.reduce_6);
        reduce_7 = findViewById(R.id.reduce_7);
        reduce_8 = findViewById(R.id.reduce_8);
        reduce_9 = findViewById(R.id.reduce_9);
        reduce_10 = findViewById(R.id.reduce_10);
        reduce_11 = findViewById(R.id.reduce_11);
        reduce_12 = findViewById(R.id.reduce_12);

        bestell_button = findViewById(R.id.bestell_button);
        setting_page = findViewById(R.id.setting_page);
        //</editor-fold>


        //<editor-fold desc="Mengen">
        button_1.setOnClickListener(x -> {
            a++;
            number_1.setText(String.valueOf(a));
            updateTotalPrice();
            reduce_1.setOnClickListener(r -> {
                if (a > 0)
                    a--;

                if (a == 0){
                    number_1.setText("");
                    updateTotalPrice();
                }else{
                    number_1.setText(String.valueOf(a));
                    updateTotalPrice();
                }
            });
        });

        button_2.setOnClickListener(x -> {
            b++;
            number_2.setText(String.valueOf(b));
            updateTotalPrice();
            reduce_2.setOnClickListener(r -> {
                if (b > 0)
                    b--;

                if (b == 0){
                    number_2.setText("");
                    updateTotalPrice();
                }else{
                    number_2.setText(String.valueOf(b));
                    updateTotalPrice();
                }
            });
        });

        button_3.setOnClickListener(x -> {
            c++;
            number_3.setText(String.valueOf(c));
            updateTotalPrice();
            reduce_3.setOnClickListener(r -> {
                if (c > 0)
                    c--;

                if (c == 0){
                    number_3.setText("");
                    updateTotalPrice();
                }else{
                    number_3.setText(String.valueOf(c));
                    updateTotalPrice();
                }
            });
        });

        button_4.setOnClickListener(x -> {
            d++;
            number_4.setText(String.valueOf(d));
            updateTotalPrice();
            reduce_4.setOnClickListener(r -> {
                if (d > 0)
                    d--;

                if (d == 0){
                    number_4.setText("");
                    updateTotalPrice();
                }else{
                    number_4.setText(String.valueOf(d));
                    updateTotalPrice();
                }
            });
        });

        button_5.setOnClickListener(x -> {
            e++;
            number_5.setText(String.valueOf(e));
            updateTotalPrice();
            reduce_5.setOnClickListener(r -> {
                if (e > 0)
                    e--;

                if (e == 0){
                    number_5.setText("");
                    updateTotalPrice();
                }else{
                    number_5.setText(String.valueOf(e));
                    updateTotalPrice();
                }
            });
        });

        button_6.setOnClickListener(x -> {
            f++;
            number_6.setText(String.valueOf(f));
            updateTotalPrice();
            reduce_6.setOnClickListener(r -> {
                if (f > 0)
                    f--;

                if (f == 0){
                    number_6.setText("");
                    updateTotalPrice();
                }else{
                    number_6.setText(String.valueOf(f));
                    updateTotalPrice();
                }
            });
        });

        button_7.setOnClickListener(x -> {
            g++;
            number_7.setText(String.valueOf(g));
            updateTotalPrice();
            reduce_7.setOnClickListener(r -> {
                if (g > 0)
                    g--;

                if (g == 0){
                    number_7.setText("");
                    updateTotalPrice();
                }else{
                    number_7.setText(String.valueOf(g));
                    updateTotalPrice();
                }
            });
        });

        button_8.setOnClickListener(x -> {
            h++;
            number_8.setText(String.valueOf(h));
            updateTotalPrice();
            reduce_8.setOnClickListener(r -> {
                if (h > 0)
                    h--;

                if (h == 0){
                    number_8.setText("");
                    updateTotalPrice();
                }else{
                    number_8.setText(String.valueOf(h));
                    updateTotalPrice();
                }
            });
        });

        button_9.setOnClickListener(x -> {
            i++;
            number_9.setText(String.valueOf(i));
            updateTotalPrice();
            reduce_9.setOnClickListener(r -> {
                if (i > 0)
                    i--;

                if (i == 0){
                    number_9.setText("");
                    updateTotalPrice();
                }else{
                    number_9.setText(String.valueOf(i));
                    updateTotalPrice();
                }
            });
        });

        button_10.setOnClickListener(x -> {
            j++;
            number_10.setText(String.valueOf(j));
            updateTotalPrice();
            reduce_10.setOnClickListener(r -> {
                if (j > 0)
                    j--;

                if (j == 0){
                    number_10.setText("");
                    updateTotalPrice();
                }else{
                    number_10.setText(String.valueOf(j));
                    updateTotalPrice();
                }
            });
        });

        button_11.setOnClickListener(x -> {
            k++;
            number_11.setText(String.valueOf(k));
            updateTotalPrice();
            reduce_11.setOnClickListener(r -> {
                if (k > 0)
                    k--;

                if (k == 0){
                    number_11.setText("");
                    updateTotalPrice();
                }else{
                    number_11.setText(String.valueOf(k));
                    updateTotalPrice();
                }
            });
        });

        button_12.setOnClickListener(x -> {
            l++;
            number_12.setText(String.valueOf(l));
            updateTotalPrice();
            reduce_12.setOnClickListener(r -> {
                if (l > 0)
                    l--;

                if (l == 0){
                    number_12.setText("");
                    updateTotalPrice();
                }else{
                    number_12.setText(String.valueOf(l));
                    updateTotalPrice();
                }
            });
        });
        //</editor-fold>


        //<editor-fold desc="Layoutwechseln">
        bestell_button.setOnClickListener(v -> {

            // Zuerst alle Daten speichern
            Berechnung();
            shared_preferences();
            loadSavedValues();

            Intent intent = new Intent(Page1.this, Rueckgeld.class);
            startActivity(intent);
        });

        setting_page.setOnClickListener(v -> {

            // Zuerst alle Daten speichern
            Berechnung();
            shared_preferences();
            loadSavedValues();

            Intent intent = new Intent(Page1.this, Settings.class);
            startActivity(intent);
        });
        //</editor-fold>


        //<editor-fold desc="Shared Preferences">
        // Gespeicherte Texte aus SharedPreferences abrufen und setzen
        SharedPreferences sharedPreferences = getSharedPreferences("Names & Prices", MODE_PRIVATE);

        button_1.setText(sharedPreferences.getString("savedProduct1", ""));
        button_2.setText(sharedPreferences.getString("savedProduct2", ""));
        button_3.setText(sharedPreferences.getString("savedProduct3", ""));
        button_4.setText(sharedPreferences.getString("savedProduct4", ""));
        button_5.setText(sharedPreferences.getString("savedProduct5", ""));
        button_6.setText(sharedPreferences.getString("savedProduct6", ""));
        button_7.setText(sharedPreferences.getString("savedProduct7", ""));
        button_8.setText(sharedPreferences.getString("savedProduct8", ""));
        button_9.setText(sharedPreferences.getString("savedProduct9", ""));
        button_10.setText(sharedPreferences.getString("savedProduct10", ""));
        button_11.setText(sharedPreferences.getString("savedProduct11", ""));
        button_12.setText(sharedPreferences.getString("savedProduct12", ""));
        button_numbers = sharedPreferences.getInt("button_numbers", 0);

        show_content();
        loadSavedValues();
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


    public double parseDoubleOrZero(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public void loadUnitPrices() {
        SharedPreferences sharedPreferences = getSharedPreferences("Names & Prices", MODE_PRIVATE);
        preis1 = parseDoubleOrZero(sharedPreferences.getString("savedpreis1", "0"));
        preis2 = parseDoubleOrZero(sharedPreferences.getString("savedpreis2", "0"));
        preis3 = parseDoubleOrZero(sharedPreferences.getString("savedpreis3", "0"));
        preis4 = parseDoubleOrZero(sharedPreferences.getString("savedpreis4", "0"));
        preis5 = parseDoubleOrZero(sharedPreferences.getString("savedpreis5", "0"));
        preis6 = parseDoubleOrZero(sharedPreferences.getString("savedpreis6", "0"));
        preis7 = parseDoubleOrZero(sharedPreferences.getString("savedpreis7", "0"));
        preis8 = parseDoubleOrZero(sharedPreferences.getString("savedpreis8", "0"));
        preis9 = parseDoubleOrZero(sharedPreferences.getString("savedpreis9", "0"));
        preis10 = parseDoubleOrZero(sharedPreferences.getString("savedpreis10", "0"));
        preis11 = parseDoubleOrZero(sharedPreferences.getString("savedpreis11", "0"));
        preis12 = parseDoubleOrZero(sharedPreferences.getString("savedpreis12", "0"));
        pfand = parseDoubleOrZero(sharedPreferences.getString("savedpfand", "0"));
    }

    @SuppressLint("DefaultLocale")
    public void updateTotalPrice() {
        double totalA = a * (preis1 + pfand);
        double totalB = b * (preis2 + pfand);
        double totalC = c * (preis3 + pfand);
        double totalD = d * (preis4 + pfand);
        double totalE = e * (preis5 + pfand);
        double totalF = f * (preis6 + pfand);
        double totalG = g * (preis7 + pfand);
        double totalH = h * (preis8 + pfand);
        double totalI = i * (preis9 + pfand);
        double totalJ = j * (preis10 + pfand);
        double totalK = k * (preis11 + pfand);
        double totalL = l * (preis12 + pfand);

        finalTotal = totalA + totalB + totalC + totalD + totalE + totalF + totalG + totalH + totalI + totalJ + totalK + totalL;

        pfand_.setText(String.format("%.2f ", finalTotal));

    }

    public void reset(View v) {

        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        j = 0;
        k = 0;
        l = 0;

        // Setze die EditText Felder auf ""
        number_1.setText("");
        number_2.setText("");
        number_3.setText("");
        number_4.setText("");
        number_5.setText("");
        number_6.setText("");
        number_7.setText("");
        number_8.setText("");
        number_9.setText("");
        number_10.setText("");
        number_11.setText("");
        number_12.setText("");

        // Aktualisiere die Gesamtpreise etc.
        updateTotalPrice();

        // Shared Preferences aktualisieren
        SharedPreferences sharedPreferences = getSharedPreferences("Names & Prices", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("number1", "");
        editor.putString("number2", "");
        editor.putString("number3", "");
        editor.putString("number4", "");
        editor.putString("number5", "");
        editor.putString("number6", "");
        editor.putString("number7", "");
        editor.putString("number8", "");
        editor.putString("number9", "");
        editor.putString("number10", "");
        editor.putString("number11", "");
        editor.putString("number12", "");

        editor.putString("savedgegeben", "");
        editor.putString("savedgeld_zurück", "");
        editor.putString("savedpfand_anzahl", "");

        editor.apply();


        List<EditText> selectedEditTexts = new ArrayList<>();

        selectedEditTexts.add(findViewById(R.id.number_1));
        selectedEditTexts.add(findViewById(R.id.number_2));
        selectedEditTexts.add(findViewById(R.id.number_3));
        selectedEditTexts.add(findViewById(R.id.number_4));
        selectedEditTexts.add(findViewById(R.id.number_5));
        selectedEditTexts.add(findViewById(R.id.number_6));
        selectedEditTexts.add(findViewById(R.id.number_7));
        selectedEditTexts.add(findViewById(R.id.number_8));
        selectedEditTexts.add(findViewById(R.id.number_9));
        selectedEditTexts.add(findViewById(R.id.number_10));
        selectedEditTexts.add(findViewById(R.id.number_11));
        selectedEditTexts.add(findViewById(R.id.number_12));

        for (EditText editText : selectedEditTexts) {
            editText.setText("");

            updateTotalPrice();

        }

        Toast.makeText(this, "Alle Werte wurden zurückgesetzt.", Toast.LENGTH_SHORT).show();
    }

    public void show_content() {
        Button[] buttons = new Button[]{
                findViewById(R.id.button_1),
                findViewById(R.id.button_2),
                findViewById(R.id.button_3),
                findViewById(R.id.button_4),
                findViewById(R.id.button_5),
                findViewById(R.id.button_6),
                findViewById(R.id.button_7),
                findViewById(R.id.button_8),
                findViewById(R.id.button_9),
                findViewById(R.id.button_10),
                findViewById(R.id.button_11),
                findViewById(R.id.button_12)
        };

        reset_page1 = findViewById(R.id.reset_page1);


        for (int i = 0; i < buttons.length; i++) {
            if (button_numbers >= 1) {
                reset_page1.setVisibility(View.VISIBLE);
            } else {
                reset_page1.setVisibility(View.GONE);
            }
            if (button_numbers >= (i + 1)) {
                buttons[i].setVisibility(View.VISIBLE);
            } else {
                buttons[i].setVisibility(View.GONE);
            }
        }



        EditText[] numbers = new EditText[]{
                findViewById(R.id.number_1),
                findViewById(R.id.number_2),
                findViewById(R.id.number_3),
                findViewById(R.id.number_4),
                findViewById(R.id.number_5),
                findViewById(R.id.number_6),
                findViewById(R.id.number_7),
                findViewById(R.id.number_8),
                findViewById(R.id.number_9),
                findViewById(R.id.number_10),
                findViewById(R.id.number_11),
                findViewById(R.id.number_12)

        };

        for (int i = 0; i < numbers.length; i++) {
            if (button_numbers >= (i + 1)) {
                numbers[i].setVisibility(View.VISIBLE);
            } else {
                numbers[i].setVisibility(View.GONE);
            }
        }



        Button[] reduce = new Button[]{
                findViewById(R.id.reduce_1),
                findViewById(R.id.reduce_2),
                findViewById(R.id.reduce_3),
                findViewById(R.id.reduce_4),
                findViewById(R.id.reduce_5),
                findViewById(R.id.reduce_6),
                findViewById(R.id.reduce_7),
                findViewById(R.id.reduce_8),
                findViewById(R.id.reduce_9),
                findViewById(R.id.reduce_10),
                findViewById(R.id.reduce_11),
                findViewById(R.id.reduce_12)
        };

        for (int i = 0; i < reduce.length; i++) {
            if (button_numbers >= (i + 1)) {
                reduce[i].setVisibility(View.VISIBLE);
            } else {
                reduce[i].setVisibility(View.GONE);
            }
        }



        pfand_tx = findViewById(R.id.pfand_tx);
        pfand_ = findViewById(R.id.pfand_);
        euro = findViewById(R.id.euro);
        bestell_button = findViewById(R.id.bestell_button);

        if (button_numbers >= 1) {
            pfand_tx.setVisibility(View.VISIBLE);
            pfand_.setVisibility(View.VISIBLE);
            euro.setVisibility(View.VISIBLE);
            bestell_button.setVisibility(View.VISIBLE);
        } else {
            pfand_tx.setVisibility(View.GONE);
            pfand_.setVisibility(View.GONE);
            euro.setVisibility(View.GONE);
            bestell_button.setVisibility(View.GONE);
        }
    }

    public void Berechnung() {
        SharedPreferences sharedPreferences = getSharedPreferences("Names & Prices", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putFloat("gesamt_preis", (float) finalTotal);

        editor.apply();
    }

    public void shared_preferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("Names & Prices", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("number1", number_1.getText().toString());
        editor.putString("number2", number_2.getText().toString());
        editor.putString("number3", number_3.getText().toString());
        editor.putString("number4", number_4.getText().toString());
        editor.putString("number5", number_5.getText().toString());
        editor.putString("number6", number_6.getText().toString());
        editor.putString("number7", number_7.getText().toString());
        editor.putString("number8", number_8.getText().toString());
        editor.putString("number9", number_9.getText().toString());
        editor.putString("number10", number_10.getText().toString());
        editor.putString("number11", number_11.getText().toString());
        editor.putString("number12", number_12.getText().toString());

        editor.apply();

    }

    public void loadSavedValues() {
        SharedPreferences sharedPreferences = getSharedPreferences("Names & Prices", MODE_PRIVATE);

        String zahl1 = sharedPreferences.getString("number1", "");
        String zahl2 = sharedPreferences.getString("number2", "");
        String zahl3 = sharedPreferences.getString("number3", "");
        String zahl4 = sharedPreferences.getString("number4", "");
        String zahl5 = sharedPreferences.getString("number5", "");
        String zahl6 = sharedPreferences.getString("number6", "");
        String zahl7 = sharedPreferences.getString("number7", "");
        String zahl8 = sharedPreferences.getString("number8", "");
        String zahl9 = sharedPreferences.getString("number9", "");
        String zahl10 = sharedPreferences.getString("number10", "");
        String zahl11 = sharedPreferences.getString("number11", "");
        String zahl12 = sharedPreferences.getString("number12", "");

        number_1.setText(zahl1);
        number_2.setText(zahl2);
        number_3.setText(zahl3);
        number_4.setText(zahl4);
        number_5.setText(zahl5);
        number_6.setText(zahl6);
        number_7.setText(zahl7);
        number_8.setText(zahl8);
        number_9.setText(zahl9);
        number_10.setText(zahl10);
        number_11.setText(zahl11);
        number_12.setText(zahl12);

        try {
            a = Integer.parseInt(zahl1);
        } catch (NumberFormatException m) {
            a = 0;
        }

        try {
            b = Integer.parseInt(zahl2);
        } catch (NumberFormatException m) {
            b = 0;
        }

        try {
            c = Integer.parseInt(zahl3);
        } catch (NumberFormatException m) {
            c = 0;
        }

        try {
            d = Integer.parseInt(zahl4);
        } catch (NumberFormatException m) {
            d = 0;
        }

        try {
            e = Integer.parseInt(zahl5);
        } catch (NumberFormatException m) {
            e = 0;
        }

        try {
            f = Integer.parseInt(zahl6);
        } catch (NumberFormatException m) {
            f = 0;
        }

        try {
            g = Integer.parseInt(zahl7);
        } catch (NumberFormatException m) {
            g = 0;
        }

        try {
            h = Integer.parseInt(zahl8);
        } catch (NumberFormatException m) {
            h = 0;
        }

        try {
            i = Integer.parseInt(zahl9);
        } catch (NumberFormatException m) {
            i = 0;
        }

        try {
            j = Integer.parseInt(zahl10);
        } catch (NumberFormatException m) {
            j = 0;
        }

        try {
            k = Integer.parseInt(zahl11);
        } catch (NumberFormatException m) {
            k = 0;
        }

        try {
            l = Integer.parseInt(zahl12);
        } catch (NumberFormatException m) {
            l = 0;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadUnitPrices();
        loadSavedValues();
        updateTotalPrice();
    }

    @Override
    protected void onPause() {
        super.onPause();
        shared_preferences();
    }
}
package com.movilesII.marketplaceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class SplashActiviy extends AppCompatActivity {

    TextView tvTitleSplash1, tvTitleSplash2, tvSloganSplash, tvRighReserved;
    Typeface typeAkayaFonts, typeCourgetteFonts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activiy);

        tvTitleSplash1 = findViewById(R.id.tvTitleSplash1);
        tvTitleSplash2 = findViewById(R.id.tvTitleSplash2);
        tvSloganSplash = findViewById(R.id.tvSloganSplash);
        tvRighReserved = findViewById(R.id.tvRightReserved);

        changeFontSplash();
        tvRighReserved.setText(getText(R.string.SplashRigthR)+" "+getCurrentYear());

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActiviy.this, LoginActivity.class));
                finish();
            }
        }, 2500);
    }
    
    public void changeFontSplash(){
        typeAkayaFonts = Typeface.createFromAsset(getAssets(), "fonts/AkayaTelivigala-Regular.ttf");
        typeCourgetteFonts = Typeface.createFromAsset(getAssets(), "fonts/Courgette-Regular.ttf");

        tvTitleSplash1.setTypeface(typeCourgetteFonts);
        tvTitleSplash2.setTypeface(typeCourgetteFonts);
        tvSloganSplash.setTypeface(typeAkayaFonts);
    }

    public  String getCurrentYear(){
        Date date = new Date();

        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
        String  year = Integer.toString(getLocalDate.getYear());

        return year;

    }
}
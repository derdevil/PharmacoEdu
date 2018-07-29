package projas.wse.elektro.um.pharmacoedu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import projas.wse.elektro.um.pharmacoedu.materi.MateriActivity;
import projas.wse.elektro.um.pharmacoedu.tts.TTSActivity;
import projas.wse.elektro.um.pharmacoedu.ujian.UjianActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        CardView cvMenu = (CardView) findViewById(R.id.home_cv_materi);
        cvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MateriActivity.class));
            }
        });

        cvMenu = (CardView) findViewById(R.id.home_cv_ujian);
        cvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, UjianActivity.class));
            }
        });

        cvMenu = (CardView) findViewById(R.id.home_cv_tts);
        cvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, TTSActivity.class));
            }
        });
    }
}

package com.example.taskagitmakas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewOyuncu, imageViewBilgisayar;
    TextView twOyuncu, twBilgisayar;
    Button buttonTas, buttonKagit, buttonMakas;

    int[] resimler = {R.drawable.rock2, R.drawable.paper2, R.drawable.scissors2};

    int oyuncuPuan, pcPuan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewOyuncu = findViewById(R.id.imageViewOyuncu);
        imageViewBilgisayar = findViewById(R.id.imageViewBilgisayar);
        twOyuncu = findViewById(R.id.twOyuncuPuan);
        twBilgisayar = findViewById(R.id.twBilgisayarPuan);
        buttonTas = findViewById(R.id.buttonTas);
        buttonKagit = findViewById(R.id.buttonKagit);
        buttonMakas = findViewById(R.id.buttonMakas);


        oyuncuPuan = 0;
        pcPuan = 0;


        buttonTas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyna(0);
            }


        });


        buttonKagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyna(1);
            }
        });


        buttonMakas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyna(2);
            }
        });
    }

    private void oyna(int oyuncuSecim) {
        int pcSecim = (int) (Math.random() * 3);

        imageViewOyuncu.setImageResource(resimler[oyuncuSecim]);
        imageViewBilgisayar.setImageResource(resimler[pcSecim]);

        if (oyuncuSecim == pcSecim) {
            Toast.makeText(this, "Berabere", Toast.LENGTH_SHORT).show();
        } else if (oyuncuSecim == 0 && pcSecim == 2 || oyuncuSecim==1 && pcSecim==0 ||
        oyuncuSecim==2 && pcSecim==1) {
            Toast.makeText(this, "Oyuncu Kazandı", Toast.LENGTH_SHORT).show();
            oyuncuPuan++;
        }
        else{
            Toast.makeText(this, "Bilgisayar Kazandı", Toast.LENGTH_SHORT).show();
            pcPuan++;
        }

        twOyuncu.setText("Oyuncu: "+oyuncuPuan);
        twBilgisayar.setText("Bilgisayar: "+pcPuan);
    }



















}
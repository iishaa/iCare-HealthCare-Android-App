package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView findDoctor = findViewById(R.id.cardFDBack);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));

            }
        });
        CardView psychologist = findViewById(R.id.cardFDPsychologist);
        psychologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","psychologist");
               startActivity(it);
            }
        });

        CardView EYE_Doctor = findViewById(R.id.cardEyeDoctor);
        EYE_Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","EyeDoctor");
                startActivity(it);


            }
        });
        CardView Dentist = findViewById(R.id.cardFDDentist);
        Dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);

            }
        });
        CardView Surgeon = findViewById(R.id.cardFDSurgeon);
        Surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);

            }
        });
        CardView Cardiologist = findViewById(R.id.cardFDCardiologist);
        Cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Cardiologist");
                startActivity(it);

            }
        });


    }
}
package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 ={
            {"Doctor Name : Dr. Satish Chand Gupta"," Hospital Address: Delhi ",""," Mobile no. 8842556716","650"},
            {"Doctor Name : Dr. Charu Sharma"," Hospital Address: Indore",""," Mobile no. 9847588716","600"},
            {"Doctor Name : Dr. Swapnil kale"," Hospital Address: pune ",""," Mobile no. 8056743296","1000"},
            {"Doctor Name : Dr. N. K. Pahwa"," Hospital Address: Gurgaon ",""," Mobile no. 9942556716","450"}
    };
    private String[][] doctor_details2 ={
            {"Doctor Name : Dr. Ajit Saste"," Hospital Address: pimpri",""," Mobile no. 9842342716","600"},
            {"Doctor Name : Dr. Prasad Pawar"," Hospital Address: Nigdi ",""," Mobile no. 8867588702","520"},
            {"Doctor Name : Dr. Ripen Gupta"," Hospital Address: Noida ",""," Mobile no. 8056743296","700"},
            {"Doctor Name : Dr. Ashok Panda"," Hospital Address: Ahmedabad ",""," Mobile no. 9942556716","550"}
    };
    private String[][] doctor_details3 ={
            {"Doctor Name : Dr. Neelam patil"," Hospital Address: Bhopal",""," Mobile no. 9942300716","750"},
            {"Doctor Name : Dr. Swati Pawar"," Hospital Address: Noida",""," Mobile no. 8874561293","520"},
            {"Doctor Name : Dr. Neeraj Kale"," Hospital Address: Haryana ",""," Mobile no. 9276482193","800"},
            {"Doctor Name : Dr. Minakshi Panday"," Hospital Address: Ghaziabad ",""," Mobile no. 9942556716","650"}
    };
    private String[][] doctor_details4 ={
            {"Doctor Name : Dr. Seema Patil"," Hospital Address: Alwar",""," Mobile no. 9662342716","600"},
            {"Doctor Name : Dr. Prasad Pawar"," Hospital Address: Nigdi ",""," Mobile no. 7667588702","520"},
            {"Doctor Name : Dr. Monish jain"," Hospital Address: Noida ",""," Mobile no. 7856743296","700"},
            {"Doctor Name : Dr. Vishal Deshmukh"," Hospital Address: gurgaon ",""," Mobile no. 9820556716","550"}
    };
    private String[][] doctor_details5 ={
            {"Doctor Name : Dr. Ananya jain"," Hospital Address: Ghaziabad",""," Mobile no. 9662342716","800"},
            {"Doctor Name : Dr. Stuti parmar"," Hospital Address: AIIMS Delhi ",""," Mobile no. 8467588702","1100"},
            {"Doctor Name : Dr. Aarav kumar"," Hospital Address: Noida ",""," Mobile no. 9856743296","720"},
            {"Doctor Name : Dr. Rimjhim Deshmukh"," Hospital Address: gurgaon ",""," Mobile no. 9920556716","850"}
    };


    TextView tv;
 Button btn;
 String[][] doctor_details ={};
 HashMap<String,String> item;
 ArrayList list;
 SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewCartDDTitle);
        btn = findViewById(R.id.buttonLTPAddToCart);

        Intent it = getIntent();
        String title  = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Psychologist")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("EYE_Doctor")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
            list = new ArrayList();
            for(int i=0;i<doctor_details.length;i++){
                item= new HashMap<String,String>();
                item.put("line1",doctor_details[i][0]);
                item.put("line2",doctor_details[i][1]);
                item.put("line3",doctor_details[i][2]);
                item.put("line4",doctor_details[i][3]);
                item.put("line5","cons Fees :" + doctor_details[i][3]+ "/-");
                list.add(item);
        }
            sa = new SimpleAdapter(this,list,
                    R.layout.multi_lines,
                    new String[]{"line1","line2","line3","line4","line5"},
            new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
            );
        ListView lst = findViewById(R.id.listViewCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}
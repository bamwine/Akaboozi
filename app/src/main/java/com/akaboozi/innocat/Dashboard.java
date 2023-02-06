package com.akaboozi.innocat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{

    private Button radoi,lineup,events,social,contact,lines,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        setTitle("");

        radoi=(Button)findViewById(R.id.radoi);
        lineup=(Button)findViewById(R.id.lineup);
        events=(Button)findViewById(R.id.events);
        social=(Button)findViewById(R.id.social);
        contact=(Button)findViewById(R.id.contact);
        lines=(Button)findViewById(R.id.lines);
        about=(Button)findViewById(R.id.about);


        radoi.setOnClickListener(this);
        lineup.setOnClickListener(this);
        events.setOnClickListener(this);
        social.setOnClickListener(this);
        contact.setOnClickListener(this);
        lines.setOnClickListener(this);
        about.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case  R.id.about:
                Intent in = new Intent(Dashboard.this,About.class);
                startActivity(in);
                break;

            case  R.id.lines:
                Intent li = new Intent(Dashboard.this,Dashboard.class);
                startActivity(li);
                break;

            case  R.id.contact:

                Intent co = new Intent(Dashboard.this,Dashboard.class);
                startActivity(co);

                break;

            case  R.id.social:

                Intent so = new Intent(Dashboard.this,Dashboard.class);
                startActivity(so);

                break;
            case  R.id.radoi:

                Intent rd = new Intent(Dashboard.this,Radio.class);
                startActivity(rd);
                break;
            case  R.id.lineup:

                Intent lp = new Intent(Dashboard.this,Dashboard.class);
                startActivity(lp);
                break;
            case  R.id.events:

                Intent ev = new Intent(Dashboard.this,Dashboard.class);
                startActivity(ev);

                break;


        }




    }
}

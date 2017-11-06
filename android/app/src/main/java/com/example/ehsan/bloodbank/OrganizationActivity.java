package com.example.ehsan.bloodbank;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OrganizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);
    }
    public void Butt1Click(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+"01816111111"));
        this.startActivity(intent);
        // Toast.makeText(context, "Button " + position + " clicked", Toast.LENGTH_SHORT).show();
    }   public void Butt2Click(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+"01712000000"));
        this.startActivity(intent);
        // Toast.makeText(context, "Button " + position + " clicked", Toast.LENGTH_SHORT).show();
    }

}

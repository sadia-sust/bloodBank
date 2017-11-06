package com.example.ehsan.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    TextView txt,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        txt = (TextView)findViewById(R.id.donateview);
        txt2 = (TextView)findViewById(R.id.lastDonate);
        checkAvailability();


    }
    public void checkAvailability()
    {
        for(int i=0;i<Data.mobile.size();i++)
        {
            if(Data.mobile.get(i).equals(Data.currentMobile))
            {

                txt.setText("You are able to donate now");
                txt2.setText("You have last donated on"+ Data.lastDonated.get(i));
                Data.avail= "Yes";
                return;
            }


        }
        txt.setText("You are not able to donate now!");
        Data.avail= "No";



    }
    public void updateClicked(View v)
    {


        String url=Data.IPAdress+"/blood/update.php?mob="+Data.currentMobile;


        Toast.makeText(getApplicationContext(),url, Toast.LENGTH_SHORT).show();

        RequestQueue queue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{
                            JSONArray jsonArray = response;
                            //  Toast.makeText(getApplicationContext(),response.toString(), Toast.LENGTH_SHORT).show();

                            for (int i = 0; i < jsonArray.length(); ++i) {
                                JSONObject jsonObject = null;
                                jsonObject = jsonArray.getJSONObject(i);



                            }

                            //  Toast.makeText(getApplicationContext(), Integer.toString( Data.password.size()), Toast.LENGTH_SHORT).show();


                        }catch (JSONException e) {

                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Toast.makeText(getApplicationContext(),"baal"+ Integer.toString( Data.password.size()), Toast.LENGTH_SHORT).show();

                ;
                //    pDialog.hide();
            }
        });

        queue.add(jsonObjectRequest);
        if(Data.avail.equals("Yes"))
        {
            txt.setText("You are not able to donate now!");
            Data.avail= "No";
        }
        else
        {
            txt.setText("You are able to donate now!");
            Data.avail= "Yes";
        }







    }
}

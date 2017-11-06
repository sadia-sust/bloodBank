package com.example.ehsan.bloodbank;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
   EditText mob,password;
    TextView txt;
    String result;
    ProgressDialog progressDialog;
    private String TAG= MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait....");
        progressDialog.setCancelable(false);
        showDialogue();
        makeJsonObject();
    }
    public void loginClicked(View v)
    {

        mob = (EditText) findViewById(R.id.mob1);
        password=  (EditText) findViewById(R.id.pass1);



        // Toast.makeText(getApplicationContext(), "asf"+Data.flaglogin, Toast.LENGTH_SHORT).show();


       // else
            String st="";
            //Toast.makeText(this, "Wrong Username/Password Combination", Toast.LENGTH_SHORT).show();
        for(int i=0;i<Data.password.size();i++)
        {
            if(Data.password.get(i).equals(password.getText().toString())  && Data.mobile.get(i).equals(mob.getText().toString()) )
            {

              Intent   intent = new Intent(this, SelectOptionActivity.class);
                Data.flaglogin=true;
                Data.currentMobile= mob.getText().toString();
                startActivity(intent);
                finish();

            }

        }
        if(Data.flaglogin==false)
        Toast.makeText(this, "Incorrect Username", Toast.LENGTH_SHORT).show();



        {




        }


    }
    public void registerClicked(View v)
    {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);


    }
    public void orgClicked(View v)
    {
        Intent intent = new Intent(this,OrganizationActivity.class);
        startActivity(intent);


    }
    /*
    public boolean check( String mob,String pass)
    {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String tag_json_array = "json_array_req";

        String url = "http://api.androidhive.info/volley/person_array.json";

        progressDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();





        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                      result=  response.toString();
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ;
                pDialog.hide();
            }
        });


        requestQueue.add(req);


        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

        return false;


    }
    */
    private void makeJsonObject(){


     //   Toast.makeText(getApplicationContext(), "asf", Toast.LENGTH_SHORT).show();

        String url=Data.IPAdress+"/blood/jsoncreate.php";

        RequestQueue queue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                    try{
                        JSONArray jsonArray = response;

                        for (int i = 0; i < jsonArray.length(); ++i) {
                            JSONObject jsonObject = null;
                            jsonObject = jsonArray.getJSONObject(i);

                          //  arrayList1.add(jsonObject.getString("id"));
                           if(jsonObject.getString("availability").equals("Yes"))
                           {
                               Data.fullname.add(jsonObject.getString("name"));
                               Data.mobile.add(jsonObject.getString("contact_no"));
                               Data.group.add(jsonObject.getString("blood_group"));
                               Data.password.add(jsonObject.getString("PASSWORD"));
                               Data.location.add(jsonObject.getString("location"));
                               Data.lastDonated.add(jsonObject.getString("last_donated"));



                           }


                            //   arrayList3.add(jsonObject.getString("phone"));
                           // arrayList4.add(jsonObject.getString("blood"));
                          //  arrayList5.add(jsonObject.getString("dept"));


                        }
                        hidepDialogue();
                      //  Toast.makeText(getApplicationContext(), Integer.toString( Data.password.size()), Toast.LENGTH_SHORT).show();


                    }catch (JSONException e) {

                        e.printStackTrace();
                    }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hidepDialogue();
               // Toast.makeText(getApplicationContext(),"baal"+ Integer.toString( Data.password.size()), Toast.LENGTH_SHORT).show();

                ;
            //    pDialog.hide();
            }
        });

        queue.add(jsonObjectRequest);


    return;
    }
    private void showDialogue(){
        if(!progressDialog.isShowing())
            progressDialog.show();
    }

    private void hidepDialogue(){
        if(progressDialog.isShowing())
            progressDialog.hide();
    }

}

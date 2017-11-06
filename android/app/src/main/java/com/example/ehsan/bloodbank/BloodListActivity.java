package com.example.ehsan.bloodbank;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BloodListActivity extends AppCompatActivity {
    TextView tt;

    private ProgressDialog pDialogue;
    private String TAG=BloodListActivity.class.getSimpleName();

    ListView list;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_list);

    /*

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String url="http://:8080/DatabaseLab1/AllDonorInfoServlet";

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                hidepDialogue();

                JSONArray jsonArray = null;

                try {
                    jsonArray = response.getJSONArray("Donor_info");

                    for (int i = 0; i < jsonArray.length(); ++i) {
                        JSONObject jsonObject = null;
                        jsonObject = jsonArray.getJSONObject(i);

                        arrayList1.add(jsonObject.getString("id"));
                        arrayList2.add(jsonObject.getString("name"));
                        arrayList3.add(jsonObject.getString("phone"));



                    }

                    hidepDialogue();
                   // ListView listView = (ListView) findViewById(R.id.listView);
                   // final ListAdapter listAdapter=new ListAdapter(HomeScreen.this,arrayList1,arrayList2,arrayList3,arrayList4,arrayList5);
                   //   listView.setAdapter(listAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG,"Error: "+error.getMessage());
                hidepDialogue();
            }
        }

        );



        requestQueue.add(jsonObjectRequest);

        */

        //  Toast.makeText(getApplicationContext(),"kasdjfa",Toast.LENGTH_LONG).show();
        list = (ListView)findViewById(R.id.NEWLIST);
        parse();


        ArrayList<String> items = new ArrayList<String>();
/*

        Data.fullname.add("shamim");
        Data.fullname.add("ehsan");
        Data.fullname.add("sadia");
        Data.group.add("Apos");
        Data.group.add("Aneg");
        Data.group.add("Opos");
        Data.mobile.add("01816");
        Data.mobile.add("01687");
        Data.mobile.add("01712");

*/



    }
    private void showpDialogue(){
        if(!pDialogue.isShowing())
            pDialogue.show();
    }

    private void hidepDialogue(){

        if(pDialogue.isShowing())
            pDialogue.hide();
    }
    public void parse()
    {
         ArrayList<String> fn=new ArrayList<>();
        ArrayList<String> gr=new ArrayList<>();
        ArrayList<String> mb=new ArrayList<>();
         ArrayList<String> lc=new ArrayList<>();
       // Toast.makeText(this, Data.BloodGroupFilter, Toast.LENGTH_SHORT).show();

        for(int i=0;i<Data.fullname.size();i++)
        {
           if(Data.group.get(i).equals(Data.BloodGroupFilter) || Data.BloodGroupFilter.equals("All"))
            {
                if(Data.location.get(i).equals(Data.DistrictFilter) )
                {
                    fn.add(Data.fullname.get(i));
                    gr.add(Data.group.get(i));
                    mb.add(Data.mobile.get(i));


                }




            }



        }
        list.setAdapter(new customAdaptar(this, fn,gr,mb));



    return;
    }


}

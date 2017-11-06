package com.example.ehsan.bloodbank;

/**
 * Created by Ehsan on 2/24/2017.
 */
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HP on 5/22/2015.
 */
public class customAdaptar extends BaseAdapter {
    Activity context;
    ArrayList<String> nam;
    ArrayList<String> grp;
    ArrayList<String> mob;


    customAdaptar(Activity context ,ArrayList <String> items ,ArrayList <String> items2 ,ArrayList <String> items3 ){
        this.context= context;
        this.nam = items;
        this.grp = items2;
        this.mob= items3;



    }
    @Override
    public int getCount() {
        return nam.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView = context.getLayoutInflater().inflate(R.layout.listitem, parent , false);
            //  convertView = getLayoutInflater().from(context); same thing, works if Context context
           ImageView image = (ImageView) convertView.findViewById(R.id.img1);
            TextView txt =  (TextView) convertView.findViewById(R.id.txt1);
            Button butt = (Button) convertView.findViewById(R.id.butt1);
            if(grp.get(position).equals("Apos"))
                image.setImageResource(R.drawable.apos);
            if(grp.get(position).equals("Aneg"))
                image.setImageResource(R.drawable.aneg);
            if(grp.get(position).equals("ABpos"))
                image.setImageResource(R.drawable.abpos);
            if(grp.get(position).equals("ABneg"))
                image.setImageResource(R.drawable.abneg);
            if(grp.get(position).equals("Bpos"))
                image.setImageResource(R.drawable.bpos);
            if(grp.get(position).equals("Bneg"))
                image.setImageResource(R.drawable.bneg);
            if(grp.get(position).equals("Opos"))
                image.setImageResource(R.drawable.opos);
            if(grp.get(position).equals("Oneg"))
                image.setImageResource(R.drawable.oneg);







            txt.setText("Mr. "+nam.get(position));
            butt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+mob.get(position)));
                    context.startActivity(intent);
                   // Toast.makeText(context, "Button " + position + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }
}

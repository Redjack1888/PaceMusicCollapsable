package com.example.android.pacemusiccollapsable;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button call;
    Button web;
    Button mail;
    Button address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById (R.id.collapse_toolbar);
        collapsingToolbarLayout.setTitle("Pace Music");
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);

        Context context = this;
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(context,R.color.colorPrimary) );

        address = (Button) findViewById(R.id.address);
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addressIntent = new Intent(Intent.ACTION_VIEW);
                addressIntent.setData(Uri.parse("geo:0,0?q=Pace Music, Nizza Monferrato"));
                if (addressIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(addressIntent);
                }
            }
        });

        mail = (Button) findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"pace-music@libero.it"});
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                mailIntent.putExtra(Intent.EXTRA_TEXT, "");
                mailIntent.setType("message/rfc822");
                if (mailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mailIntent);
                }
            }
        });


        web = (Button) findViewById(R.id.weburl);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse("http://www.pacemusic.it/"));

                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });

        call = (Button) findViewById(R.id.phonenumber);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:+390141721637"));
                startActivity(callIntent);
            }
        });

    }
}

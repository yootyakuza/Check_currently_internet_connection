package com.example.support.check_currently_internet_connection;

import android.content.Context;
import android.graphics.drawable.TransitionDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;
    Button button;
    ImageView anunda_Light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        button = findViewById(R.id.but);
        anunda_Light = findViewById(R.id.anunda_Light);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionDrawable drawable = (TransitionDrawable) anunda_Light.getDrawable();

                boolean isCheckInternet = isOnline();

                if(isCheckInternet) {
                    drawable.startTransition(1000);
                    Toast.makeText(getApplicationContext(),"Online",Toast.LENGTH_SHORT).show();
                }else {
                    drawable.resetTransition();
                    Toast.makeText(getApplicationContext(),"Offline",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}

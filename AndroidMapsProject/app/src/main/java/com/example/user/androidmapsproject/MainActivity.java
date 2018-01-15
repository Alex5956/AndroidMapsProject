package com.example.user.androidmapsproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q=Taronga+Zoo,+Sydney+Australia&mode=b");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                if(mapIntent.resolveActivity(getPackageManager()) != null){
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Aucune application ne peut resoudre votre probleme !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        

    }
}

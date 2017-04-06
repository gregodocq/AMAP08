package com.example.bugs.amap08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;


/**
 * Classe de la 3ème fenêtre (les produits)
 * @author bunny
 */

public class Main3Activity extends Activity {


    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }





        /**
         * Méthode pour retourné à la fenêtre précédente
         */

    public void Retour(View v) {

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        this.finish();
    }
}



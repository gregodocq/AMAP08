package com.example.bugs.amap08;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


/**
 * Classe de la 2ème fenêtre (Les catégories)
 * @author bunny
 */

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        /*
        TODO : Tests images en statique.
        A faire => télécharger depuis le serveur Web ...
         */

    }

    Button identifiant;


    //Intent intent = getIntent();

    /**
     * Méthode pour bouton Déconnexion
     */
    public void deco(View v) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    /**
     * Méthode pour les différentes catégories
     */
    public void categorie(View v) {

        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
        this.finish();


    }


}
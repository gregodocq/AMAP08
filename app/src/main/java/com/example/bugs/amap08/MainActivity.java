package com.example.bugs.amap08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

/**
 * Classe de la 1ère fenêtre (Authentification)
 * @author bunny
 */


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    EditText identifiant;
    EditText password;

    //android:windowSoftInputMode="stateAlwaysHidden"
    //String login="bugs";
    //String motDePasse="bunny";

    /**
     * Méthode pour la verification des identifiants
     */

    public void connexion(View view) {

        //Log.e("=>", "etat");
        identifiant= (EditText) findViewById (R.id.editText3);
        String login = identifiant.getText().toString();

        password=(EditText) findViewById(R.id.editText2);
        String motDePasse=password.getText().toString();


        ConnexionHTTP connexion = new ConnexionHTTP();
        connexion.execute("http://10.10.9.147/Android/index.php", login, motDePasse);

        try
        {
            if(connexion.get())
            {
                XMLParseur parseurXML=new XMLParseur(connexion.getXML());
                //String test = parseurXML.getValue("status");
                //Log.e("=>", test);

                if(parseurXML.getValue("status").compareTo("-2")==0)
                {
                /* Erreur */
                    Toast.makeText(this,"Erreur de login et/ou mot de passe", Toast.LENGTH_LONG).show();
                }
                else
                {
                /* Démarrage de la seconde activité */

                    Intent intent = new Intent(this, Main2Activity.class);
                    startActivity(intent);
                    this.finish();


                }
            }
            else Toast.makeText(this,"Echec lors de la connexion", Toast.LENGTH_LONG).show();
        }
        catch(InterruptedException e)
        {
            Log.w("connexion","Interruption lecture fichier");
        }
        catch(ExecutionException e)
        {
            Log.w("connexion","Problème exécution");
        }
    }


}


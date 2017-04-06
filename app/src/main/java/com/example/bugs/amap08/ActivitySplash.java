package com.example.bugs.amap08;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.AnyRes;
import android.widget.Toast;

public class ActivitySplash extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    public Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            /*
             * Affichage de l'écran de démarrage avec une minuterie
             *
             */


            @Override
            public void run() {

                // Cette méthode sera exécutée une fois la minuterie terminée
                // Démarrez l'activité principale de votre application
                if(ActivitySplash.isNetworkAvailable(activity.getApplicationContext())) {

                    Intent i = new Intent(ActivitySplash.this, MainActivity.class);
                    startActivity(i);

                    // Fermer l'activité
                    finish();
                }
                else {

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(activity);
                    builder1.setMessage("Echec lors de la connexion.");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Annuler",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    finish();

                                }
                            });

                    builder1.setNegativeButton(
                            "Réessayer",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();





                    //Toast.makeText(activity, "Echec lors de la connexion. Veuillez réessayer", Toast.LENGTH_SHORT).show();
                    //activity.finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }



    /**
     * Méthode de vérification de réseau
     *
     */

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}














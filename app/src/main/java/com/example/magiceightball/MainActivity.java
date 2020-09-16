package com.example.magiceightball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ballIV;
    private TextView answerTV;
    private Button btnwp;

    private String[] answersArray = {"Es seguro.", "Definitivamente si.", "Sin duda.", "Si, definitivamente.", "Podés confiar en eso.", "Como lo veo, si.", "Es lo mas probable.", "Va a salir bien.", "Si.", "Todo indica que si.", "No se ve claro, vuelve a intentarlo.", "Pregunta de nuevo despues.", "Mejor no te digo ahora.", "No puedo predecir en este momento.", "Concentrate y pregunta nuevamente.", "No cuentes con eso.", "Mi respuesta es no.", "Mis fuentes dicen que no.", "El resultado no va a ser tan bueno.", "Lo dudo."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ballIV = findViewById(R.id.btn);
        answerTV = findViewById(R.id.respuesta);

        ballIV.setOnClickListener(this);

        btnwp=(Button)findViewById(R.id.btn_wp);

        btnwp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"¡Hola Amalia!¡Te contacto a traves de tu app!");
                i.putExtra("jid","5491136658231"+"@s.whatsapp.net");
                i.setPackage("com.whatsapp");
                startActivity(i);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn:

                int rand = new Random().nextInt(answersArray.length);
                answerTV.setText(answersArray[rand]);

                break;

        }
    }
}
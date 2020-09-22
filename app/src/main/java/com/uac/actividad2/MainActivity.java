package com.uac.actividad2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText x1, y1, x2, y2, totalDistancia;
    Button puntoMedio, pendiente, cuadrante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x1 = findViewById(R.id.x1Text);
        x2 = findViewById(R.id.x2Text);
        y1 = findViewById(R.id.y1Text);
        y2 = findViewById(R.id.y2Text);
        totalDistancia = findViewById(R.id.distanciaTotal);
        puntoMedio = findViewById(R.id.puntoMedioBtn);
        pendiente = findViewById(R.id.pendienteBtn);
        cuadrante = findViewById(R.id.cuadranteBtn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.aleatorio:
                AsignarNums();
                Toast.makeText(this, "Aleatorio seleccionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.distancia:
                CalcularDistancia();
                Toast.makeText(this, "Distancia seleccionado", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public int NumAleatorio() {
        Random r = new Random();
        int mayor = 50;
        int result = r.nextInt(mayor) * (r .nextBoolean() ? -1 : 1);
        return result;
    }

    public void AsignarNums() {
        x1.setText("" + NumAleatorio());
        x2.setText("" + NumAleatorio());
        y1.setText("" + NumAleatorio());
        y2.setText("" + NumAleatorio());
    }

    public void CalcularDistancia() {
        int X1, Y1, X2, Y2;
        X1 = Integer.parseInt(x1.getText().toString());
        X2 = Integer.parseInt(x2.getText().toString());
        Y1 = Integer.parseInt(y1.getText().toString());
        Y2 = Integer.parseInt(y2.getText().toString());
        totalDistancia.setText("" + Math.sqrt((Math.pow((X1-Y1),2) + Math.pow((X2 - Y2),2))));
    }
}
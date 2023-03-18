package com.cursoandroid.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imgResultado = findViewById(R.id.imgResultado);
        TextView textoResultado = findViewById(R.id.textResultado);


        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "pedra":
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        // Caso em que o APP seja o GANHADOR
        if(
                escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura") ||
                escolhaApp.equals("papel") && escolhaUsuario.equals("pedra") ||
                escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel")
        ) {
            textoResultado.setText("Você PERDEU :(");
        } else if( //Caso em que o Usuário seja o GANHADOR
                escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura") ||
                escolhaUsuario.equals("papel") && escolhaApp.equals("pedra") ||
                escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel")
        ) {
            textoResultado.setText("Você GANHOU :)");
        } else { // Caso der empate
            textoResultado.setText("EMPATAMOS :)");
        }


    }
}
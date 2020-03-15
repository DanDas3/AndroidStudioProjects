package br.com.dandas3.jumper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import br.com.dandas3.jumper.engine.Game;

public class MainActivity extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = findViewById(R.id.container);

        game = new Game(this);
        container.addView(game);
    }

    @Override
    protected void onPause() {
        super.onPause();
        game.cancela();
    }

    @Override
    protected void onResume() {
        super.onResume();
        game.inicia();
          new Thread(game).start();
    }
}

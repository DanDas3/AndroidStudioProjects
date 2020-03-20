package br.com.dandas3.jumper.elementos;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.dandas3.jumper.R;
import br.com.dandas3.jumper.basicos.Cores;
import br.com.dandas3.jumper.engine.Tela;

import static br.com.dandas3.jumper.R.*;

public class Passaro {
    private static final int X = 100;
    private static final int RAIO = 50;
    private static final Paint vermelho = Cores.getCorPassaro();

    private int altura;
    private Tela tela;

    public Passaro(Tela tela) {
        this.altura = 100;
        this.tela = tela;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawCircle(X, this.altura, RAIO, vermelho);
    }

    public void cai() {
        boolean chegouChao = (altura + RAIO) > tela.getAltura();

        if(!chegouChao) {
            this.altura += 5;
        }
    }

    public void pula() {
        if(this.altura > RAIO) {
            this.altura -= 150;
        }
    }
}

package br.com.dandas3.jumper.elementos;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.dandas3.jumper.engine.Tela;

public class Canos {
    private static final int QUANTIDADE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 250;
    private Tela tela;
    private List<Cano> canos = new ArrayList<Cano>();

    public Canos(Tela tela) {
        int posicaoInicial = 200;
        this.tela = tela;
        for (int i = 0; i < QUANTIDADE_CANOS; i++) {
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(this.tela, posicaoInicial));
        }
    }

    public void desenhaNo(Canvas canvas) {
        for(Cano cano: canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {
        ListIterator<Cano> iterator = canos.listIterator();
        while (iterator.hasNext()) {
            Cano cano = (Cano) iterator.next();
            cano.move();

            if(cano.saiuTela()) {
                Cano outroCano = new Cano(this.tela, getMaximo()+ DISTANCIA_ENTRE_CANOS);
                iterator.add(outroCano);
            }
        }
        for(Cano cano: canos) {
            cano.move();
        }
    }

    private int getMaximo() {

    }
}

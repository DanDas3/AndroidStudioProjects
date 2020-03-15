package br.com.dandas3.jumper.elementos;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import br.com.dandas3.jumper.basicos.Cores;
import br.com.dandas3.jumper.engine.Tela;

public class Cano {

    private static final int TAMANHO_CANO = 250;
    private static final int LARGURA_CANO = 100;

    private int alturaCanoInferior;
    private int alturaCanoSuperior;
    private int posicao;

    private Tela tela;

    public Cano(Tela tela, int posicao) {
        this.tela =  tela;
        this.posicao = posicao;
        this.alturaCanoSuperior = TAMANHO_CANO + this.valorAleatorio();
        this.alturaCanoInferior = this.tela.getAltura() - TAMANHO_CANO - this.valorAleatorio();
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    public void desenhaNo(Canvas canvas) {
        this.desenhaCanoInferiorNo(canvas);
        this.desenhaCanoSuperiorNo(canvas);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas) {
        canvas.drawRect(posicao, 0, posicao+LARGURA_CANO, alturaCanoSuperior, Cores.getCorCano());
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect(posicao, alturaCanoInferior, posicao+LARGURA_CANO, tela.getAltura(), Cores.getCorCano());
    }

    public void move() {
        posicao -= 5;
    }

    public boolean saiuTela() {
        return posicao + LARGURA_CANO < 0;
    }
}

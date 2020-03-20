package br.com.dandas3.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.dandas3.jumper.R;
import br.com.dandas3.jumper.elementos.Cano;
import br.com.dandas3.jumper.elementos.Canos;
import br.com.dandas3.jumper.elementos.Passaro;

public class Game extends SurfaceView  implements Runnable, View.OnTouchListener {

    private final SurfaceHolder holder = this.getHolder();

    private boolean isRunning = true;
    private Passaro passaro;
    private Tela tela;
    private Bitmap background;
    private Canos canos;

    public Game(Context context) {
        super(context);
        this.inializaElementos();
        this.setOnTouchListener(this);
        this.tela = new Tela(context);
        Bitmap back = BitmapFactory.decodeResource(this.getResources(), R.drawable.background);
        this.background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);
    }

    private void inializaElementos() {
        this.passaro = new Passaro(this.tela);
        this.canos = new Canos(this.tela);
    }

    @Override
    public void run(){

        while (this.isRunning) {
            if(!holder.getSurface().isValid()) {
                continue;
            }
            Canvas canvas = holder.lockCanvas();

            canvas.drawBitmap(background, 0, 0, null);
            passaro.desenhaNo(canvas);
            passaro.cai();

            this.canos.desenhaNo(canvas);
            this.canos.move();
            this.holder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        passaro.pula();
        return false;
    }

    public void cancela() {
        this.isRunning = false;
    }

    public void inicia() {
        this.isRunning = true;
    }
}

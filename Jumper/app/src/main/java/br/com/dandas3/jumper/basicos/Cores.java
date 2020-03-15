package br.com.dandas3.jumper.basicos;

import android.graphics.Paint;

public class Cores {
    public static Paint getCorPassaro() {
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        return vermelho;
    }

    public static Paint getCorCano() {
        Paint verde = new Paint();
        verde.setColor(0xFF00FF00);
        return verde;
    }
}

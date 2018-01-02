package popkovanton.simplearcanoid.logic;


import android.graphics.Canvas;
import android.graphics.Paint;

import popkovanton.simplearcanoid.MainPlatform;

public class GameManager {
    private MainPlatform mainPlatform;
    private Paint paint;

    public GameManager() { //инициализация главного игрового цикла и paint
        initMainPlatform();
        initPaint();
    }

    private void initPaint() { // инициализация кисти для рисования
        paint = new Paint();
        paint.setAntiAlias(true); //сглаживание
        paint.setStyle(Paint.Style.FILL); //заливка
    }

    private void initMainPlatform() {
        mainPlatform = new MainPlatform(300, 500);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawRect(mainPlatform.getLeft(), mainPlatform.getTop(), mainPlatform.getRight(), mainPlatform.getBottom(), paint);
    }
}

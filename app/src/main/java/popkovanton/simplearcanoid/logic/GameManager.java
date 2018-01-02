package popkovanton.simplearcanoid.logic;


import android.graphics.Canvas;
import android.graphics.Paint;

import popkovanton.simplearcanoid.CanvasView;
import popkovanton.simplearcanoid.MainPlatform;

public class GameManager {
    private MainPlatform mainPlatform;
    private CanvasView canvasView;
    private static int width;
    private static int height;
    private Paint paint;

    public GameManager(CanvasView canvasView, int windowWidth, int windowHeight) { //инициализация главного игрового цикла и paint
        this.canvasView = canvasView;
        width = windowWidth;
        height = windowHeight;
        initMainPlatform();
        initPaint();
    }

    private void initPaint() { // инициализация кисти для рисования
        paint = new Paint();
        paint.setAntiAlias(true); //сглаживание
        paint.setStyle(Paint.Style.FILL); //заливка
    }
    private void initMainPlatform() {
        mainPlatform = new MainPlatform(width/3, width/2);
    }
    public void onDraw(Canvas canvas) {
        canvas.drawRect(mainPlatform.getLeft(), mainPlatform.getTop(), mainPlatform.getRight(), mainPlatform.getBottom(), paint);
    }
}

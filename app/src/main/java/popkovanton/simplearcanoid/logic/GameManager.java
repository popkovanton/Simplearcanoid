package popkovanton.simplearcanoid.logic;


import android.util.Log;

import popkovanton.simplearcanoid.view.CanvasView;
import popkovanton.simplearcanoid.data.MainPlatform;
import popkovanton.simplearcanoid.data.SimpleCircle;

public class GameManager  {
    private static final String TAG = "touch";
    private MainPlatform mainPlatform;
    private SimpleCircle simpleCircle;
    private CanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(CanvasView canvasView, int windowWidth, int windowHeight) { //инициализация главного игрового цикла и paint
        this.canvasView = canvasView;
        width = windowWidth;
        height = windowHeight;
        initMainPlatform();
        initSimpleCircle();
    }


    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initMainPlatform() {
        mainPlatform = new MainPlatform((width / 2) - 100, (width / 2) + 100, height - 200, height - 190);
    }

    private void initSimpleCircle() {
        simpleCircle = new SimpleCircle(width / 2, height / 2, SimpleCircle.CIRCLE_RADIUS, SimpleCircle.CIRCLE_SPEED, SimpleCircle.CIRCLE_SPEED);
    }

    public void onDraw() {
        canvasView.drawPlatform(mainPlatform);
        canvasView.drawCircle(simpleCircle);
    }

    public void onTouchEvent(int x, int y) {
        mainPlatform.moveMainPlatformWhenTouchAt(x, y);
    }

    private void checkCollision() { //проверка прикосновения к платформе
        if (mainPlatform.isIntersect(simpleCircle)) {
            Log.d(TAG, "ПРИКОСНОВЕНИЕ К ПЛАТФОРМЕ");
            simpleCircle.checkPlatformBound();
        }
    }

    public void moveCircle() {
        simpleCircle.moveOneStep();
        checkCollision();
    }

}

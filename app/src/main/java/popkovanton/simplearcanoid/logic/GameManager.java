package popkovanton.simplearcanoid.logic;


import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import popkovanton.simplearcanoid.CanvasView;
import popkovanton.simplearcanoid.MainPlatform;
import popkovanton.simplearcanoid.SimpleCircle;

public class GameManager {
    private static final String TAG = "myLogs";
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
        initSimpleCirlce();
        moveCircle();
    }


    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initMainPlatform() {
        Log.d(TAG, "ширина равна " + width);
        Log.d(TAG, "высота равна " + height);
        mainPlatform = new MainPlatform((width / 2) - 100, (width / 2) + 100, height - 300, height - 250);
    }

    private void initSimpleCirlce() {
        simpleCircle = new SimpleCircle(width / 2, height / 2, SimpleCircle.CIRCLE_RADIUS, SimpleCircle.CIRCLE_SPEED, SimpleCircle.CIRCLE_SPEED);
    }

    public void onDraw() {
        canvasView.drawPlatform(mainPlatform);
        canvasView.drawCircle(simpleCircle);
    }

    public void onTouchEvent(int x, int y) {
        mainPlatform.moveMainPlatformWhenTouchAt(x, y);
        //moveCircle();
    }

    public void moveCircle() {
            //simpleCircle.moveOneStep();
            simpleCircle.moveOneStep();
    }


/*class ProgressTask extends Thread {
        public Handler mHandler;
        @Override
        public void run() {
            Looper.prepare();
            mHandler = new Handler() {

            }
            Looper.loop();
        }
    }*/
}

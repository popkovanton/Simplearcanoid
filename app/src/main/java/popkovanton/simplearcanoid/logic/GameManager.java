package popkovanton.simplearcanoid.logic;


import android.util.Log;

import popkovanton.simplearcanoid.CanvasView;
import popkovanton.simplearcanoid.MainPlatform;

public class GameManager {
    private static final String TAG = "myLogs";
    private MainPlatform mainPlatform;
    private CanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(CanvasView canvasView, int windowWidth, int windowHeight) { //инициализация главного игрового цикла и paint
        this.canvasView = canvasView;
        width = windowWidth;
        height = windowHeight;
        initMainPlatform();

    }

    public static int getWidth() {
        return width;
    }

    private void initMainPlatform() {
        Log.d(TAG, "ширина равна " + width);
        Log.d(TAG, "высота равна " + height);
        mainPlatform = new MainPlatform((width / 2) - 100, (width / 2) + 100, height - 300, height - 250);
    }

    public void onDraw() {
        canvasView.drawPlatform(mainPlatform);
    }

    public void onTouchEvent(int x, int y) {
        mainPlatform.moveMainPlatformWhenTouchAt(x, y);
    }
}

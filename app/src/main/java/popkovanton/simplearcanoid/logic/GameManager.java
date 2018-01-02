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

    public GameManager(CanvasView canvasView, int windowWidth, int windowHeight) { //инициализация главного игрового цикла и paint
        this.canvasView = canvasView;
        width = windowWidth;
        height = windowHeight;
        initMainPlatform();

    }

    private void initMainPlatform() {
        mainPlatform = new MainPlatform(width / 3, width / 2);
    }
    public void onDraw() {
        canvasView.drawPlatform(mainPlatform);
    }
}

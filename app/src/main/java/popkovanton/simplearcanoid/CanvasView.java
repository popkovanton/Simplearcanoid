package popkovanton.simplearcanoid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import popkovanton.simplearcanoid.logic.GameManager;


// класс, помогающий рисовать
public class CanvasView extends View {
    private static int windowWidth;
    private static int windowHeight;
    private GameManager gameManager;

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initWidthAndHeight(context);
        gameManager = new GameManager(this, windowWidth, windowHeight);
    }

    private void initWidthAndHeight(Context context) { //узнаем размер окна
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay(); //получаем дисплей
        Point point = new Point();
        display.getSize(point); //возвращает координаты внутри точки, правая нижня точка экрана
        windowWidth = point.x;
        windowHeight = point.y;
    }

    @Override
    protected void onDraw(Canvas canvas) { //запускается при вызове CanvasView
        super.onDraw(canvas);
        gameManager.onDraw(canvas);
    }
}

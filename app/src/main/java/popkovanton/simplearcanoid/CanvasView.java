package popkovanton.simplearcanoid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import popkovanton.simplearcanoid.logic.GameManager;


// класс, помогающий рисовать
public class CanvasView extends View implements ICanvasView {
    private static int windowWidth;
    private static int windowHeight;
    private GameManager gameManager;
    private Paint paint;
    private Canvas canvas;

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initWidthAndHeight(context);
        initPaint();
        gameManager = new GameManager(this, windowWidth, windowHeight);
    }


    private void initPaint() { // инициализация кисти для рисования
        paint = new Paint();
        paint.setAntiAlias(true); //сглаживание
        paint.setStyle(Paint.Style.FILL); //заливка
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
        this.canvas = canvas;
        gameManager.onDraw();
    }

    @Override
    public void drawPlatform(MainPlatform platform) {
        canvas.drawRect(platform.getLeft(), platform.getTop(), platform.getRight(), platform.getBottom(), paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_MOVE) { //двигается ли палец по экрану
            gameManager.onTouchEvent(x, y);
        }
        invalidate(); // перерисовка view element
        return true;
    }
}

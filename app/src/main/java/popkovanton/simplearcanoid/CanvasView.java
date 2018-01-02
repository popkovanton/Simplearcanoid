package popkovanton.simplearcanoid;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import popkovanton.simplearcanoid.logic.GameManager;


// класс, помогающий рисовать
public class CanvasView extends View {
    private GameManager gameManager;


    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        gameManager = new GameManager();

    }

    @Override
    protected void onDraw(Canvas canvas) { //запускается при вызове CanvasView
        super.onDraw(canvas);
        gameManager.onDraw(canvas);
    }
}

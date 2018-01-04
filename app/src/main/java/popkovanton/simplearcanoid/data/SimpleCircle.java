package popkovanton.simplearcanoid.data;


import android.graphics.Color;
import android.util.Log;

import java.util.Random;

import popkovanton.simplearcanoid.logic.GameManager;

public class SimpleCircle {
    private static final String TAG = "circleCoordinate";
    public static final int CIRCLE_COLOR = Color.BLUE;
    public static final int CIRCLE_SPEED = 10;
    public static final int CIRCLE_RADIUS = 10;
    private int x;
    private int y;
    private int radius;
    private int color;
    private int dx;
    private int dy;

    public SimpleCircle(int x, int y, int radius, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.dx = dx;
        this.dy = dy;
        setColor(CIRCLE_COLOR);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void moveOneStep() {
            x += dx;
            y += dy;
            checkWallBounds();
            Log.d(TAG, "circle x= "+x+" circle y= "+y);
    }
    // отталкивание от краев экрана
    private void checkWallBounds() {
        if (x > GameManager.getWidth() || x < 0) {
            dx = -dx;
        }
        if (y > GameManager.getHeight() || y < 0) {
            dy = -dy;
        }
    }
    // отталкивание от платформы
    public void checkPlatformBound() {
            dy = -dy;
    }

}

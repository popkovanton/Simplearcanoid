package popkovanton.simplearcanoid;


import android.graphics.Color;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

import popkovanton.simplearcanoid.logic.GameManager;

public class SimpleCircle {
    public static final int CIRCLE_COLOR = Color.BLUE;
    public static final int CIRCLE_SPEED = 5;
    public static final int CIRCLE_RADIUS = 10;
    //public static final int INIT_RADIUS =10;
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
            checkBounds(); // отталкивание от краев экрана
            Log.d("myLogs", "x= "+x+" y= "+y);
    }

    private void checkBounds() {
        if (x > GameManager.getWidth() || x < 0) {
            dx = -dx;
        }
        if (y > GameManager.getHeight() || y < 0) {
            dy = -dy;
        }
    }

}

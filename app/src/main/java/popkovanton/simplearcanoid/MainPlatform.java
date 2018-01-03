package popkovanton.simplearcanoid;


import popkovanton.simplearcanoid.logic.GameManager;

//платформа, которой мы управляем
public class MainPlatform {

    public static final int MAIN_SPEED = 100;
    //public static final int INIT_TOP = 900;
    //public static final int INIT_BOTTOM = 950;
    private int top;
    private int bottom;
    private int left;
    private int right;

    public MainPlatform(int left, int right, int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }
    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public void moveMainPlatformWhenTouchAt(int x1, int y1) {
        int x = ((right - left) / 2) + left; // центр платформы
        int dx = (x1 - x) * MAIN_SPEED / GameManager.getWidth();
        //int dleft = (left - x1) * MAIN_SPEED / GameManager.getWidth();
        right += dx;
        left += dx;
    }
}

package popkovanton.simplearcanoid;


//платформа, которой мы управляем
public class MainPlatform {

    public static final int INIT_TOP = 900;
    public static final int INIT_BOTTOM = 950;
    private int top;
    private int bottom;
    private int left;
    private int right;

    public MainPlatform(int left, int right) {
        top = INIT_TOP;
        bottom = INIT_BOTTOM;
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
}

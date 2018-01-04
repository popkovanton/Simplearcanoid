package popkovanton.simplearcanoid.view;


import popkovanton.simplearcanoid.data.MainPlatform;
import popkovanton.simplearcanoid.data.SimpleCircle;

public interface ICanvasView {
    void drawPlatform(MainPlatform platform);
    void drawCircle(SimpleCircle circle);
}

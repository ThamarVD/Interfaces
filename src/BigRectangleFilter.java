import java.awt.*;

public class BigRectangleFilter implements Filter{
    @Override
    public boolean accept(Object x) {
        Rectangle rect = (Rectangle) x;
        return ((2* rect.width) + (2* rect.height)) > 10;
    }
}

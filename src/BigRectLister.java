import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Object> rects = new ArrayList<>();
        rects.add(new Rectangle(5, 5));
        rects.add(new Rectangle(1, 2));
        rects.add(new Rectangle(7, 10));
        rects.add(new Rectangle(2, 2));
        rects.add(new Rectangle(3, 4));
        rects.add(new Rectangle(4, 5));

        ArrayList<Object> accRects = collectAll(rects);
        for(Object rect : accRects){
            Rectangle aRect = (Rectangle) rect;
            System.out.println("Rectangle with a width of " + aRect.width + " and a height of " + aRect.height + " is big");
        }
    }

    static ArrayList<Object> collectAll(ArrayList<Object> rects){
        BigRectangleFilter bigRF = new BigRectangleFilter();
        ArrayList<Object> accRects = new ArrayList<>();
        for(Object rect : rects)
            if(bigRF.accept(rect))
                accRects.add(rect);

        return  accRects;
    }
}

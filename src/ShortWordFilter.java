public class ShortWordFilter implements Filter{
    @Override
    public boolean accept(Object x) {
        String str = (String) x;
        return (str.length() < 5);
    }
}

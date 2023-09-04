public class Dimensions {

    private final double width; //ширина
    private final double height; //высота
    private final double length; //длина



    public Dimensions(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }



    public double volume (double width, double height,double length) {
        return width*height*length;
    }

    public double volume (){
        return volume(width,height,length);
    }


    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }
}

public class Cargo {


    private final Dimensions dimensions; //габариты
    private final  double weight; //масса
    private final String address; //адрес доставки
    private  final boolean isFlipped; //свойство — можно ли переворачивать
    private  final String regNumber; //регистрационный номер (может содержать буквы)
    private  final boolean isFragile; //является ли груз хрупким


    public Cargo(Dimensions dimensions, double weight, String address,
                 boolean isFlipped, String regNumber, boolean isFragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.address = address;
        this.isFlipped = isFlipped;
        this.regNumber = regNumber;
        this.isFragile = isFragile;
    }


    /*Реализуйте в классе методы, дающие возможность изменять адрес доставки,
    габариты и массу груза без изменения исходного объекта путём создания его копии.*/


    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(dimensions,weight,address,isFlipped,regNumber,isFragile);
    }
    public Cargo setWeight(double weight) {
        return new Cargo(dimensions,weight,address,isFlipped,regNumber,isFragile);
    }
    public Cargo setAddress(String address) {
        return new Cargo(dimensions,weight,address,isFlipped,regNumber,isFragile);
    }


    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getAddress() {
        return address;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public boolean isFragile() {
        return isFragile;
    }

public String toString () {

        return "регистрационный номер: "  + regNumber + "\n" +
                "адрес доставки: " + address + "\n" +
                "ширина: " + dimensions.getWidth() +  "\n" +
                "высота: " + dimensions.getHeight() +  "\n" +
                "длина: " + dimensions.getLength() +   "\n"  +
                "масса: " + weight + "\n" +
                "можно ли переворачивать: " + isFlipped +"\n" +
                "хрупкий груз: " + isFragile +"\n" +
                "объем: " + dimensions.volume();
    }

}

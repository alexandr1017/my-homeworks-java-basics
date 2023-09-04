public class TestCargo {
    public static void main(String[] args) {
        Cargo cg = new Cargo(new Dimensions(10,14,11.2),50,
                        "ул. Ленина",true, "KK123",false);
        System.out.println(cg.toString());

        System.out.println();

        cg.setAddress("пл. Пушкина");
        cg.setDimensions(new Dimensions(30,11,2));
        cg.setWeight(1);

        Cargo copy = cg.setAddress("п.Косино");
        System.out.println(cg.toString());

        System.out.println();

        System.out.println(copy.toString());


    }
}

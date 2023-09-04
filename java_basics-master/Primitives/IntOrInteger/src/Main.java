public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.


        int e1 = (int) 'ё';
        int e2 = (int) 'Ё';

        for (char i = 'А'; i <= 'Я'; i++) {
            int c = (int) i;
            System.out.println(i + " - " + c);
        }

        System.out.println();

        for (char i = 'а'; i <= 'я'; i++) {
            int c = (int) i;
            System.out.println(i + " - " + c);
        }

        System.out.println();

        System.out.println(e2 + " - " + 'Ё');
        System.out.println(e1 + " - " + 'ё' + '\n');


        //А-Е
        for (int i = 1040; i <= 1045; i++) {
            char oneC = (char) i;
            System.out.println(i + " - " + oneC);
        }

        //Ё
        int j = 1025;
        char c1 = (char) j;
        System.out.println(j + " - " + c1);

        //Ж-е
        for (int i = 1046; i <= 1077; i++) {
            char twoC = (char) i;
            System.out.println(i + " - " + twoC);
        }

        //ё
        int k = 1105;
        char c2 = (char) k;
        System.out.println(j + " - " + c2);

        //ж-я
        for (int i = 1078; i <= 1103; i++) {
            char threeC = (char) i;
            System.out.println(i + " - " + threeC);
        }
    }
}

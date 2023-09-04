package practice.twoDimensionalArray;

public class TwoDimensionalArray {
    public static char[][] chars;
    public static final char SYMBOL = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        chars = new char[size][size];

        for (int i = 0; i < chars.length; i++){
            chars[i][i] = SYMBOL;
        chars[chars.length - 1 - i][i] = SYMBOL;
    }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!Character.isLetter(chars[i][j])) {
                    chars[i][j]=' ';
                }
            }
        }

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ SYMBOL по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        return chars;
    }
}

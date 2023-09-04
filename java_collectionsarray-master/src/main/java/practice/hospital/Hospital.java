package practice.hospital;

public class Hospital {
    public static double temperatureSum;
    public static double temperatureAvg;
    public static int count;
    public static float[] temperature;

    public static float[] generatePatientsTemperatures(int patientsCount) {
        temperature = new float[patientsCount];
        for (int i = 0; i < temperature.length; i++) {
            temperature[i] = (float) Math.round((Math.random() * (40.0 - 32.0) + 32.0) * 10) / 10;
        }
        return temperature;
    }

    public static String getReport(float[] temperature) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
            Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой,
            а температуры каждого пациента до 1 знака после запятой
        */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temperature.length; i++) {
            sb.append(temperature[i]).append(" ");
            if (temperature[i] >= 36.2f && temperature[i] <= 36.9f) {
                count++;
            }
            temperatureSum += temperature[i];
        }
        temperatureAvg = (double) Math.round(((temperatureSum / temperature.length) * 100)) / 100;

        String report =
                "Температуры пациентов: " + sb.toString().trim() +
                        "\nСредняя температура: " + temperatureAvg +
                        "\nКоличество здоровых: " + count;
        return report;
    }
}
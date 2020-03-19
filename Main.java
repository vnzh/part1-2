public class Main extends Thread {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        first();
        second();
    }//main


//1. Необходимо написать два метода, которые делают следующее:
//            1) Создают одномерный длинный массив, например:
//
//    static final int size = 10000000;
//    static final int h = size / 2;
//    float[] arr = new float[size];
//
//2) Заполняют этот массив единицами;
//3) Засекают время выполнения: long a = System.currentTimeMillis();
//4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//5) Проверяется время окончания метода System.currentTimeMillis();
//6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
//Отличие первого метода от второго:
//    Первый просто бежит по массиву и вычисляет значения.
//    Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
//    Пример деления одного массива на два:


    public static void first () {
        float[] arr = new float[size];
        arr = toFillByOne(arr);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f +(float) i / 5) * Math.cos(0.2f +
                    (float)i / 5) * Math.cos(0.4f + (float)i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
        System.out.println("a[0]  =" + arr[0]);
        System.out.println("a[9999999] = " + arr[arr.length - 1]);
    }

    public static void second () {

        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        arr = toFillByOne(arr);
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        long separetionTime = System.currentTimeMillis();
        System.out.println("Separetion end  " + (separetionTime -a));

        Runnable task = () -> {        for (int i = 0; i < a1.length; i++) {
            a1[i] = (float) (a1[i] * Math.sin(0.2f + (float)i / 5) * Math.cos(0.2f +
                    (float)i / 5) * Math.cos(0.4f + (float)i / 2));
        }
        };
        Thread thread = new Thread(task);
        thread.start();
//        while (thread.isAlive()) {
//
//        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long calculationTimeFirst  = System.currentTimeMillis();
        System.out.println("Calculation first  " + (calculationTimeFirst - separetionTime));

        Runnable task2 = () -> {
            int iH = h; //  variable  formed by    i+h;
            for (int i = 0; i < a2.length; i++, iH++) {
            a2[i] = (float) (a2[i] * Math.sin(0.2f + (float)(iH) / 5) * Math.cos(0.2f +
                    (float)(iH) / 5) * Math.cos(0.4f + (float)(iH) / 2));
            }
        };
        thread = new Thread(task2);
        thread.start();
//        while (thread.isAlive()) {
//        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        for (int i = 0; i < a1.length; i++) {
//
//            a1[i] = (float) (a1[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f +
//                    (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
//        }
        long calculationTimeSecond  = System.currentTimeMillis();
        System.out.println("Calculation second  " + (calculationTimeSecond -calculationTimeFirst));
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long end = System.currentTimeMillis();
        System.out.println("End " + (end - calculationTimeSecond));
        System.out.println("Total  " + (end - a));
        System.out.println("a[0]  =" + arr[0]);
        System.out.println("a[9999999] = " + arr[arr.length-1]);

    }


    private static float[] toFillByOne (float[] f) {
        for (int i = 0; i < f.length; i++) {
            f[i] = (float) 1.0;
        }
        return f;
    }//toFillByOne


}

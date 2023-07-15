// Пусть дан произвольный список целых чисел.

// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее арифметическое значение

package HomeWork03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class HomeWork03 {
    public static List<Integer> arr(List<Integer> inList,int size) {            // Метод для заполнения списка случайными числами
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            inList.add(rnd.nextInt(100));   // Заполняет в диапазоне (0, 99]
        }
        return inList;
    }
    public static void main(String[] args) {
        Integer numb = 10;                      // Заранее определяем объем случайного массива (чтоб не вводить с клавиатуры)
        List<Integer> rndlist = new ArrayList<>();
        arr(rndlist, numb);
        System.out.println(rndlist);

        double summ = 0;
        double summShort = 0;
        Integer min = rndlist.get(0);
        Integer max = rndlist.get(1);
        double startMean = 0;
        double endMean = 0;

        if (rndlist.get(0) > rndlist.get(1)) {
            min = rndlist.get(1);
            max = rndlist.get(0);
        }

        int startSize = rndlist.size();

        Iterator iter = rndlist.iterator();

        while (iter.hasNext()) {
            Integer item = (Integer) iter.next();
            if (item > max) max = item;
            if (item < min) min = item;
            summ += item;
            if (item % 2 == 0) iter.remove();
            else summShort += item;
        }

        startMean = summ / startSize;
        endMean = summShort / rndlist.size();

        System.out.println("Max число в списке: " + max);
        System.out.println("Min число в списке: " + min);
        System.out.println("Среднее арифметическое списка: " + startMean);
        System.out.println("Список после исключения четных чисел: " + rndlist);
        System.out.println("Среднее арифметическое списка после исключения четных чисел: " + endMean);
    }
}

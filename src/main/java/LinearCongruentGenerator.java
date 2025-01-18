
/*Завдання 4
Використовуючи Stream.iterate, створіть нескінченний стрім випадкових чисел, але не використовуючи Math.random().

Реалізуйте свій лінійний конгруентний генератор.
Для цього почніть з x[0] = seed, і далі кожний наступний елемент рахуйте
за формулою на зразок x[n + 1] = 1 (a x[n] + c) % m для коректних значень a, c, та m.

Необхідно імплементувати метод, що приймає на вхід параметри a, c, та m, і повертає Stream<Long>.

Для тесту використовуйте такі дані:

a = 25214903917
c = 11
m = 2^48 (2 в степені48`)*/


import java.util.stream.Stream;

@FunctionalInterface
interface CongruentGenerator{
    Stream<Long> process(long seed, long a, long c, long m);
}


class LinearCongruentGenerator {

    private Stream<Long> processCongruentGenerator(long seed, long a, long c, long m, CongruentGenerator process){
        return process.process(seed,a,c,m);
    }

    public Stream<Long> linearCongruentGenerator(long seed, long a, long c, long m) {
        return processCongruentGenerator(seed, a, c, m, (s, A,C,M) ->
                Stream.iterate(s, x -> (A * x + C) % M)
                /*x[n + 1] = (a x[n] + c) % m*/
        );

    }



}

class TestLinearCongruentGenerator {
    public static void main(String[] args) {
        LinearCongruentGenerator test = new LinearCongruentGenerator();

        // Тестові параметри
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        long seed = 0L;

        // Генерація чисел
        Stream<Long> random = test.linearCongruentGenerator(seed, a, c, m);

        // Виведення перших 10 чисел
        random.limit(10).forEach(System.out::println);
    }
}


/*Завдання 5
Напишіть метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
який "перемішує" елементи зі стрімів first та second,
зупиняючись тоді, коли у одного зі стрімів закінчаться елементи.*/


import java.util.stream.Stream;

class StopFunction {
    public static <T>Stream<T> zip(Stream<T> first, Stream<T> second){

    }
}

class TestStopFunction{
    public static void main(String[] args) {
        StopFunction ziped = new StopFunction()
        Stream<Integer> first = Stream.of(1, 2, 3);
        Stream<Integer> second = Stream.of(10, 20, 30, 40);

        Stream<Integer> zipped = ziped.zip(first, second);
        zipped.forEach(System.out::println);
    }
}
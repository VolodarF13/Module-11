
/*Завдання 5
Напишіть метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
який "перемішує" елементи зі стрімів first та second,
зупиняючись тоді, коли у одного зі стрімів закінчаться елементи.*/


import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class StreamZipped {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();

        Iterator<T> zippedIterator = new Iterator<T>() {
            private boolean toggle = true;

            @Override
            public boolean hasNext() {
                return iterator1.hasNext() && iterator2.hasNext();
            }

            @Override
            public T next() {
                if (toggle) {
                    toggle = false;
                    return iterator1.next();
                } else {
                    toggle = true;
                    return iterator2.next();
                }
            }

        };

        Iterable<T> iterable = () -> zippedIterator;
        return StreamSupport.stream(iterable.spliterator(), false);

    }
}

class TestStopFunction {
    public static void main(String[] args) {
        StreamZipped testStreamZipped = new StreamZipped();

        Stream<Integer> first = Stream.of(1, 2, 3);
        Stream<Integer> second = Stream.of(10, 20, 30, 40);

        Stream<Integer> zipped = testStreamZipped.zip(first, second);
        zipped.forEach(System.out::println); // Результат: 1, 10, 2, 20, 3, 30
    }
}
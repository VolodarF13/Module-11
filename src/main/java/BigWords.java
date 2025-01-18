/*Завдання 2
Метод приймає на вхід список рядків (можна взяти список із Завдання 1).
Повертає список цих рядків у верхньому регістрі, і відсортованих за спаданням (від Z до A).*/

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface FromSmallToBig{
    List<String> process(List<String> words);
}

class BigWords {

    private List<String> processFromSmallToBig (List<String> names, FromSmallToBig process){
        return process.process(names);
    }

    // Перетворити у верхній регістр.
    // відсортувати за спаданням
    public List<String> getBigLetter(List<String> words){
        return processFromSmallToBig(words, list ->
                list.stream()
                        .map(String::toUpperCase)
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList())

                );
    }


}


class testBigWords{
    public static void main(String[] args) {
        BigWords testBig = new BigWords();
        List<String> names = List.of("Ivan", "John", "Peter", "Anna", "Kate", "Zik", "Rohan");

        List<String> result = testBig.getBigLetter(names);
        System.out.println(result);

    }
}

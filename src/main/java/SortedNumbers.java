import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/*Завдання 3
Є масив:
["1, 2, 0", "4, 5"]

Необхідно отримати з масиву всі числа, і вивести їх у відсортованому вигляді через кому "," наприклад:
"0, 1, 2, 4, 5"
*/

@FunctionalInterface
interface Sort{
    String sortNumbers(List<String> list);
}


class SortedNumbers {

    private String processSortNumbers(List<String> list, Sort process){
        return process.sortNumbers(list);
    }


    public String sortNumber(List<String> numbers){
            return processSortNumbers(numbers, list ->
                    list.stream()
                            .flatMap(s -> Arrays.stream(s.split(",\\s*")))
                            .map(Integer::parseInt)
                            .sorted()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", "))
                    );

    }


}


class TestSortedNumbers{
    public static void main(String[] args) {
        SortedNumbers testSortedNumbers = new SortedNumbers();
        List<String> numbers = List.of("1, 2, 0", "4, 5","6, 10,     3");

        System.out.println(testSortedNumbers.sortNumber(numbers));

    }
}
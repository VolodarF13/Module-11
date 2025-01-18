
/*Завдання 1
Метод приймає на вхід список імен. Необхідно повернути рядок вигляду 1. Ivan, 3. Peter...
лише з тими іменами, що стоять під непарним індексом (1, 3 тощо)*/

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
interface Process{
    String process(List<String> names);
}


class OddNames {
    private String processOddIndexNames (List<String> names, Process process){
        return process.process(names);
    }

    public String getOddIndexNames(List<String> names) {
        return processOddIndexNames(names, list ->
                IntStream.range(0, list.size())
                        .filter(i -> i % 2 != 1)
                        .mapToObj(i -> (i + 1) + ". " + list.get(i))
                        .collect(Collectors.joining(", "))
        );
    }


}


class testOddNames{
    public static void main(String[] args) {
        OddNames testNames = new OddNames();
        List<String> names = List.of("Ivan", "John", "Peter", "Anna", "Kate");

        String result = testNames.getOddIndexNames(names);
        System.out.println(result);

    }
}

package intervirew;

import intervirew.basic_questions.User;
import intervirew.basic_questions.UserRecordStyle;

import java.util.Comparator;
import java.util.List;

public class MainInterview {
    static void main() {
        List<Integer> numbers = List.of(5, 2, 8, 1, 10);
        List<Integer> result = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(result);
    }
}

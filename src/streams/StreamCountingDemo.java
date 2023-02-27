package streams;

import functional.utils.StudentUtils;

import static java.util.stream.Collectors.counting;

public class StreamCountingDemo {

    public static void main(String[] args) {

        Long aLong = StudentUtils.getStudentList().stream()
                .collect(counting());
        System.out.println(aLong);

        Long aLong2 = StudentUtils.getStudentList().stream()
                .filter(s -> s.getCgpa() > 8)
                .collect(counting());
        System.out.println(aLong2);
    }
}

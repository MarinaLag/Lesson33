package lesson_33._03_stream_creating;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<Object> empty = Stream.empty(); // пустой стрим

        List<Integer> ints = Arrays.asList(1, 2, 3);

        Stream<Integer> stream = ints.stream();

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        Stream<Map.Entry<Integer, String>> stream1 = map.entrySet().stream();
        Stream<String> stream2 = Arrays.stream(new String[]{"a", "b"});
        Stream<Integer> integerStream = Stream.of(1, 2, 3);


    }
}

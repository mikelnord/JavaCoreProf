import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


class Practice6Test {
    private Practice6 practice6;

    @BeforeEach
    public void init() {
        practice6 = new Practice6();
    }

    public static Stream<Arguments> dataFornewMas() {
        List<Arguments> out = new ArrayList<>();
        int[] mas = {1, 2, 3, 5, 6, 7, 7, 8, 4, 1, 2};
        int[] result = {1, 2};
        out.add(Arguments.arguments(mas, result));
        mas = new int[]{1, 2, 3, 5, 6, 7, 7, 8, 5, 1, 4};
        result = new int[]{};
        out.add(Arguments.arguments(mas, result));
        mas = new int[]{1, 2, 3, 4, 6, 7, 4, 8, 5, 1, 2};
        result = new int[]{8, 5, 1, 2};
        out.add(Arguments.arguments(mas, result));
        mas = new int[]{1, 2, 4, 5, 6, 7, 7, 8, 5, 1, 5};
        result = new int[]{5, 6, 7, 7, 8, 5, 1, 5};
        out.add(Arguments.arguments(mas, result));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataFornewMas")
    public void testnewMas(int[] mas, int[] result) {
        Assertions.assertArrayEquals(result, practice6.newMas(mas));
    }

    @Test
    void findMasException() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            practice6.newMas(new int[]{1, 2, 3, 5, 6, 7, 7, 8, 9, 1, 2});
        });
    }

    public static Stream<Arguments> dataForfindMas() {
        List<Arguments> out = new ArrayList<>();
        int[] mas = {1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1};
        boolean result = true;
        out.add(Arguments.arguments(mas, result));
        mas = new int[]{1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 3};
        result = false;
        out.add(Arguments.arguments(mas, result));
        mas = new int[]{1, 2, 3, 4, 6, 7, 4, 8, 5, 1, 2};
        result = false;
        out.add(Arguments.arguments(mas, result));
        mas = new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        result = false;
        out.add(Arguments.arguments(mas, result));
        mas = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        result = false;
        out.add(Arguments.arguments(mas, result));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForfindMas")
    public void testfindMas(int[] mas, boolean result) {
        Assertions.assertEquals(result, practice6.findMas(mas));
    }

}

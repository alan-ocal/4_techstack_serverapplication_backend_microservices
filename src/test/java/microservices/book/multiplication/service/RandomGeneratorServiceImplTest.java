package microservices.book.multiplication.service;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Unit Test
 */
public class RandomGeneratorServiceImplTest {

    private RandomGeneratorServiceImpl randomGeneratorServiceImpl;

    @BeforeEach
    public void setUp() {
        randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
    }
    @Test
    public void generateRandomFactorIsBetweenExpectedLimits_() throws Exception {

        // when a good sample of randomly generated factors is generated
        // initialize a Stream of integers with ``IntStream``
        List<Integer> randomFactors = IntStream.range(0, 1000)
                .map(i -> randomGeneratorServiceImpl.generateRandomFactor())
                .boxed()
                .collect(Collectors.toList());

        //then all of them should be between 11 and 100
        // containsOnly is the alternative
        assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11, 100)
                .boxed()
                .collect(Collectors.toList()));

    }
}

package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;
//Junit
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//Mockito
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.BDDMockito.given;
//Assertj
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit Test
 */
public class MultiplicationServiceImplTest {

    private MultiplicationServiceImpl multiplicationServiceImpl;

    @Mock
    private RandomGeneratorService randomGeneratorService;

    // This method runs before each test case.
    // It’s great for resetting conditions before every test.
    @BeforeEach
    public void setUp() {
        // With this call to openMocks, I tell Mockito to initialize the annotations
        // MockitoAnnotations.openMocks in JUnit 6
        MockitoAnnotations.openMocks(this);
        multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
    }

    @Test
    public void createRandomMultiplicationTest(){
        //given (my mocked Random Generator Service will return first 50, then 30)
        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        //when
        Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();

        //assert
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
        assertThat(multiplication.getResult()).isEqualTo(1500);
    }
}

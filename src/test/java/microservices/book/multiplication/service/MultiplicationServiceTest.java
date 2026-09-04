package microservices.book.multiplication.service;

//Junit
import microservices.book.multiplication.domain.Multiplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

//Mockito
import static org.mockito.BDDMockito.given;

//Assertj
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Sample IntegrationTest
 */

@SpringBootTest
public class MultiplicationServiceTest {

    @MockitoBean
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    private MultiplicationService multiplicationService;

    @Test
    public void createRandomMultiplicationTest(){
        //given (my mocked Random Generator Service will return first 50, then 30)
        given(randomGeneratorService.generateRandomFactor()).willReturn(50,30);

        //when
        Multiplication multiplication = multiplicationService.createRandomMultiplication();

        //assert
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
        assertThat(multiplication.getResult()).isEqualTo(1500);
    }
}

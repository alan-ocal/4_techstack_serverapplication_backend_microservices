package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;

public interface MultiplicationService {

    /**
     * creates a multiplication object with two randomly-generated numbers
     * between 11 and 99
     *
     * @return a Multiplication object with random factors
     */
	Multiplication createRandomMultiplication();
}

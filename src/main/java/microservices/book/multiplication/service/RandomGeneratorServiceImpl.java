package microservices.book.multiplication.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomGeneratorServiceImpl implements RandomGeneratorService {

    final static int MINIMUM_FACTOR = 11;
    final static int MAXIMUM_FACTOR = 99;

    @Override
    public int generateRandomFactor() {
        //Random method of the Random class returns a value in a range from MINIMUM_FACTOR (inclusive) to MAXIMUM_FACTOR(exclusive).
      return new Random().nextInt(MAXIMUM_FACTOR - MINIMUM_FACTOR + 1) + MINIMUM_FACTOR;

    }
}

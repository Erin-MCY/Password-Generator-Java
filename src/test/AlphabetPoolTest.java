package test;

import main.AlphabetPool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlphabetPoolTest {
    private AlphabetPool alphabetPool;

    @Test
    void testConstructor() {
        alphabetPool = new AlphabetPool(true, true, true, true);
        String expected = AlphabetPool.UPPER_LETTERS + AlphabetPool.LOWER_LETTERS + AlphabetPool.NUMBERS
                + AlphabetPool.SPECIAL_CHARACTERS;
        assertEquals(expected, alphabetPool.get_pool());
    }
}

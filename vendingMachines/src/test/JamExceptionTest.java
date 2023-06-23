package test;

import exceptions.JamException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JamExceptionTest {

    @BeforeEach
    void setUp() {
        JamException jamException = new JamException(1,4);
    }

    @Test
    void setDate() {
        JamException jamException = new JamException(1,4);
        assertFalse(jamException.equals(2));
    }
}
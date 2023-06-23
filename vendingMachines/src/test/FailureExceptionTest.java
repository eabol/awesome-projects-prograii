package test;

import exceptions.FailureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureExceptionTest {

    @BeforeEach
    void setUp() {
        FailureException failureException = new FailureException(1);
    }

    @Test
    void setDate() {
        FailureException failureException = new FailureException(1);
        assertFalse(failureException.equals(2));
    }
}
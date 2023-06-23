package test;

import exceptions.FailureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class IncidenceTest {

    @BeforeEach
    void setUp() {
        FailureException failuretest = new FailureException(1);
    }

    @Test
    void setDate() {
        FailureException failuretest = new FailureException(1);
        LocalDate expected = LocalDate.now();
        failuretest.setDate();
        assertEquals(expected, failuretest.getDate());
    }
}
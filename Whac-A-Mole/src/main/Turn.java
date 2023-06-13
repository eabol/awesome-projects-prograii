package main;

public class Turn {
    private int total;
    private int successes;
    private int failures;

    public Turn() {
        total = 0;
        successes = 0;
        failures = 0;
    }

    public int getTotal() {
        return total;
    }

    public int getSuccesses() {
        return successes;
    }

    public int getFailures() {
        return failures;
    }

    public void playDone(boolean success) {
        total++;
        if (success) {
            successes++;
        } else {
            failures++;
        }
    }
}

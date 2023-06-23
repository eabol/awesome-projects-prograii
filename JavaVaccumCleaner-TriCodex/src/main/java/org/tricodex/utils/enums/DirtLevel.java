package org.tricodex.utils.enums;

public enum DirtLevel {
    CLEAN,
    DIRTY,
    VERY_DIRTY,
    FILTHY;

    public DirtLevel next() {
        return switch (this) {
            case CLEAN -> DIRTY;
            case DIRTY -> VERY_DIRTY;
            case VERY_DIRTY, FILTHY -> FILTHY;
        };
    }

    public DirtLevel previous() {
        return switch (this) {
            case CLEAN, DIRTY -> CLEAN;
            case VERY_DIRTY -> DIRTY;
            case FILTHY -> VERY_DIRTY;
        };
    }
}

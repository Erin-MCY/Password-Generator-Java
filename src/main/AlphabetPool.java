package main;

// Represent a pool of alphabets that a password could have based on the user's requirements
public class AlphabetPool {
    public static final String UPPER_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+\\/~?";

    private final StringBuilder pool;

    // EFFECT: constructs a pool with the alphabets that the user wants
    public AlphabetPool(boolean wantUpper, boolean wantLower, boolean wantNumber, boolean wantSpecial) {
        pool = new StringBuilder();
        if (wantUpper)
            pool.append(UPPER_LETTERS);
        if (wantLower)
            pool.append(LOWER_LETTERS);
        if(wantNumber)
            pool.append(NUMBERS);
        if(wantSpecial)
            pool.append(SPECIAL_CHARACTERS);
    }

    // EFFECT: returns the pool as a String
    public String get_pool() {
        return pool.toString();
    }
}

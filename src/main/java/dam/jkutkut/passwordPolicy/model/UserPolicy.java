package dam.jkutkut.passwordPolicy.model;

import java.util.function.Predicate;

public class UserPolicy extends PasswordPolicy{
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    private static final Predicate<String> FT_NN = (s) -> s != null;
    private static final Predicate<String> FT_MIN_L = (s) -> s.length() >= MIN_LENGTH;
    private static final Predicate<String> FT_MAX_L = (s) -> s.length() <= MAX_LENGTH;

    public UserPolicy() {
        super();
        addDefaultTests();
    }

    private void addDefaultTests() {
        addTest(FT_NN, "User cannot be null");
        addTest(FT_MIN_L, "Username must be at least " + MIN_LENGTH + " characters");
        addTest(FT_MAX_L, "Username must be at most " + MAX_LENGTH + " characters");

        addContainsAtLeast(LOWER_LETTERS, "User must contain at least " + MIN_LENGTH + " letter");
    }
}

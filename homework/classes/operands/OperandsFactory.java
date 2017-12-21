package homework.classes.operands;

import homework.interfaces.operands.IOperand;
import homework.interfaces.operands.IOperandsFactory;

/**
 *
 * This class contains a factory for the operands' nature (roman or arab) and
 * methods to convert from one to the other one.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class OperandsFactory implements IOperandsFactory<Double> {
    private static final int ARAB_1000 = 1000;
    private static final int ARAB_900 = 900;
    private static final int ARAB_500 = 500;
    private static final int ARAB_400 = 400;
    private static final int ARAB_100 = 100;
    private static final int ARAB_90 = 90;
    private static final int ARAB_50 = 50;
    private static final int ARAB_40 = 40;
    private static final int ARAB_10 = 10;
    private static final int ARAB_9 = 9;
    private static final int ARAB_5 = 5;
    private static final int ARAB_4 = 4;
    private static final int ARAB_1 = 1;

    private static OperandsFactory instance = null;

    private OperandsFactory() {
    }

    public static OperandsFactory getInstance() {
        if (instance == null) {
            instance = new OperandsFactory();
        }

        return instance;
    }

    @Override
    public IOperand<Double> createOperand(final String token) {
        if (isRomanValue(token)) {
            return new ArabNumber(token); // we need the arab number of token,
                                          // because we already have the roman
                                          // value
        }

        if (isArabValue(token)) {
            return new RomanNumber(token); // we need the roman value of token,
                                           // because we already have the arab
                                           // number
        }

        return null;
    }

    @Override
    public IOperand<Double> convertToRomanNumber(final Double arabNumber) {
        int arabNumberInt = (int) (Math.floor(arabNumber));
        String romanNumber = "";
        String[] romanNumeral = {"M", "CM", "D", "CD", "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I" };
        int[] arabNumeral = {ARAB_1000, ARAB_900, ARAB_500, ARAB_400, ARAB_100,
                ARAB_90, ARAB_50, ARAB_40, ARAB_10, ARAB_9, ARAB_5, ARAB_4,
                ARAB_1};

        if (arabNumberInt < 0) {
            romanNumber = "- ";
            arabNumberInt *= (-1);
        }

        for (int i = 0; i < arabNumeral.length; i++) {
            while (arabNumberInt >= arabNumeral[i]) {
                romanNumber = romanNumber + romanNumeral[i];
                arabNumberInt = arabNumberInt - arabNumeral[i];
            }
        }

        return new Operand(arabNumber, romanNumber);
    }

    @Override
    public IOperand<Double> convertToArabNumber(final String romanNumber) {
        String romanNumberCopy = romanNumber;
        int arabNumberInt = 0;
        String[] romanNumeral = {"M", "CM", "D", "CD", "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I" };
        int[] arabNumeral = {ARAB_1000, ARAB_900, ARAB_500, ARAB_400, ARAB_100,
                ARAB_90, ARAB_50, ARAB_40, ARAB_10, ARAB_9, ARAB_5, ARAB_4,
                ARAB_1};
        String romanNumberPrefix = "";
        boolean negative = false;

        if (romanNumberCopy.startsWith("-")) {
            negative = true;
            romanNumberCopy = romanNumberCopy.substring(2);
        }

        while (romanNumberCopy.length() != 0) {
            int i = -1; // we assume that everytime we analyze just the
                        // first symbol

            if (romanNumberCopy.length() > 1) {
                // if there are 2 or more symbols we check the first two symbols
                romanNumberPrefix = "" + romanNumberCopy.charAt(0)
                        + romanNumberCopy.charAt(1);
                i = indexOfEquality(romanNumberPrefix, romanNumeral);
            }

            if (i < 0) {
                // length 1 or the first two symbols where not a known value
                romanNumberPrefix = "" + romanNumberCopy.charAt(0);
                i = indexOfEquality(romanNumberPrefix, romanNumeral);
            }

            arabNumberInt += arabNumeral[i];
            romanNumberCopy =
                    romanNumberCopy.substring(romanNumberPrefix.length());
        }

        if (negative) {
            arabNumberInt *= (-1);
        }

        return new Operand(Double.valueOf(arabNumberInt), romanNumber);
    }

    /**
     *
     * This method compares a given roman number to a string array of known arab
     * values.
     *
     * @param romanNumberPrefix
     *            Given roman number
     * @param romanNumeral
     *            Known roman values
     * @return Index of equality in the string array of known roman values
     */
    private int indexOfEquality(final String romanNumberPrefix,
            final String[] romanNumeral) {
        for (int i = 0; i < romanNumeral.length; i++) {
            if (romanNumberPrefix.equals(romanNumeral[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     *
     * This method checks if a token is a roman value.
     *
     * @param token
     *            Token to be verified
     * @return True if it is a roman value, false otherwise
     */
    private boolean isRomanValue(final String token) {
        if (token.contains("M") || token.contains("D") || token.contains("C")
                || token.contains("L") || token.contains("X")
                || token.contains("V") || token.contains("I")) {
            return true;
        }

        return false;
    }

    /**
     *
     * This method checks if a token is an arab value.
     *
     * @param token
     *            Token to be verified
     * @return True if it is an arab value, false otherwise
     */
    private boolean isArabValue(final String token) {
        if (token.contains("9") || token.contains("8") || token.contains("7")
                || token.contains("6") || token.contains("5")
                || token.contains("4") || token.contains("3")
                || token.contains("2") || token.contains("1")
                || token.contains("0")) {
            return true;
        }

        return false;
    }

}

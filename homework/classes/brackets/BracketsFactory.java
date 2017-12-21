package homework.classes.brackets;

import homework.classes.brackets.closedBrackets.ClosedCurlyBrackets;
import homework.classes.brackets.closedBrackets.ClosedRoundBrackets;
import homework.classes.brackets.closedBrackets.ClosedSquareBrackets;
import homework.classes.brackets.openedBrackets.OpenedCurlyBrackets;
import homework.classes.brackets.openedBrackets.OpenedRoundBrackets;
import homework.classes.brackets.openedBrackets.OpenedSquareBrackets;
import homework.interfaces.IToken;
import homework.interfaces.brackets.IBracket;
import homework.interfaces.brackets.IBracketsFactory;

/**
 *
 * This class contains a factory for the bracket type we use and methods for
 * identification.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class BracketsFactory implements IBracketsFactory {
    private static BracketsFactory instance = null;

    private BracketsFactory() {
    }

    public static BracketsFactory getInstance() {
        if (instance == null) {
            instance = new BracketsFactory();
        }

        return instance;
    }

    @Override
    public IBracket createBracket(final String token) {
        switch (token) {
        case "(":
            return new OpenedRoundBrackets();
        case ")":
            return new ClosedRoundBrackets();
        case "[":
            return new OpenedSquareBrackets();
        case "]":
            return new ClosedSquareBrackets();
        case "{":
            return new OpenedCurlyBrackets();
        case "}":
            return new ClosedCurlyBrackets();
        default:
            return null;
        }
    }

    @Override
    public boolean isBracket(final IToken token) {
        String tokenSymbol = token.getSymbol();

        if (tokenSymbol.equals(")") || tokenSymbol.equals("(")
                || tokenSymbol.equals("]") || tokenSymbol.equals("[")
                || tokenSymbol.equals("}") || tokenSymbol.equals("{")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isOpenedBracket(final IBracket bracket) {
        String bracketSymbol = bracket.getSymbol();

        if (bracketSymbol.equals("(") || bracketSymbol.equals("[")
                || bracketSymbol.equals("{")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isClosedBracket(final IBracket bracket) {
        String bracketSymbol = bracket.getSymbol();

        if (bracketSymbol.equals(")") || bracketSymbol.equals("]")
                || bracketSymbol.equals("}")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isBracketPair(final IBracket openBracket,
            final IBracket closeBracket) {
        String openBracketSymbol = openBracket.getSymbol();
        String closeBracketSymbol = closeBracket.getSymbol();

        if (openBracketSymbol.equals("(") && closeBracketSymbol.equals(")")) {
            return true;
        }

        if (openBracketSymbol.equals("[") && closeBracketSymbol.equals("]")) {
            return true;
        }

        if (openBracketSymbol.equals("{") && closeBracketSymbol.equals("}")) {
            return true;
        }

        return false;
    }

}

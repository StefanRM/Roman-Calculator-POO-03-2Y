package homework.classes.brackets.openedBrackets;

import homework.interfaces.brackets.IBracket;

/**
 *
 * This class represents an opened square bracket.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class OpenedSquareBrackets implements IBracket {
    private String bracketSymbol;

    public OpenedSquareBrackets() {
        setSymbol("[");
    }

    @Override
    public String getSymbol() {
        return bracketSymbol;
    }

    @Override
    public void setSymbol(final String symbol) {
        this.bracketSymbol = symbol;
    }
}

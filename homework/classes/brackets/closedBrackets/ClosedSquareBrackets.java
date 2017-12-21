package homework.classes.brackets.closedBrackets;

import homework.interfaces.brackets.IBracket;

/**
 *
 * This class represents a closed square bracket.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class ClosedSquareBrackets implements IBracket {
    private String bracketSymbol;

    public ClosedSquareBrackets() {
        setSymbol("]");
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

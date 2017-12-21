package homework.classes.brackets.closedBrackets;

import homework.interfaces.brackets.IBracket;

/**
 *
 * This class represents a closed curly bracket.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class ClosedCurlyBrackets implements IBracket {
    private String bracketSymbol;

    public ClosedCurlyBrackets() {
        setSymbol("}");
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

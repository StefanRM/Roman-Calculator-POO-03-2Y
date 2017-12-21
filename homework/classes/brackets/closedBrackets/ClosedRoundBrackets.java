package homework.classes.brackets.closedBrackets;

import homework.interfaces.brackets.IBracket;

/**
 *
 * This class represents a closed round bracket.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class ClosedRoundBrackets implements IBracket {
    private String bracketSymbol;

    public ClosedRoundBrackets() {
        setSymbol(")");
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

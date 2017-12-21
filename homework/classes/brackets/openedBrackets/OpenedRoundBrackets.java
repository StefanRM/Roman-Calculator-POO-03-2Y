package homework.classes.brackets.openedBrackets;

import homework.interfaces.brackets.IBracket;

/**
 *
 * This class represents an opened round bracket.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class OpenedRoundBrackets implements IBracket {
    private String bracketSymbol;

    public OpenedRoundBrackets() {
        setSymbol("(");
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

package homework.classes.brackets.openedBrackets;

import homework.interfaces.brackets.IBracket;

/**
 *
 * This class represents an opened curly bracket.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class OpenedCurlyBrackets implements IBracket {
    private String bracketSymbol;

    public OpenedCurlyBrackets() {
        setSymbol("{");
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

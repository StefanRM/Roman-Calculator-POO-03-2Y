package homework.classes.operands;

/**
 *
 * This class represents a roman number, having also the arab value.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class RomanNumber extends Operand {

    public RomanNumber(final String token) {
        setSymbolValue(OperandsFactory.getInstance()
                .convertToRomanNumber(Double.valueOf(token)).getSymbolValue());
        setSymbol(OperandsFactory.getInstance()
                .convertToRomanNumber(Double.valueOf(token)).getSymbol());
    }
}

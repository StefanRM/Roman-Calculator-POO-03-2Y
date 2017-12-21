package homework.classes.operands;

/**
 *
 * This class represents an arab number, having also the roman symbol value.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class ArabNumber extends Operand {

    public ArabNumber(final String token) {
        setSymbolValue(OperandsFactory.getInstance().convertToArabNumber(token)
                .getSymbolValue());
        setSymbol(OperandsFactory.getInstance().convertToArabNumber(token)
                .getSymbol());
    }

}

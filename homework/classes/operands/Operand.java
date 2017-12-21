package homework.classes.operands;

import homework.interfaces.operands.IOperand;

/**
 *
 * This class represents a general operand, having both arab value and roman
 * symbol set.
 *
 * @author Maftei Stefan - Radu
 *
 */
public class Operand implements IOperand<Double> {
    private Double arabValue;
    private String romanSymbol;

    public Operand() {
        this(null, null);
    }

    public Operand(final Double value, final String symbol) {
        setSymbolValue(value);
        setSymbol(symbol);
    }

    @Override
    public final String getSymbol() {
        return romanSymbol;
    }

    @Override
    public final void setSymbol(final String symbol) {
        this.romanSymbol = symbol;
    }

    @Override
    public final Double getSymbolValue() {
        return arabValue;
    }

    @Override
    public final void setSymbolValue(final Double value) {
        this.arabValue = value;
    }
}

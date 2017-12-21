package homework.classes.operators.binaryOperators;

import homework.classes.operands.OperandsFactory;
import homework.interfaces.operands.IOperand;

/**
 *
 * This class represents a plus operator.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class PlusOperator extends BinaryOperator {
    private static final int PLUS_PRIORITY = 0;
    private String plusSymbol;

    public PlusOperator() {
        setSymbol("+");
    }

    @Override
    public int getPriority() {
        return PLUS_PRIORITY;
    }

    @Override
    public String getSymbol() {
        return plusSymbol;
    }

    @Override
    public void setSymbol(final String symbol) {
        this.plusSymbol = symbol;
    }

    @Override
    public IOperand<Double> calculate(final Double leftOperand,
            final Double rightOperand) {
        Double result = leftOperand + rightOperand;

        return OperandsFactory.getInstance().createOperand(result.toString());
    }

}

package homework.classes.operators.binaryOperators;

import homework.classes.operands.OperandsFactory;
import homework.interfaces.operands.IOperand;

/**
 *
 * This class represents a minus operator.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class MinusOperator extends BinaryOperator {
    private static final int MINUS_PRIORITY = 0;
    private String minusSymbol;

    public MinusOperator() {
        setSymbol("-");
    }

    @Override
    public int getPriority() {
        return MINUS_PRIORITY;
    }

    @Override
    public String getSymbol() {
        return minusSymbol;
    }

    @Override
    public void setSymbol(final String symbol) {
        this.minusSymbol = symbol;
    }

    @Override
    public IOperand<Double> calculate(final Double leftOperand,
            final Double rightOperand) {
        Double result = leftOperand - rightOperand;

        return OperandsFactory.getInstance().createOperand(result.toString());
    }

}

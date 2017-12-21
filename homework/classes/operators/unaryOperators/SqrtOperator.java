package homework.classes.operators.unaryOperators;

import homework.classes.operands.OperandsFactory;
import homework.interfaces.operands.IOperand;

/**
 *
 * This class represents a square root operator.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class SqrtOperator extends UnaryOperator {
    private static final int SQRT_PRIORITY = 3;
    private String sqrtSymbol;

    public SqrtOperator() {
        setSymbol("sqrt");
    }

    @Override
    public int getPriority() {
        return SQRT_PRIORITY;
    }

    @Override
    public String getSymbol() {
        return sqrtSymbol;
    }

    @Override
    public void setSymbol(final String symbol) {
        this.sqrtSymbol = symbol;
    }

    @Override
    public IOperand<Double> calculate(final Double operand) {
        Double result = Math.sqrt(operand);

        return OperandsFactory.getInstance().createOperand(result.toString());
    }

}

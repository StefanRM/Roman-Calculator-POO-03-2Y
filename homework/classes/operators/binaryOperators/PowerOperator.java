package homework.classes.operators.binaryOperators;

import homework.classes.operands.OperandsFactory;
import homework.interfaces.operands.IOperand;

/**
 *
 * This class represents a power operator.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class PowerOperator extends BinaryOperator {
    private static final int POWER_PRIORITY = 2;
    private String powerSymbol;

    public PowerOperator() {
        setSymbol("^");
    }

    @Override
    public int getPriority() {
        return POWER_PRIORITY;
    }

    @Override
    public String getSymbol() {
        return powerSymbol;
    }

    @Override
    public void setSymbol(final String symbol) {
        this.powerSymbol = symbol;
    }

    @Override
    public IOperand<Double> calculate(final Double leftOperand,
            final Double rightOperand) {
        Double result = Math.pow(leftOperand, rightOperand);

        return OperandsFactory.getInstance().createOperand(result.toString());
    }
}

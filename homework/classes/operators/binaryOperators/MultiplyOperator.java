package homework.classes.operators.binaryOperators;

import homework.classes.operands.OperandsFactory;
import homework.interfaces.operands.IOperand;

/**
 *
 * This class represents a multiply operator.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class MultiplyOperator extends BinaryOperator {
    private static final int MULTIPLY_PRIORITY = 1;
    private String multiplySymbol;

    public MultiplyOperator() {
        setSymbol("*");
    }

    @Override
    public int getPriority() {
        return MULTIPLY_PRIORITY;
    }

    @Override
    public String getSymbol() {
        return multiplySymbol;
    }

    @Override
    public void setSymbol(final String symbol) {
        this.multiplySymbol = symbol;
    }

    @Override
    public IOperand<Double> calculate(final Double leftOperand,
            final Double rightOperand) {
        Double result = leftOperand * rightOperand;

        return OperandsFactory.getInstance().createOperand(result.toString());
    }

}

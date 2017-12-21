package homework.classes.operators.binaryOperators;

import homework.classes.operands.OperandsFactory;
import homework.interfaces.operands.IOperand;

/**
 *
 * This class represents a divide operator.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class DivideOperator extends BinaryOperator {
    private static final int DIVIDE_PRIORITY = 1;
    private String divideSymbol;

    public DivideOperator() {
        setSymbol("/");
    }

    @Override
    public int getPriority() {
        return DIVIDE_PRIORITY;
    }

    @Override
    public String getSymbol() {
        return divideSymbol;
    }

    @Override
    public void setSymbol(final String symbol) {
        this.divideSymbol = symbol;
    }

    @Override
    public IOperand<Double> calculate(final Double leftOperand,
            final Double rightOperand) {
        Double result = leftOperand / rightOperand;

        return OperandsFactory.getInstance().createOperand(result.toString());
    }
}

package homework.classes.operators.unaryOperators;

import homework.classes.operands.OperandsFactory;
import homework.interfaces.operands.IOperand;

/**
 *
 * This class represents a logarithm operator.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class LogOperator extends UnaryOperator {
    private static final int LOG_PRIORITY = 3;
    private String logSymbol;

    public LogOperator() {
        setSymbol("log");
    }

    @Override
    public int getPriority() {
        return LOG_PRIORITY;
    }

    @Override
    public String getSymbol() {
        return logSymbol;
    }

    @Override
    public void setSymbol(final String symbol) {
        this.logSymbol = symbol;
    }

    @Override
    public IOperand<Double> calculate(final Double operand) {
        Double result = Math.log(operand);

        return OperandsFactory.getInstance().createOperand(result.toString());
    }

}

package homework.classes.operators;

import homework.classes.operators.binaryOperators.DivideOperator;
import homework.classes.operators.binaryOperators.MinusOperator;
import homework.classes.operators.binaryOperators.MultiplyOperator;
import homework.classes.operators.binaryOperators.PlusOperator;
import homework.classes.operators.binaryOperators.PowerOperator;
import homework.classes.operators.unaryOperators.LogOperator;
import homework.classes.operators.unaryOperators.SqrtOperator;
import homework.interfaces.IToken;
import homework.interfaces.operators.IOperator;
import homework.interfaces.operators.IOperatorsFactory;

/**
 *
 * This class contains a factory for the operator type we use and methods for
 * identification.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class OperatorsFactory implements IOperatorsFactory {
    private static OperatorsFactory instance = null;

    private OperatorsFactory() {
    }

    public static OperatorsFactory getInstance() {
        if (instance == null) {
            instance = new OperatorsFactory();
        }

        return instance;
    }

    @Override
    public IOperator createOperator(final String token) {
        switch (token) {
        case "+":
            return new PlusOperator();
        case "-":
            return new MinusOperator();
        case "*":
            return new MultiplyOperator();
        case "/":
            return new DivideOperator();
        case "^":
            return new PowerOperator();
        case "sqrt":
            return new SqrtOperator();
        case "log":
            return new LogOperator();
        default:
            return null;
        }
    }

    @Override
    public boolean isOperator(final IToken token) {
        String tokenSymbol = token.getSymbol();

        if (tokenSymbol.equals("+") || tokenSymbol.equals("-")
                || tokenSymbol.equals("*") || tokenSymbol.equals("/")
                || tokenSymbol.equals("^") || tokenSymbol.equals("sqrt")
                || tokenSymbol.equals("log")) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isUnaryOperator(final IOperator operator) {
        String operatorSymbol = operator.getSymbol();

        if (operatorSymbol.equals("sqrt") || operatorSymbol.equals("log")) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isBinaryOperator(final IOperator operator) {
        String operatorSymbol = operator.getSymbol();

        if (operatorSymbol.equals("+") || operatorSymbol.equals("-")
                || operatorSymbol.equals("*") || operatorSymbol.equals("/")
                || operatorSymbol.equals("^")) {
            return true;
        }

        return false;
    }

    /**
     *
     * This method checks if a given operator is a division operator.
     *
     * @param operator
     *            Given operator
     * @return True if it is a division operator, false otherwise
     */
    public boolean isDivisionOperator(final IOperator operator) {
        String operatorSymbol = operator.getSymbol();

        if (operatorSymbol.equals("/")) {
            return true;
        }

        return false;
    }

}

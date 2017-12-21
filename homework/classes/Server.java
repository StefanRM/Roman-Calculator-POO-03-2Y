package homework.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import homework.classes.brackets.BracketsFactory;
import homework.classes.operands.Operand;
import homework.classes.operands.OperandsFactory;
import homework.classes.operators.OperatorsFactory;
import homework.classes.operators.binaryOperators.BinaryOperator;
import homework.classes.operators.unaryOperators.UnaryOperator;
import homework.interfaces.IServer;
import homework.interfaces.IToken;
import homework.interfaces.brackets.IBracket;
import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.IOperator;

/**
 *
 * This class solves every equation it receives.
 *
 * @author Maftei Stefan - Radu
 *
 */
public final class Server implements IServer {
    private List<String> results; // all results of equations
    private List<String> supportedOperations; // supported operations
    private List<IToken> commandTokens; // every token in current equation
    private Stack<IToken> postfixedFormHelper; // stack for post fixed form
    private static Server instance = null;

    private Server() {
        results = new ArrayList<String>();
        supportedOperations = new ArrayList<String>();
    }

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }

        return instance;
    }

    /**
     *
     * This method creates commandTokens for current equation. It verifies each
     * String token received, then it creates and add the certain object to the
     * commandTokens.
     *
     * @param tokens
     *            Tokens from current equation
     */
    private void buildCommandTokens(final String[] tokens) {
        commandTokens = new ArrayList<IToken>();
        BracketsFactory bracketsFactory = BracketsFactory.getInstance();
        OperandsFactory operandsFactory = OperandsFactory.getInstance();
        OperatorsFactory operatorsFactory = OperatorsFactory.getInstance();
        IToken tokenToAdd;

        for (String token : tokens) {
            tokenToAdd = bracketsFactory.createBracket(token);
            if (tokenToAdd == null) {
                tokenToAdd = operatorsFactory.createOperator(token);
                if (tokenToAdd == null) {
                    tokenToAdd = operandsFactory.createOperand(token);
                }
            }

            commandTokens.add(tokenToAdd);
        }
    }

    @Override
    public boolean canPublish(final String[] tokens) {
        buildCommandTokens(tokens);

        for (IToken token : commandTokens) {
            if (OperatorsFactory.getInstance().isOperator(token)) {
                if (!supportedOperations.contains(token.getSymbol())) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void publish(final String command) {
        // tokens in every equation are separated by one whitespace
        String[] tokens = command.split(" ");

        if (!canPublish(tokens)) {
            results.add("IMPOSSIBRU");
            return;
        }

        results.add(evaluatePostfixedForm(convertToPostfixForm()));

    }

    @Override
    public void subscribe(final String operator) {
        supportedOperations.add(operator);
    }

    @Override
    public List<String> getResults() {
        return results;
    }

    /**
     *
     * This method converts an infix form equation to a post fixed form
     * equation.
     *
     * @return A list of tokens in post fixed form
     */
    private List<IToken> convertToPostfixForm() {
        List<IToken> postfixedForm = new ArrayList<IToken>();
        BracketsFactory bracketsFactory = BracketsFactory.getInstance();
        OperatorsFactory operatorsFactory = OperatorsFactory.getInstance();
        postfixedFormHelper = new Stack<IToken>();

        for (IToken token : commandTokens) {
            if (bracketsFactory.isBracket(token)) {
                IBracket bracket = (IBracket) token;
                if (bracketsFactory.isOpenedBracket(bracket)) {
                    postfixedFormHelper.push(bracket);
                }

                if (bracketsFactory.isClosedBracket(bracket)) {
                    IToken stackToken = postfixedFormHelper.pop();
                    while (!bracketsFactory.isBracket(stackToken)
                            || !bracketsFactory.isBracketPair(
                                    (IBracket) stackToken, bracket)) {
                        postfixedForm.add(stackToken);
                        stackToken = postfixedFormHelper.pop();
                    }
                }
                continue;
            }

            if (operatorsFactory.isOperator(token)) {
                IOperator operator = (IOperator) token;

                if (!postfixedFormHelper.isEmpty()) {
                    IToken stackToken = postfixedFormHelper.peek();
                    while (operatorsFactory.isOperator(stackToken)) {
                        stackToken = postfixedFormHelper.pop();
                        if (((IOperator) stackToken).getPriority() >= operator
                                .getPriority()) {
                            postfixedForm.add(stackToken);
                        } else {
                            postfixedFormHelper.push(stackToken);
                            break;
                        }

                        if (!postfixedFormHelper.isEmpty()) {
                            stackToken = postfixedFormHelper.peek();
                        } else {
                            break;
                        }
                    }
                }

                postfixedFormHelper.push(operator);
                continue;
            }

            postfixedForm.add(token);
        }

        while (!postfixedFormHelper.isEmpty()) {
            IToken stackToken = postfixedFormHelper.pop();
            postfixedForm.add(stackToken);
        }

        return postfixedForm;
    }

    /**
     *
     * This method evaluates a post fixed form.
     *
     * @param postfixedForm
     *            A list of tokens in post fixed form
     * @return Result of evaluation the post fixed form as roman number
     */
    private String evaluatePostfixedForm(final List<IToken> postfixedForm) {
        postfixedFormHelper = new Stack<IToken>();
        OperatorsFactory operatorsFactory = OperatorsFactory.getInstance();

        for (IToken token : postfixedForm) {
            if (operatorsFactory.isOperator(token)) {
                IOperator operator = (IOperator) token;

                if (operatorsFactory.isUnaryOperator(operator)) {
                    UnaryOperator unaryOperator = (UnaryOperator) operator;
                    IToken stackToken = postfixedFormHelper.pop();
                    Double operand = ((Operand) stackToken).getSymbolValue();
                    IOperand<Double> result = unaryOperator.calculate(operand);
                    postfixedFormHelper.push(result);
                }

                if (operatorsFactory.isBinaryOperator(operator)) {
                    BinaryOperator binaryOperator = (BinaryOperator) operator;
                    IToken stackToken2 = postfixedFormHelper.pop();
                    IToken stackToken1 = postfixedFormHelper.pop();
                    Double operandLeft =
                            ((Operand) stackToken1).getSymbolValue();
                    Double operandRight =
                            ((Operand) stackToken2).getSymbolValue();

                    // Division by zero verification
                    if (operatorsFactory.isDivisionOperator(operator)) {
                        if (operandRight == 0) {
                            return "IMPOSSIBRU";
                        }
                    }

                    IOperand<Double> result =
                            binaryOperator.calculate(operandLeft, operandRight);
                    postfixedFormHelper.push(result);
                }

                continue;
            }

            postfixedFormHelper.push(token);
        }

        IToken stackToken = postfixedFormHelper.pop();
        Operand result = (Operand) stackToken;

        return result.getSymbol();
    }

}

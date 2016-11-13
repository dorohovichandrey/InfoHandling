package by.dorohovich.infohandling.calculator.parser;

import by.dorohovich.infohandling.calculator.expression.*;

/**
 * Created by User on 12.11.2016.
 */
public enum Operation {
    OPEN_BRACKET(-1), CLOSE_BRACKET(-1), PLUS(0), MINUS(0), MULTIPLY(1), DIVIDE(1), INCREMENT(2), DECREMENT(2), UNARY_MINUS(3);

    private int priority;

    Operation(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public static Operation getOperation(String str)
    {
        switch (str)
        {
            case "+": return PLUS;
            case "-": return MINUS;
            case "*": return MULTIPLY;
            case "/": return DIVIDE;
            case "i": return INCREMENT;
            case "d": return DECREMENT;
            case "m": return UNARY_MINUS;
            case "(": return OPEN_BRACKET;
            case ")": return CLOSE_BRACKET;
            default: return null;
        }
    }

    public AbstractExpression getExpression()
    {
        switch (this)
        {
            case PLUS: return new TerminalExpressionPlus();
            case MINUS: return new TerminalExpressionMinus();
            case MULTIPLY: return new TerminalExpressionMultiply();
            case DIVIDE: return new TerminalExpressionDivide();
            case INCREMENT: return new TerminalExpressionIncrement();
            case DECREMENT: return new TerminalExpressionDecrement();
            case UNARY_MINUS: return new TerminalExpressionUnaryMinus();
            default: return null;
        }
    }
}

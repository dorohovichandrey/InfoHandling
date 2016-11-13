package by.dorohovich.infohandling.calculator.expression;

import by.dorohovich.infohandling.calculator.client.Context;

/**
 * Created by User on 12.11.2016.
 */
public class NonTerminalExpressionNumber extends AbstractExpression {
    int number;

    public NonTerminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}

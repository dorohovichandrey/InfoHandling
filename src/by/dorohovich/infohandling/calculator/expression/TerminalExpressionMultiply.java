package by.dorohovich.infohandling.calculator.expression;

import by.dorohovich.infohandling.calculator.client.Context;

/**
 * Created by User on 12.11.2016.
 */
public class TerminalExpressionMultiply extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue()*context.popValue());
    }
}

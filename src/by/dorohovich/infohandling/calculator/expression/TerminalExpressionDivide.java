package by.dorohovich.infohandling.calculator.expression;

import by.dorohovich.infohandling.calculator.client.Context;

/**
 * Created by User on 12.11.2016.
 */
public class TerminalExpressionDivide extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        Integer secondOp=context.popValue();
        context.pushValue(context.popValue()/secondOp);
    }
}

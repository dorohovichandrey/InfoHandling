package by.dorohovich.infohandling.calculator.client;

import by.dorohovich.infohandling.calculator.expression.AbstractExpression;
import by.dorohovich.infohandling.calculator.parser.MathExParser;

import java.util.List;

/**
 * Created by User on 10.11.2016.
 */
public class Calculator {

    public int calculate(String expr)
    {
        Context context=new Context();
        MathExParser mathExParser=new MathExParser();
        List<AbstractExpression> expressionList=mathExParser.parseIntoPolishNotation(expr);
        for(AbstractExpression expression : expressionList)
        {
            expression.interpret(context);
        }
        return context.popValue();
    }

}

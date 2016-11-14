package by.dorohovich.infohandling.calculator.parser;

import by.dorohovich.infohandling.calculator.expression.AbstractExpression;
import by.dorohovich.infohandling.calculator.expression.NonTerminalExpressionNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by User on 10.11.2016.
 */
public class MathExParser {

    private final static String DELIMITERS="+-id*/()";
    private final static String REGEX_FOR_INC="\\+\\+";
    private final static String REGEX_FOR_DEC="--";
    private final static String SYMBOL_FOR_INC="i";
    private final static String SYMBOL_FOR_DEC="d";

    private OperationStack operationStack;
    private List<AbstractExpression> expressionList;
    private boolean isPrevNumberOrCloseBracket = false;


    public List<AbstractExpression> parseIntoPolishNotation(String mathExpr)
    {
        operationStack=new OperationStack();
        expressionList=new ArrayList<AbstractExpression>();
        mathExpr=replaceUnaryOperators(mathExpr);
        StringTokenizer st=new StringTokenizer(mathExpr,DELIMITERS, true);
        while (st.hasMoreTokens())
        {
            handleToken(st.nextToken());
        }
        expressionList.addAll(operationStack.flush());
        return expressionList;

    }

    private String replaceUnaryOperators(String mathExpr)
    {
        mathExpr=mathExpr.replaceAll(REGEX_FOR_INC, SYMBOL_FOR_INC);
        mathExpr=mathExpr.replaceAll(REGEX_FOR_DEC, SYMBOL_FOR_DEC);
        return mathExpr;
    }

    private void handleToken(String token)
    {
        Operation operation = Operation.getOperation(token);
        if(operation == null)
        {
            isPrevNumberOrCloseBracket=true;
            int number=Integer.valueOf(token);
            expressionList.add(new NonTerminalExpressionNumber(number));
        }
        else
        {
            operation=prepareOperation(operation);
            if(operation!=null)
            {
                List<AbstractExpression> res=operationStack.add(operation);
                if(res!=null)
                {
                    expressionList.addAll(res);
                }
            }
        }
    }

    private Operation prepareOperation(Operation operation)
    {
        switch (operation)
        {
            case MINUS:{
                if(detectUnaryMinus())
                {
                    operation=Operation.UNARY_MINUS;
                }
                return operation;
            }
            case INCREMENT:
            case DECREMENT: {
                if(detectPostfix())
                {
                    operation=null;
                }
                return operation;
            }
            case CLOSE_BRACKET:{
                isPrevNumberOrCloseBracket=true;
            }
            default:
                isPrevNumberOrCloseBracket=false;
                return operation;
        }
    }


    private boolean detectUnaryMinus()
    {
        if (!isPrevNumberOrCloseBracket) {
            isPrevNumberOrCloseBracket = false;
            return true;
        }
        return false;
    }

    private boolean detectPostfix()
    {
        if(isPrevNumberOrCloseBracket)
        {
            isPrevNumberOrCloseBracket=true;
            return true;

        }
        return false;
    }

}
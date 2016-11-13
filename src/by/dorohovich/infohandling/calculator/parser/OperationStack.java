package by.dorohovich.infohandling.calculator.parser;

import by.dorohovich.infohandling.calculator.expression.AbstractExpression;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 13.11.2016.
 */
public class OperationStack {
    private ArrayDeque<Operation> stack = new ArrayDeque<Operation>();

    public List<AbstractExpression> add(Operation operation) {
        List<AbstractExpression> result;
        if (!isBracket(operation)) {
            result = addOperator(operation);
        } else {
            result = addBracket(operation);
        }

        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    private boolean isBracket(Operation operation) {
        return operation.getPriority() < 0;
    }

    private List<AbstractExpression> addOperator(Operation operation) {
        List<AbstractExpression> result = new ArrayList<AbstractExpression>();
        while (!stack.isEmpty() && operation.getPriority() <= stack.peek().getPriority()) {
            result.add(stack.pop().getExpression());
        }
        stack.push(operation);
        return result;
    }

    private List<AbstractExpression> addBracket(Operation operation) {
        List<AbstractExpression> result = new ArrayList<AbstractExpression>();
        if (operation == Operation.CLOSE_BRACKET) {
            while (stack.peek() != Operation.OPEN_BRACKET) {
                result.add(stack.pop().getExpression());
            }
            stack.pop();
        } else {
            stack.push(operation);
        }
        return result;
    }

    public List<AbstractExpression> flush()
    {
        List<AbstractExpression> res=new ArrayList<AbstractExpression>();
        while(!stack.isEmpty()) {
            res.add(stack.pop().getExpression());
        }
        return res;
    }

}

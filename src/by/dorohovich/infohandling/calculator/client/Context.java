package by.dorohovich.infohandling.calculator.client;

import java.util.ArrayDeque;

/**
 * Created by User on 12.11.2016.
 */
public class Context {

    private ArrayDeque<Integer> contextValues = new ArrayDeque<Integer>();

    public Integer popValue() {
        return contextValues.pop();
    }

    public void pushValue(Integer value) {
        contextValues.push(value);
    }
}

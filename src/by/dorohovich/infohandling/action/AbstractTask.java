package by.dorohovich.infohandling.action;

import by.dorohovich.infohandling.entity.CompositeTextElement;
import by.dorohovich.infohandling.entity.CompositeTextElementType;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 13.11.2016.
 */
public abstract class AbstractTask {

    private List<CompositeTextElement> result=new ArrayList<CompositeTextElement>();

    public abstract CompositeTextElementType getEndOfRecursion();

    public abstract void recursionWork(CompositeTextElement compositeTextElement);

    public abstract void gatheringWork();

    public abstract void printResult(PrintWriter out);

    protected List<CompositeTextElement> getResult() {
        return result;
    }
}

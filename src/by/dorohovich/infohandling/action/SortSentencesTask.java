package by.dorohovich.infohandling.action;

import by.dorohovich.infohandling.entity.CompositeTextElement;
import by.dorohovich.infohandling.entity.CompositeTextElementType;

import java.io.PrintWriter;

/**
 * Created by User on 13.11.2016.
 */
public class SortSentencesTask extends AbstractTask {

    @Override
    public CompositeTextElementType getEndOfRecursion() {
        return CompositeTextElementType.SENTENCE;
    }

    @Override
    public void recursionWork(CompositeTextElement compositeTextElement) {
        getResult().add(compositeTextElement);
    }

    @Override
    public void gatheringWork() {
        getResult().sort((a,b)->Integer.valueOf(a.getChildren().size()).compareTo(b.getChildren().size()));
    }

    @Override
    public void printResult(PrintWriter out) {
        out.println("<-----------------------Sort sentences by number of lexemes----------------------->");
        for(CompositeTextElement element : getResult())
        {
            out.println(element);
        }
        out.println("<--------------------------------------------------------------------------------->");
    }
}

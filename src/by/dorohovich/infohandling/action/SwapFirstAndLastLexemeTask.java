package by.dorohovich.infohandling.action;

import by.dorohovich.infohandling.entity.CompositeTextElement;
import by.dorohovich.infohandling.entity.CompositeTextElementType;
import by.dorohovich.infohandling.entity.TextElement;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 13.11.2016.
 */
public class SwapFirstAndLastLexemeTask extends AbstractTask{
    @Override
    public CompositeTextElementType getEndOfRecursion() {
        return CompositeTextElementType.SENTENCE;
    }

    @Override
    public void recursionWork(CompositeTextElement compositeTextElement) {
        List<TextElement> list=compositeTextElement.getChildren();
        Collections.swap(list, 0, list.size()-1);
        getResult().add(compositeTextElement);
    }

    @Override
    public void gatheringWork() {
    }

    @Override
    public void printResult(PrintWriter out) {
        out.println("<-----------------------Swap first and last lexeme in sentence----------------------->");
        for(CompositeTextElement element : getResult())
        {
            out.println(element);
        }
        out.println("<------------------------------------------------------------------------------------->");
    }
}

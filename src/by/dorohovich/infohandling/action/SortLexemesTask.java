package by.dorohovich.infohandling.action;

import by.dorohovich.infohandling.entity.CompositeTextElement;
import by.dorohovich.infohandling.entity.CompositeTextElementType;

import java.io.PrintWriter;

/**
 * Created by User on 13.11.2016.
 */
public class SortLexemesTask extends AbstractTask{
    @Override
    public CompositeTextElementType getEndOfRecursion() {
        return CompositeTextElementType.LEXEME;
    }

    @Override
    public void recursionWork(CompositeTextElement compositeTextElement) {
        getResult().add(compositeTextElement);
    }

    @Override
    public void gatheringWork() {
        getResult().sort((a,b)->a.toString().compareTo(b.toString()));
    }

    @Override
    public void printResult(PrintWriter out) {
        out.println("<--------------------------Sort lexemes------------------------>");
        Character prevChar=null;
        for(CompositeTextElement element : getResult())
        {
            if(prevChar!=null&&!prevChar.equals(element.toString().charAt(0))) {
                out.println();
            }
            prevChar=element.toString().charAt(0);
            out.print(element+" ");
        }
        out.println();
        out.println("<-------------------------------------------------------------->");
    }
}

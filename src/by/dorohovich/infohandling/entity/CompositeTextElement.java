package by.dorohovich.infohandling.entity;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 02.11.2016.
 */
public class CompositeTextElement extends TextElement {

    private CompositeTextElementType type;
    private List<TextElement> children=new ArrayList<TextElement>();


    public CompositeTextElement(CompositeTextElementType type) {
        this.type = type;
    }

    public CompositeTextElementType getType() {
        return type;
    }

    @Override
    public void addTextElement(TextElement textElement) {
        children.add(textElement);
    }

    @Override
    public List<TextElement> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        String result=null;
        StringBuilder stringBuilder=new StringBuilder();
        recursiveAppend(stringBuilder);
        result=stringBuilder.toString();
        return result;
    }

    protected void recursiveAppend(StringBuilder stringBuilder)
    {
        for(TextElement textElement : children)
        {
            textElement.recursiveAppend(stringBuilder);
        }
        setLayout(stringBuilder);
    }

    private void setLayout(StringBuilder stringBuilder)
    {
        if(getType()==CompositeTextElementType.LEXEME)
        {
            stringBuilder.append(' ');
        }
        else if(getType()==CompositeTextElementType.PARAGRAPH)
        {
            stringBuilder.append('\n');
        }
    }

}

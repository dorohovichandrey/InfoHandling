package by.dorohovich.infohandling.entity;

import by.dorohovich.infohandling.exception.LeafNotSupportsOperationException;

import java.util.List;

/**
 * Created by User on 02.11.2016.
 */
public class Symbol extends TextElement {

    private char value;

    public Symbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public void addTextElement(TextElement textElement) throws LeafNotSupportsOperationException {
        throw new LeafNotSupportsOperationException();
    }


    @Override
    public List<TextElement> getChildren() throws LeafNotSupportsOperationException {
        throw new LeafNotSupportsOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    protected void recursiveAppend(StringBuilder stringBuilder)
    {
        stringBuilder.append(value);
    }
}

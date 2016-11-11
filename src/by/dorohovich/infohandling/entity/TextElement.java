package by.dorohovich.infohandling.entity;

import by.dorohovich.infohandling.exception.LeafNotSupportsOperationException;

import java.util.List;

/**
 * Created by User on 02.11.2016.
 */
public abstract class TextElement {

    public abstract void addTextElement(TextElement textElement) throws LeafNotSupportsOperationException;
    public abstract List<TextElement> getChildren() throws LeafNotSupportsOperationException;
    protected abstract void recursiveAppend(StringBuilder stringBuilder);

}

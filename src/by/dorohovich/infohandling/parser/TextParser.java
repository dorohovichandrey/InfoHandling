package by.dorohovich.infohandling.parser;

import by.dorohovich.infohandling.entity.CompositeTextElement;
import by.dorohovich.infohandling.entity.CompositeTextElementType;
import by.dorohovich.infohandling.entity.TextElement;

import javax.xml.soap.Text;

/**
 * Created by User on 02.11.2016.
 */
public class TextParser implements CompositeTextElementParser {

    final static String TEXT_PARSING_REGEX="(\t)|(\\s{2})";
    private ParagraphParser paragraphParser=new ParagraphParser();


    @Override
    public CompositeTextElement parseCompositeTextElement(String text) {
        CompositeTextElement compositeTextElement=new CompositeTextElement(CompositeTextElementType.TEXT);
        CompositeTextElement paragraphElement;
        text=text.trim();
        String[] paragraphs=text.split(TEXT_PARSING_REGEX);
        for(String paragraph : paragraphs)
        {
            paragraphElement = paragraphParser.parseCompositeTextElement(paragraph);
            compositeTextElement.addTextElement(paragraphElement);
        }
        return compositeTextElement;
    }
}

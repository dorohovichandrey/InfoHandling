package by.dorohovich.infohandling.parser;

import by.dorohovich.infohandling.entity.CompositeTextElement;
import by.dorohovich.infohandling.entity.CompositeTextElementType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 02.11.2016.
 */
public class ParagraphParser implements CompositeTextElementParser {

    final static String REGEX_FOR_SENTENCE ="[A-Z].*[\\.?!]";
    private SentenceParser sentenceParser=new SentenceParser();

    @Override
    public CompositeTextElement parseCompositeTextElement(String paragraph) {
        CompositeTextElement paragraphElement=new CompositeTextElement(CompositeTextElementType.PARAGRAPH);
        CompositeTextElement sentenceElement;
        Pattern pattern=Pattern.compile(REGEX_FOR_SENTENCE);
        Matcher matcher=pattern.matcher(paragraph);
        String sentence;
        while (matcher.find())
        {
            sentence=matcher.group();
            sentenceElement=sentenceParser.parseCompositeTextElement(sentence);
            paragraphElement.addTextElement(sentenceElement);

        }
        return paragraphElement;
    }
}

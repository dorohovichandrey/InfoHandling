package by.dorohovich.infohandling.parser;

import by.dorohovich.infohandling.entity.CompositeTextElement;
import by.dorohovich.infohandling.entity.CompositeTextElementType;
import by.dorohovich.infohandling.entity.TextElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 03.11.2016.
 */
public class SentenceParser implements CompositeTextElementParser {

    final static String SENTENCE_PARSING_REGEX="[ ]";
    private LexemeParser lexemeParser=new LexemeParser();

    @Override
    public CompositeTextElement parseCompositeTextElement(String sentence) {
        CompositeTextElement sentenceElement=new CompositeTextElement(CompositeTextElementType.SENTENCE);
        CompositeTextElement lexemeElement;
        String[] lexemes=sentence.split(SENTENCE_PARSING_REGEX);
        for(String lexeme : lexemes)
        {
            lexemeElement=lexemeParser.parseCompositeTextElement(lexeme);
            sentenceElement.addTextElement(lexemeElement);

        }
        return sentenceElement;

    }
}

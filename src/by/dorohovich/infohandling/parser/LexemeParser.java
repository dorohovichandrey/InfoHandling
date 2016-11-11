package by.dorohovich.infohandling.parser;

import by.dorohovich.infohandling.entity.CompositeTextElement;
import by.dorohovich.infohandling.entity.CompositeTextElementType;
import by.dorohovich.infohandling.entity.Symbol;
import by.dorohovich.infohandling.entity.TextElement;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by User on 03.11.2016.
 */
public class LexemeParser implements CompositeTextElementParser {

    final static String DELIMITERS="?!.;:'\"";
    final static String REGEX_FOR_PUNCTUATION_MARK="["+DELIMITERS+"]";
    private WordAndMathExParser wordAndMathExParser=new WordAndMathExParser();

    @Override
    public CompositeTextElement parseCompositeTextElement(String lexeme) {
        CompositeTextElement lexemeElement=new CompositeTextElement(CompositeTextElementType.LEXEME);
        TextElement lexemePart;
        StringTokenizer stringTokenizer=new StringTokenizer(lexeme,DELIMITERS, true);
        Pattern pattern=Pattern.compile(REGEX_FOR_PUNCTUATION_MARK);
        while (stringTokenizer.hasMoreTokens())
        {
            String token=stringTokenizer.nextToken();
            Matcher matcher=pattern.matcher(token);
            if(matcher.matches())
            {
                lexemePart=new Symbol(token.charAt(0));
            }
            else
            {
                lexemePart=wordAndMathExParser.parseCompositeTextElement(token);
            }
            lexemeElement.addTextElement(lexemePart);
        }
        return lexemeElement;
    }

}

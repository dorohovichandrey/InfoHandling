package by.dorohovich.infohandling.parser;

import by.dorohovich.infohandling.calculator.client.Calculator;
import by.dorohovich.infohandling.entity.CompositeTextElement;
import by.dorohovich.infohandling.entity.CompositeTextElementType;
import by.dorohovich.infohandling.entity.Symbol;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 03.11.2016.
 */
public class WordAndMathExParser implements CompositeTextElementParser {

    final static String REGEX_FOR_MATH_EX = "[^A-z,]+";
    private Calculator calculator=new Calculator();

    @Override
    public CompositeTextElement parseCompositeTextElement(String lexemeMainPart) {
        Pattern pattern = Pattern.compile(REGEX_FOR_MATH_EX);
        Matcher matcher = pattern.matcher(lexemeMainPart);
        CompositeTextElementType type = matcher.matches() ? CompositeTextElementType.MATH_EXPRESSION : CompositeTextElementType.WORD;
        CompositeTextElement lexemeMainPartElement = new CompositeTextElement(type);
        if((lexemeMainPartElement).getType()==CompositeTextElementType.MATH_EXPRESSION)
        {
            calculator=new Calculator();
            Integer res=calculator.calculate(lexemeMainPart);
            lexemeMainPart=res.toString();
        }
        Symbol symbol;
        for (int i = 0; i < lexemeMainPart.length() ; i++) {
            symbol=new Symbol(lexemeMainPart.charAt(i));
            lexemeMainPartElement.addTextElement(symbol);
        }
        return lexemeMainPartElement;
    }
}

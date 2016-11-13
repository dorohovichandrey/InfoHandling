package by.dorohovich.infohandling.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by User on 10.11.2016.
 */
public class TextReader {

    private final static String DELIMITER_FOR_LINES=" ";
    private static final Logger LOG= LogManager.getLogger();
    private BufferedReader reader;

    public TextReader(String fileIn) {
        try
        {
            reader=new BufferedReader(new FileReader(fileIn));
        }
        catch (FileNotFoundException e)
        {
            LOG.fatal(e);
            throw new RuntimeException(e);
        }
    }

    public String readText()
    {
        String text = null;
        StringBuilder stringBuilder = new StringBuilder();
        List<String> stringList=reader.lines().collect(Collectors.toList());
        for(String str : stringList)
        {
            stringBuilder.append(str);
            stringBuilder.append(DELIMITER_FOR_LINES);
        }
        text=stringBuilder.toString();
        return text;
    }
}

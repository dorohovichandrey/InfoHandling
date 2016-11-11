package by.dorohovich.infohandling.runner;

import by.dorohovich.infohandling.entity.CompositeTextElement;
import by.dorohovich.infohandling.io.TextReader;
import by.dorohovich.infohandling.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by User on 03.11.2016.
 */
public class Runner {

    static final Logger LOG= LogManager.getLogger();
    static final String INPUT_FILE_NAME = "inptoutpt\\inp.txt";
    static final String OUTPUT_FILE_NAME = "inptoutpt\\outp.txt";

    public static void main(String[] args) {
        try
        {
            PrintWriter out = new PrintWriter(OUTPUT_FILE_NAME);
            TextReader textReader=new TextReader(INPUT_FILE_NAME);
            String text=textReader.readText();
            TextParser textParser=new TextParser();
            CompositeTextElement compositeTextElement=textParser.parseCompositeTextElement(text);
            out.println(compositeTextElement.toString());
            out.println(compositeTextElement.getChildren().size());
            out.flush();
            out.close();
        }
        catch (FileNotFoundException e)
        {
            LOG.fatal(e);
            throw new RuntimeException(e);
        }
    }

}

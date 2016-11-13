package by.dorohovich.infohandling.runner;

import by.dorohovich.infohandling.action.*;
import by.dorohovich.infohandling.entity.CompositeTextElement;
import by.dorohovich.infohandling.entity.CompositeTextElementType;
import by.dorohovich.infohandling.io.TextReader;
import by.dorohovich.infohandling.parser.TextParser;
import com.sun.deploy.security.ValidationState;
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
            CompositeTextElement textComposite=textParser.parseCompositeTextElement(text);
            out.println(textComposite);

            TaskManager taskManager=new TaskManager();

            SortSentencesTask sortSentencesTask=new SortSentencesTask();
            taskManager.solveTask(textComposite, sortSentencesTask);
            sortSentencesTask.printResult(out);

            SwapFirstAndLastLexemeTask swapFirstAndLastLexemeTask=new SwapFirstAndLastLexemeTask();
            taskManager.solveTask(textComposite,swapFirstAndLastLexemeTask);
            swapFirstAndLastLexemeTask.printResult(out);

            SortLexemesTask sortLexemesTask=new SortLexemesTask();
            taskManager.solveTask(textComposite, sortLexemesTask);
            sortLexemesTask.printResult(out);

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

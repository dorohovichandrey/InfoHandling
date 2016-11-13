package by.dorohovich.infohandling.action;

import by.dorohovich.infohandling.entity.CompositeTextElement;
import by.dorohovich.infohandling.entity.TextElement;
import by.dorohovich.infohandling.exception.LeafNotSupportsOperationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by User on 13.11.2016.
 */
public class TaskManager {

    static final Logger LOG= LogManager.getLogger();

    public void solveTask(CompositeTextElement composite, AbstractTask task)
    {
        recurse(composite, task);
        task.gatheringWork();
    }

    private void recurse(CompositeTextElement composite, AbstractTask task)
    {
        if(composite.getType()!=task.getEndOfRecursion())
        {
            for(TextElement child : composite.getChildren() )
            {
                recurse((CompositeTextElement)child, task);
            }
        }
        else
        {
            task.recursionWork(composite);
        }
    }


}

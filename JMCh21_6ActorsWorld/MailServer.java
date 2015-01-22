import java.util.*;


/**
 * Queues and dispatches messages. A MailServer is a queue of messages.
 * 
 * @author Jessica jiang
 * @version January 21st
 * @author Period - 4
 * @author Assignment - TODO Assignment Name
 * 
 * @author Sources - TODO list collaborators
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;


    // TODO complete class

    /**
     * Adds actor to the set of the registered subscribers
     * 
     * @param actor
     */
    public void signUp( Actor actor )
    {
        
    }


    /**
     * Either sends msg to the recipient indicated in msg (by calling the
     * recipient�s receive(msg)), or, if the recipient is null, to all
     * registered subscribers (except the sender).
     * 
     * @param msg
     */
    public void dispatch( Message msg )
    {

    }


    // for testing purposes only
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
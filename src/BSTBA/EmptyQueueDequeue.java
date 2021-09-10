package BSTBA;

public class EmptyQueueDequeue extends RuntimeException
{
    /**
     * Constructor uses no error message.
     */
    public EmptyQueueDequeue()
    {
        super();
    }

    /**
     * Constructor specifies an error message.
     * @param message The error message.
     */
    public EmptyQueueDequeue(String message)
    {
        super(message);
    }
}

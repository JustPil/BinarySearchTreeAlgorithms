package BSTBA;

public class EmptyStackPop extends RuntimeException
{
    /**
     * This constructor uses no error message.
     */
    public EmptyStackPop()
    {
        super();
    }

    /**
     * This constructor specifies an error message.
     * @param message The error message.
     */
    public EmptyStackPop(String message)
    {
        super(message);
    }
}

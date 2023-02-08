package com.velocitypackage.neuron.core.exception;

public class NeuronException extends Exception
{
    public NeuronException()
    {
        super();
    }

    public NeuronException(String message)
    {
        super(message);
    }

    public NeuronException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public NeuronException(Throwable cause)
    {
        super(cause);
    }
}

package com.velocitypackage.neuron.core.exception;

public class IncompatibleLayerException extends NeuronException
{
    public IncompatibleLayerException(int layer)
    {
        super(String.format("The layer %s and %s are not compatible with each other", layer-1, layer));
    }
}

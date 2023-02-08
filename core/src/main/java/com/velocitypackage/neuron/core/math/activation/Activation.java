package com.velocitypackage.neuron.core.math.activation;

/**
 * The interface for each activation function applied to each neuron of a {@link com.velocitypackage.neuron.core.layer.Layer}
 * @since 1.0
 */
public interface Activation
{
    /**
     * This uses the values of each neuron as input and puts them into the specific function and returns the calculated values
     * @param input The input values of each neuron
     * @return The neuron output values
     * @since 1.0
     */
    float[] activate(float[] input);

    /**
     * This uses the values of each neuron as input and puts them into the specific function and returns the calculated values
     * @param input The input values of each neuron
     * @return The neuron output values
     * @since 1.0
     */
    float[][] activate(float[][] input);

    /**
     * This uses the values of each neuron as input and puts them into the specific function and returns the calculated values
     * @param input The input values of each neuron
     * @return The neuron output values
     * @since 1.0
     */
    float[][][] activate(float[][][] input);

    /**
     * The inverse function for backpropagation
     * @param input The output values of each neuron
     * @return The neuron input values
     * @since 1.0
     */
    float[] activate_derivative(float[] input);

    /**
     * The inverse function for backpropagation
     * @param input The output values of each neuron
     * @return The neuron input values
     * @since 1.0
     */
    float[][] activate_derivative(float[][] input);

    /**
     * The inverse function for backpropagation
     * @param input The output values of each neuron
     * @return The neuron input values
     * @since 1.0
     */
    float[][][] activate_derivative(float[][][] input);

    enum Type
    {
        Identity,
        BinaryStep,
        Sigmoid,
        Tanh,
        ReLU,
        GELU,
        Softplus,
        ELU,
        SELU,
        LeakyReLU,
        PReLU,
        SiLU,
        Gaussian,
        Softmax,
        Maxout
    }
}

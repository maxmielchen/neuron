package com.velocitypackage.neuron.core.layer;

import com.velocitypackage.neuron.core.math.engine.Engine;

/**
 * The interface for each hidden and output layer of a neural network
 * @param <S> The output structure
 * @since 1.0
 */
public interface Layer<S> extends Cloneable
{
    void set_engine(Engine engine);

    /**
     * This initializes the size/number of layers in front that may be needed to set the weights
     * @param neuron_size The layer size/number of the layer before
     * @since 1.0
     */
    void input_neuron_size(int neuron_size);

    /**
     * This method checks if the input layer is compatible with this layer
     * @param layer The input layer
     * @return true for compatible and false for incompatible
     * @since 1.0
     */
    boolean input_compatible(Layer<?> layer);

    /**
     * This returns the output structure
     * @return The output structure as {@link Class}
     */
    Class<S> structure();

    /**
     * This returns the output neuron size/count needed for the next layer
     * @return The layer size/number
     * @since 1.0
     */
    int neuron_size();

    int x_size();

    int y_size();

    int z_size();

    void randomize();

    S dot_product(S input);

    S activate(S input);

    S activate_derivative(S input);




    Layer<S> clone();
}

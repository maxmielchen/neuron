package com.velocitypackage.neuron.core.input;

import com.velocitypackage.neuron.core.layer.Layer;
import com.velocitypackage.neuron.core.math.engine.Engine;

/**
 * The interface for each input layer of a neural network
 * @param <S> The output structure
 * @since 1.0
 */
public interface Input<S> extends Layer<S>
{

    @Override
    default void set_engine(Engine engine) {}

    @Override
    default void input_neuron_size(int neuron_size) {}

    @Override
    default boolean input_compatible(Layer<?> layer)
    {
        return false;
    }

    @Override
    default void randomize() {}

    @Override
    default S feed_forward(S input)
    {
        return input;
    }
}

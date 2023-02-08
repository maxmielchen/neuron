package com.velocitypackage.neuron.core;

import com.velocitypackage.neuron.core.exception.IncompatibleLayerException;
import com.velocitypackage.neuron.core.input.Input;
import com.velocitypackage.neuron.core.layer.Layer;
import com.velocitypackage.neuron.core.math.engine.Engine;

import java.util.Arrays;

public class Network
{
    Engine engine;

    Layer<?> input;
    Layer<?>[] layers;

    public Network(Engine engine, Input<?> input, Layer<?>... layers) throws IncompatibleLayerException
    {
        this.engine = engine;
        this.input = input.clone();
        this.layers = Arrays.stream(layers).map(Layer::clone).toArray(Layer[]::new);
        Layer<?> last_layer = input;
        for (int i = 0; i < this.layers.length; i++) {
            Layer<?> layer = this.layers[i];
            layer.input_neuron_size(last_layer.neuron_size());
            if (!layer.input_compatible(last_layer)) {
                throw new IncompatibleLayerException(i + 2);
            }
            last_layer = layer;
        }
    }

}

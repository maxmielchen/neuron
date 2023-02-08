package com.velocitypackage.neuron.core.input;

import com.velocitypackage.neuron.core.layer.Layer;

public class Input1D implements Input<float[]>
{
    int neuron_size;

    public Input1D(int neuron_size)
    {
        this.neuron_size = neuron_size;
    }

    @Override
    public Class<float[]> structure() {
        return float[].class;
    }

    @Override
    public int neuron_size() {
        return neuron_size;
    }

    @Override
    public int x_size() {
        return 1;
    }

    @Override
    public int y_size() {
        return neuron_size;
    }

    @Override
    public int z_size() {
        return 1;
    }

    @Override
    public Layer<float[]> clone() {
        try {
            return (Layer<float[]>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

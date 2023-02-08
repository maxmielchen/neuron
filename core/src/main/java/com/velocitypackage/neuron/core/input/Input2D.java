package com.velocitypackage.neuron.core.input;

import com.velocitypackage.neuron.core.layer.Layer;

public class Input2D implements Input<float[][]>
{
    int x, y;

    public Input2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public Class<float[][]> structure() {
        return float[][].class;
    }

    @Override
    public int neuron_size() {
        return x*y;
    }

    @Override
    public int x_size() {
        return x;
    }

    @Override
    public int y_size() {
        return y;
    }

    @Override
    public int z_size() {
        return 1;
    }

    @Override
    public Layer<float[][]> clone() {
        try {
            return (Layer<float[][]>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

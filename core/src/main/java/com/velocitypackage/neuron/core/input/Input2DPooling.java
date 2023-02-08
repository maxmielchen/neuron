package com.velocitypackage.neuron.core.input;

import com.velocitypackage.neuron.core.layer.Layer;
import com.velocitypackage.neuron.core.pooling.Pooling;

public class Input2DPooling implements Input<float[][]>, Pooling
{
    int x, y;
    Type poolingType;

    public Input2DPooling(int x, int y, Type poolingType)
    {
        this.x = x;
        this.y = y;
        this.poolingType = poolingType;
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

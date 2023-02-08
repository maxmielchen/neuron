package com.velocitypackage.neuron.core.input;

import com.velocitypackage.neuron.core.layer.Layer;
import com.velocitypackage.neuron.core.pooling.Pooling;

public class Input3DPooling implements Input<float[][][]>, Pooling
{
    int x, y, z;
    Type poolingType;

    public Input3DPooling(int x, int y, int z, Type poolingType)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.poolingType = poolingType;
    }

    @Override
    public Class<float[][][]> structure() {
        return float[][][].class;
    }

    @Override
    public int neuron_size() {
        return x*y*z;
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
        return z;
    }

    @Override
    public Layer<float[][][]> clone() {
        try {
            return (Layer<float[][][]>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

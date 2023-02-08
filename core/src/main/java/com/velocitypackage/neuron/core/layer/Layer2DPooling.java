package com.velocitypackage.neuron.core.layer;

import com.velocitypackage.neuron.core.math.activation.Activation;
import com.velocitypackage.neuron.core.math.engine.Engine;
import com.velocitypackage.neuron.core.pooling.Pooling;

public class Layer2DPooling implements Layer<float[][]>, Pooling
{
    Engine engine;
    int x, y;
    Type poolingType;
    Activation.Type activationType;

    public Layer2DPooling(int x, int y, Type poolingType, Activation.Type activationType)
    {
        this.x = x;
        this.y = y;
        this.poolingType = poolingType;
        this.activationType = activationType;
    }

    @Override
    public void set_engine(Engine engine)
    {
        this.engine = engine;
    }

    @Override
    public void input_neuron_size(int neuron_size) {}

    @Override
    public boolean input_compatible(Layer<?> layer) {
        if (layer.structure() == float[].class)
        {
            return false;
        }
        if (layer.structure() == float[][].class)
        {
            return layer.x_size() >= x && layer.y_size() >= y && layer.z_size() >= 1;
        }
        if (layer.structure() == float[][][].class)
        {
            return layer.x_size() >= x && layer.y_size() >= y && layer.z_size() >= 1;
        }
        return false;
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
    public void randomize() {}

    @Override
    public float[][] dot_product(float[][] input) {
        return null;
    }

    @Override
    public float[][] activate(float[][] input) {
        return new float[0][];
    }

    @Override
    public float[][] activate_derivative(float[][] input) {
        return new float[0][];
    }

    @Override
    public Layer<float[][]> clone() {
        try {
            Layer2DPooling clone = (Layer2DPooling) super.clone();
            clone.engine = this.engine;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

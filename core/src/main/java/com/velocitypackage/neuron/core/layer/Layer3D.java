package com.velocitypackage.neuron.core.layer;

import com.velocitypackage.neuron.core.math.activation.Activation;
import com.velocitypackage.neuron.core.math.engine.Engine;

public class Layer3D implements Layer<float[][][]>
{
    Engine engine;
    int x, y, z;
    float[][] kernel;
    Activation.Type activationType;

    public Layer3D(int x, int y, int z, int kernel_x, int kernel_y, Activation.Type activationType)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.kernel = new float[kernel_x][kernel_y];
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
    public boolean input_compatible(Layer<?> layer)
    {
        if (layer.structure() == float[].class)
        {
            return false;
        }
        if (layer.structure() == float[][].class && z == 1)
        {
            return layer.x_size() == x && layer.y_size() == y && layer.z_size() == z;
        }
        if (layer.structure() == float[][][].class)
        {
            return layer.x_size() == x && layer.y_size() == y && layer.z_size() == z;
        }
        return false;
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
    public void randomize()
    {
        engine.randomize(kernel);
    }

    @Override
    public float[][][] dot_product(float[][][] input)
    {
        return null;
    }

    @Override
    public float[][][] activate(float[][][] input)
    {
        return engine.getActivation(activationType).activate(input);
    }

    @Override
    public float[][][] activate_derivative(float[][][] input)
    {
        return engine.getActivation(activationType).activate_derivative(input);
    }

    @Override
    public Layer<float[][][]> clone() {
        try {
            Layer3D clone = (Layer3D) super.clone();
            clone.engine = this.engine;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

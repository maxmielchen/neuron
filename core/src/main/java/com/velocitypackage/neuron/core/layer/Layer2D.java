package com.velocitypackage.neuron.core.layer;

import com.velocitypackage.neuron.core.math.activation.Activation;
import com.velocitypackage.neuron.core.math.engine.Engine;

public class Layer2D implements Layer<float[][]>
{
    Engine engine;
    int x, y;
    float[][] kernel;
    Activation.Type activationType;

    public Layer2D(int x, int y, int kernel_x, int kernel_y, Activation.Type activationType)
    {
        this.x = x;
        this.y = y;
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
    public boolean input_compatible(Layer<?> layer) {
        if (layer.structure() == float[].class)
        {
            return false;
        }
        if (layer.structure() == float[][].class)
        {
            return layer.x_size() == x && layer.y_size() == y && layer.z_size() == 1;
        }
        if (layer.structure() == float[][][].class)
        {
            return layer.x_size() == x && layer.y_size() == y && layer.z_size() == 1;
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
    public void randomize() 
    {
        engine.randomize(kernel);
    }

    @Override
    public float[][] dot_product(float[][] input) {
        return engine.filter(input, kernel);
    }

    @Override
    public float[][] activate(float[][] input) {
        return engine.getActivation(activationType).activate(input);
    }

    @Override
    public float[][] activate_derivative(float[][] input) {
        return engine.getActivation(activationType).activate_derivative(input);
    }

    @Override
    public Layer<float[][]> clone() {
        try {
            Layer2D clone = (Layer2D) super.clone();
            clone.engine = this.engine;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

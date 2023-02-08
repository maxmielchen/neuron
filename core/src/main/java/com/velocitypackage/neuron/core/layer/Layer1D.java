package com.velocitypackage.neuron.core.layer;

import com.velocitypackage.neuron.core.math.activation.Activation;
import com.velocitypackage.neuron.core.math.engine.Engine;

public class Layer1D implements Layer<float[]>
{
    Engine engine;
    int input_neuron_size;
    int neuron_size;

    Activation.Type activationType;

    public Layer1D(int neuron_size, Activation.Type activationType)
    {
        this.neuron_size = neuron_size;
        this.activationType = activationType;
    }

    float[] bias;
    float[][] weight;

    @Override
    public void set_engine(Engine engine)
    {
        this.engine = engine;
    }

    @Override
    public void input_neuron_size(int input_neuron_size)
    {
        this.input_neuron_size = input_neuron_size;
        this.bias = new float[this.neuron_size];
        this.weight = new float[this.neuron_size][input_neuron_size];
    }

    @Override
    public boolean input_compatible(Layer<?> layer)
    {
        return true;
    }

    @Override
    public Class<float[]> structure() {
        return float[].class;
    }

    @Override
    public int neuron_size()
    {
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
    public void randomize()
    {
        engine.randomize(bias);
        engine.randomize(weight);
    }

    @Override
    public float[] dot_product(float[] input)
    {
        return engine.dot_product(weight, input, bias);
    }

    @Override
    public float[] activate(float[] input)
    {
        return engine.getActivation(activationType).activate(input);
    }

    @Override
    public float[] activate_derivative(float[] input)
    {
        return engine.getActivation(activationType).activate_derivative(input);
    }

    @Override
    public Layer<float[]> clone() {
        try {
            Layer1D clone = (Layer1D) super.clone();
            clone.engine = this.engine;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

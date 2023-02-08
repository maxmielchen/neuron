package com.velocitypackage.neuron.engine.activation;

import com.velocitypackage.neuron.core.math.activation.Activation;

public class Linear implements Activation
{
    @Override
    public float[] activate(float[] input) {
        return new float[0];
    }

    @Override
    public float[][] activate(float[][] input) {
        return new float[0][];
    }

    @Override
    public float[][][] activate(float[][][] input) {
        return input.clone();
    }

    @Override
    public float[] activate_derivative(float[] input) {
        return new float[0];
    }

    @Override
    public float[][] activate_derivative(float[][] input) {
        return new float[0][];
    }

    @Override
    public float[][][] activate_derivative(float[][][] input) {
        float[][][] output = new float[input.length][input[0].length][input[0][0].length];
        for (int x = 0; x < input.length; x++)
        {
            for (int y = 0; y < input[x].length; y++)
            {
                for (int z = 0; z < input[x][y].length; z++)
                {
                    output[x][y][z] = 1;
                }
            }
        }
        return output;
    }
}

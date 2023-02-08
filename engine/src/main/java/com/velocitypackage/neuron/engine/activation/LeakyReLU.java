package com.velocitypackage.neuron.engine.activation;

import com.velocitypackage.neuron.core.math.activation.Activation;

public class LeakyReLU implements Activation
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
        float[][][] output = new float[input.length][input[0].length][input[0][0].length];
        for (int x = 0; x < input.length; x++)
        {
            for (int y = 0; y < input[x].length; y++)
            {
                for (int z = 0; z < input[x][y].length; z++)
                {
                    output[x][y][z] = input[x][y][z] > 0 ? input[x][y][z] : (float) (0.01 * input[x][y][z]);
                }
            }
        }
        return output;
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
                    if (input[x][y][z] != 0)
                    {
                        output[x][y][z] = input[x][y][z] > 0 ? 1 : (float) 0.01;
                    }
                }
            }
        }
        return output;
    }
}

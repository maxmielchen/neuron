package com.velocitypackage.neuron.core.math.matrix;

public interface MultiplyAlgorithm
{
    float[][] multiply(float[][] input, float multiplier);

    float[][][] multiply(float[][][] input, float[] multiplier);
}

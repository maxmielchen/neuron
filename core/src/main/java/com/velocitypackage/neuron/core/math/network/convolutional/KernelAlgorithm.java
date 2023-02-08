package com.velocitypackage.neuron.core.math.network.convolutional;

public interface KernelAlgorithm
{
    float[][] filter(float[][] input, float[][] kernel);

    float[][][] filter(float[][][] input, float[][] kernel);
}

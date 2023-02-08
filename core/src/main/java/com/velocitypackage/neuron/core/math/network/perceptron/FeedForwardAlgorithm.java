package com.velocitypackage.neuron.core.math.network.perceptron;

public interface FeedForwardAlgorithm
{
    float[] dot_product(float[][] weights, float[] input, float[] bias);
}

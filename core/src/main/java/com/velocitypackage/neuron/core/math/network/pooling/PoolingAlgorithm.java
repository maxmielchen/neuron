package com.velocitypackage.neuron.core.math.network.pooling;

public interface PoolingAlgorithm
{
    float[][] min(float[][] input, int output_x, int output_y, int output_z);

    float[][] max(float[][] input, int output_x, int output_y, int output_z);

    float[][][] min(float[][][] input, int output_x, int output_y, int output_z);

    float[][][] max(float[][][] input, int output_x, int output_y, int output_z);
}

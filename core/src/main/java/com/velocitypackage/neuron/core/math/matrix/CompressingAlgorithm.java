package com.velocitypackage.neuron.core.math.matrix;

public interface CompressingAlgorithm
{
    float[] flatting(float[][] input);

    float[] flatting(float[][][] input);

    float[] snipping_1d(float[][] input);

    float[] snipping_1d(float[][][] input);

    float[][] snipping_2d(float[][] input);

    float[][] snipping_2d(float[][][] input);
}

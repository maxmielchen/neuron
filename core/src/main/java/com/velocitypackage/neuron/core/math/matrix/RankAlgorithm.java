package com.velocitypackage.neuron.core.math.matrix;

public interface RankAlgorithm
{
    float rank(float[] input);

    float rank(float[][] input);

    float[] rank(float[][][] input);
}

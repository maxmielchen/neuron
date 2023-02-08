package com.velocitypackage.neuron.bindtf.model;

import ai.djl.ndarray.types.Shape;
import ai.djl.nn.Activation;
import ai.djl.nn.Block;
import ai.djl.nn.Blocks;
import ai.djl.nn.SequentialBlock;
import ai.djl.nn.convolutional.Conv2d;
import ai.djl.nn.core.Linear;
import ai.djl.nn.pooling.Pool;

public class MnistModel
{
    public static Block mnist()
    {
        SequentialBlock seq = new SequentialBlock();

        //CNN 1
        seq.add(
                Conv2d.builder()
                        .optBias(false)
                        .optPadding(new Shape(2))
                        .setKernelShape(new Shape(5, 5))
                        .setFilters(6)
                        .build()
        );
        seq.add(Activation::sigmoid);

        //Pool
        seq.add(
                Pool.avgPool2dBlock(new Shape(2, 2), new Shape(2))
        );

        //CNN 1
        seq.add(
                Conv2d.builder()
                        .optBias(false)
                        .setKernelShape(new Shape(5, 5))
                        .setFilters(16)
                        .build()
        );
        seq.add(Activation::sigmoid);

        //Pool
        seq.add(
                Pool.avgPool2dBlock(new Shape(2, 2), new Shape(2))
        );

        //Flatten
        seq.add(Blocks.batchFlattenBlock());

        //Layer
        seq.add(Linear.builder().setUnits(120).build());
        seq.add(Activation::sigmoid);

        //Layer
        seq.add(Linear.builder().setUnits(84).build());
        seq.add(Activation::sigmoid);

        //Output
        seq.add(Linear.builder().setUnits(10).build());

        return seq;
    }
}

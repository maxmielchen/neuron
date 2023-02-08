package com.velocitypackage.neuron.core.math.engine;

import com.velocitypackage.neuron.core.math.activation.Activation;
import com.velocitypackage.neuron.core.math.matrix.*;
import com.velocitypackage.neuron.core.math.network.convolutional.KernelAlgorithm;
import com.velocitypackage.neuron.core.math.network.perceptron.BackpropagationAlgorithm;
import com.velocitypackage.neuron.core.math.network.perceptron.FeedForwardAlgorithm;
import com.velocitypackage.neuron.core.math.network.pooling.PoolingAlgorithm;

public interface Engine extends PoolingAlgorithm, BackpropagationAlgorithm, FeedForwardAlgorithm, KernelAlgorithm, AddAlgorithm, CompressingAlgorithm, DeterminantAlgorithm, InverseAlgorithm, MultiplyAlgorithm, RandomAlgorithm, RankAlgorithm, TransposeAlgorithm, TriangularAlgorithm
{
    Activation Identity();

    Activation BinaryStep();

    Activation Sigmoid();

    Activation Tanh();

    Activation ReLU();

    Activation GELU();

    Activation Softplus();

    Activation ELU();

    Activation SELU();

    Activation LeakyReLU();

    Activation PReLU();

    Activation SiLU();

    Activation Gaussian();

    default Activation getActivation(Activation.Type type)
    {
        switch (type)
        {
            case Identity: return Identity();
            case BinaryStep: return BinaryStep();
            case Sigmoid: return Sigmoid();
            case Tanh: return Tanh();
            case ReLU: return ReLU();
            case GELU: return GELU();
            case Softplus: return Softplus();
            case ELU: return ELU();
            case SELU: return SELU();
            case LeakyReLU: return LeakyReLU();
            case PReLU: return PReLU();
            case SiLU: return SiLU();
            case Gaussian: return Gaussian();
            default: return Identity();
        }
    }
}

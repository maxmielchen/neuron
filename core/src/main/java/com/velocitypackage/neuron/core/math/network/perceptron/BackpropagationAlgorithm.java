package com.velocitypackage.neuron.core.math.network.perceptron;

public interface BackpropagationAlgorithm
{
    /**
     * Neuron error: Calculate the error of a neuron using the following formula: δ = (target - output) * dpd, where target is the target, output is the neuron's actual output, and f'(z) is the derivative of the activation function.
     */
    float[] error_output_layer(float[] target, float[] output, float[] dot_product_derivative);

    /**
     * Neuron error: Calculate the error of a neuron with the following formula: δ = Σ (w * δ_next) * dpd where w are the weights to the next layer, δ_next is the error of the next layer and f'(z) the derivative of the activation function.
     */
    float[] error_hidden_layer(float[][] weights, float delta, float[] dot_product_derivative);

    /**
     * Total layer error: Calculate the total layer error by summing the error of each neuron: E = Σ δ.
     */
    float error_total(float[] delta);

    float[] error_bias(float learning_rate, float[] error_neurons);

    /**
     * Calculate the change in weights: Calculate the change in weights by applying the formula Δwi = -η * δ * xi, where η is the learning rate, δ is the neuron's error, and xi is the neuron's input.
     */
    float[] error_weights(float learning_rate, float[] error_neurons, float[] dot_product);

}

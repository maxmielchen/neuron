package com.velocitypackage.neuron.bindtf.model;

import ai.djl.modality.Classifications;
import ai.djl.modality.cv.util.NDImageUtils;
import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDList;
import ai.djl.translate.Batchifier;
import ai.djl.translate.Translator;
import ai.djl.translate.TranslatorContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Usage implements Translator<NDArray, Classifications>
{
    @Override
    public NDList processInput(TranslatorContext ctx, NDArray input) {
        return new NDList(NDImageUtils.toTensor(input));
    }

    @Override
    public Classifications processOutput(TranslatorContext ctx, NDList list) {
        NDArray probabilities = list.singletonOrThrow().softmax(0);
        List<String> classNames = IntStream.range(0, 10).mapToObj(String::valueOf).collect(Collectors.toList());
        return new Classifications(classNames, probabilities);
    }

    @Override
    public Batchifier getBatchifier() {
        return Batchifier.STACK;
    }
}

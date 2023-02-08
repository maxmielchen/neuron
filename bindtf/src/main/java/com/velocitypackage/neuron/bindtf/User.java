package com.velocitypackage.neuron.bindtf;

import ai.djl.MalformedModelException;
import ai.djl.Model;
import ai.djl.basicdataset.cv.classification.Mnist;
import ai.djl.inference.Predictor;
import ai.djl.ndarray.NDManager;
import ai.djl.translate.TranslateException;
import com.velocitypackage.neuron.bindtf.model.MnistModel;
import com.velocitypackage.neuron.bindtf.model.Usage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class User
{
    public static void main(String[] args) throws IOException, MalformedModelException, TranslateException {
        //Model serialized
        Path modelDir = Paths.get("model/mnist");
        Files.createDirectories(modelDir);

        //Prepare Model
        Model model = Model.newInstance("mnist_mlp");
        model.setBlock(MnistModel.mnist());
        model.load(modelDir, "mnist_trained");

        //Translator
        Predictor pre = model.newPredictor(new Usage());

        //test
        System.out.println(pre.predict(
                Mnist.builder().setSampling(10, true).build().getData(NDManager.newBaseManager()).iterator().next().getData().get(0)
        ));
        System.out.println(pre.predict(
                Mnist.builder().setSampling(10, true).build().getData(NDManager.newBaseManager()).iterator().next().getData().get(0)
        ));
        System.out.println(pre.predict(
                Mnist.builder().setSampling(10, true).build().getData(NDManager.newBaseManager()).iterator().next().getData().get(0)
        ));
        System.out.println(pre.predict(
                Mnist.builder().setSampling(10, true).build().getData(NDManager.newBaseManager()).iterator().next().getData().get(0)
        ));
        System.out.println(pre.predict(
                Mnist.builder().setSampling(10, true).build().getData(NDManager.newBaseManager()).iterator().next().getData().get(0)
        ));
        System.out.println(pre.predict(
                Mnist.builder().setSampling(10, true).build().getData(NDManager.newBaseManager()).iterator().next().getData().get(0)
        ));
        System.out.println(pre.predict(
                Mnist.builder().setSampling(10, true).build().getData(NDManager.newBaseManager()).iterator().next().getData().get(0)
        ));
    }
}

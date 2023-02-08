package com.velocitypackage.neuron.bindtf;


import ai.djl.Model;
import ai.djl.basicdataset.cv.classification.Mnist;
import ai.djl.ndarray.types.Shape;
import ai.djl.training.DefaultTrainingConfig;
import ai.djl.training.EasyTrain;
import ai.djl.training.Trainer;
import ai.djl.training.evaluator.Accuracy;
import ai.djl.training.listener.TrainingListener;
import ai.djl.training.loss.Loss;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.TranslateException;
import com.velocitypackage.neuron.bindtf.model.MnistModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Train
{
    public static void main(String[] args) throws IOException, TranslateException {


        //Train
        int batchSize = 100;
        Mnist mnist = Mnist.builder().setSampling(batchSize, true).build();
        mnist.prepare(new ProgressBar());

        //Prepare Model
        Model model = Model.newInstance("mnist_mlp");
        model.setBlock(MnistModel.mnist());

        //Trainer
        DefaultTrainingConfig config = new DefaultTrainingConfig(Loss.softmaxCrossEntropyLoss())
                .addEvaluator(new Accuracy()) // Use accuracy so we humans can understand how accurate the model is
                .addTrainingListeners(TrainingListener.Defaults.logging());

        Trainer trainer = model.newTrainer(config);
        trainer.initialize(new Shape(28, 28, 1));

        //Noise
        System.out.println(trainer.getTrainingResult().getTrainLoss());

        while (true)
        {

            //Train
            EasyTrain.fit(trainer, 1, mnist, null);

            //Noise
            System.out.println(trainer.getTrainingResult().getTrainLoss());


            // Model serialized
            Path modelDir = Paths.get("model/mnist");
            Files.createDirectories(modelDir);
            model.save(modelDir, "mnist_trained");
        }
    }
}

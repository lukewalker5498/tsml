package tsml.classifiers.shapelet_based.classifiers.ensemble;

import tsml.classifiers.TSClassifier;
import tsml.classifiers.shapelet_based.classifiers.MSTC;
import tsml.data_containers.TimeSeriesInstances;
import weka.classifiers.Classifier;

public class EnsembleMSTC extends AbstractEnsembleTS  {


    MSTC.ShapeletParams params;


    public EnsembleMSTC(MSTC.ShapeletParams params) {
        super();
        this.params = params;
    }


    @Override //Abstract Ensemble
    public final void setupDefaultEnsembleSettings(TimeSeriesInstances data) {
        this.ensembleName = "ENS-MSTC";

        this.weightingScheme = new EqualWeightingTS();
        this.votingScheme = new MajorityConfidenceTS();

        this.numEnsembles = 100;
        TSClassifier[] classifiers = new MSTC[numEnsembles];

        for (int i=0;i<numEnsembles;i++){
            classifiers[i] = new MSTC(this.params);
        }


        setClassifiers(classifiers);
    }


    @Override
    public Classifier getClassifier() {
        return null;
    }

    @Override
    public TimeSeriesInstances getTSTrainData() {
        return null;
    }

    @Override
    public void setTSTrainData(TimeSeriesInstances train) {

    }


}

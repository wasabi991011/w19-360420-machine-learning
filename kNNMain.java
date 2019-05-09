import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	List<DataPoint> data = DataSet.readDataSet(args[0]);
	System.out.println(Arrays.toString(data.get(0).getX()));
	System.out.println(data.get(0).getLabelAsDouble());

    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	double testFrac = 0.25;
	List<DataPoint> testData = DataSet.getTestSet(data, testFrac);
	List<DataPoint> trainData = DataSet.getTrainingSet(data, 1-testFrac);
	
	System.out.println("Full length: "+data.size());
	System.out.println("Test length: "+testData.size());
	System.out.println("Train length: "+trainData.size());

    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)
	


    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
	System.out.println("Distance: "+DataSet.distanceEuclid(data.get(0), data.get(1)));

    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
	KNNClassifier classifier = new KNNClassifier(5);
	DataPoint[] neighbors = classifier.getNearestNeighbors(data, data.get(0));
	int[] targetCount = new int[10];
	for (int i=0; i< neighbors.length; i++){
		targetCount[(int)
	}


    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.


  }

}

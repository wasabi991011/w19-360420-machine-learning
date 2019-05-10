import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	List<DataPoint> data = DataSet.readDataSet(args[0]);
	DataPoint dp = data.get(0);
	System.out.println(Arrays.toString(dp.getX()));
	System.out.println(dp.getLabelAsDouble());

    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	double testFrac = 0.3;
	List<DataPoint> testData = DataSet.getTestSet(data, testFrac);
	List<DataPoint> trainData = DataSet.getTrainingSet(data, 1-testFrac);
	
	System.out.println("Full length: "+data.size());
	System.out.println("Test length: "+testData.size());
	System.out.println("Train length: "+trainData.size());

    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)
	//No


    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
	DataPoint dp0 = data.get(0);
	DataPoint dp1 = data.get(1);
	System.out.println("Distance: "+DataSet.distanceEuclid(dp0, dp1));

    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
	KNNClassifier classifier = new KNNClassifier(5);
	DataPoint[] neighbors = classifier.getNearestNeighbors(data, dp0);
	String prediction = classifier.predict(trainData, dp0);
	System.out.println("Prediction: "+prediction);


    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
	double amountRight = 0;
	for (int i=0; i<testData.size(); i++){
		DataPoint dpi = testData.get(i);
		String predictioni = classifier.predict(trainData, dpi);
		if (predictioni.equals(dpi.getLabel())){
			amountRight++;
		}
	}
	double accuracy = amountRight/testData.size();
	System.out.println("Accuracy: "+accuracy);

  }

  public static double mean(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: average of the elements of array, as a double
    */
    double sum = 0.0;

    for (double a : arr){
      sum += a;
    }
    return (double)sum/arr.length;
  }

  public static double standardDeviation(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: standard deviation of the elements of array, as a double
    Dependencies: requires the *mean* method written above
    */
    double avg = mean(arr);
    double sum = 0.0;
    for (double a : arr){
      sum += Math.pow(a-avg,2);
    }
    return (double)sum/arr.length;
  }

}

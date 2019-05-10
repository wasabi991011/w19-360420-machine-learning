import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{
	
	int k=5;
	KNNClassifier classifier = new KNNClassifier(k);
	double testFrac = 0.3;
	List<DataPoint> data = DataSet.readDataSet("data/BreastCancer.csv");
	int runs = 1;

	for (int i=0; i<runs; i++){
		
		//Split
		List<DataPoint> testData = DataSet.getTestSet(data, testFrac);
		List<DataPoint> trainData = DataSet.getTrainingSet(data, 1-testFrac);
		
		//Test classifier
		double[] results = classifier.test(testData, trainData);
		double accuracy = mean(results);
		double sd = standardDeviation(results);
		System.out.println("Accuracy: "+accuracy);
		System.out.println("Standard deviation: "+sd);
	}
	
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
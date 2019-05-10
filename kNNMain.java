import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{
	
	int k=5;
	KNNClassifier classifier = new KNNClassifier(k);
	double testFrac = 0.3;
	int runs = 1000;
	
	//Baseline
	List<DataPoint> data = DataSet.readDataSet("data/BreastCancer.csv");
	DataSet.printLabelFrequencies(data);
	
	double[][] resultsTot = new double[3][runs]; //Accuracy, Precision, Recall
	
	for (int i=0; i<runs; i++){
		//Split
		data = DataSet.readDataSet("data/BreastCancer.csv");
		List<DataPoint> testData = DataSet.getTestSet(data, testFrac);
		List<DataPoint> trainData = DataSet.getTrainingSet(data, 1-testFrac);
		
		//Test classifier
		double[] results = classifier.test(testData, trainData);
		resultsTot[0][i] = results[0];
		resultsTot[1][i] = results[1];
		resultsTot[2][i] = results[2];
	}
	
	System.out.println("Accuracy has mean "+mean(resultsTot[0])+" and standard deviation "+standardDeviation(resultsTot[0]));
	System.out.println("Precision has mean "+mean(resultsTot[1])+" and standard deviation "+standardDeviation(resultsTot[1]));
	System.out.println("Recall has mean "+mean(resultsTot[2])+" and standard deviation "+standardDeviation(resultsTot[2]));
	
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
# KNN Classifier Report
## Course - Section
## Authors

## Distributions of Model Accuracy

Each time you run the classification model, you should be getting a different accuracy. Why? (hint: lines 148-150 in `DataSet.java`)
	- The shuffling of datapoints before splitting adds some randomness.
Run the entire classification process 1000 times (load data, split into off 30% for a test set, evaluate model performance) and store the results of each run in a `double[]`; use the `mean` and `standardDeviation` methods in `kNNMain.java` to calculate how much performance can be expected to vary on unseen data
	- The mean accuracy I got is 0.9707, with a standard deviation of 0.0284.
What is a sensible baseline against which we should compare our model's performance? (hint: line 200 in `DataSet.java`)
	- The sensible baseline would be to assume that all are benign, which would give a result of 444/(237+444)=0.65%.

## Analysis of different error types


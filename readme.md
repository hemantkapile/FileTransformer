1. Download the project by using clone option.
2. Ensure you have atleast Java 8 and maven installed in your machine, you can import the project as a maven project.
3. In order to create & exceute the jar please go to following path:
	FileTransformer
4. open cmd here exceute "mvnw package" and after successful exceution of the command under FileTransformer/target "FileTransformer-0.0.1-SNAPSHOT.jar" would have been generated.
5. Then go to FileTransformer/target on cmd and exceute below sample commands :
java -jar FileTransformer-0.0.1-SNAPSHOT.jar --inputFile=E:\Java\csvFiles\Friends.csv --outputFile=E:\Java\csvFiles\Output\Friends.csv
java -jar FileTransformer-0.0.1-SNAPSHOT.jar --inputFile=E:\Java\csvFiles\Employees.csv --outputFile=E:\Java\csvFiles\Output\Employees.csv
java -jar FileTransformer-0.0.1-SNAPSHOT.jar --inputFile=E:\Java\csvFiles\People.csv --outputFile=E:\Java\csvFiles\Output\People.csv
java -jar FileTransformer-0.0.1-SNAPSHOT.jar --inputFile=E:\Java\csvFiles\Students.csv --outputFile=E:\Java\csvFiles\Output\Students.csv


Note : 
1. Please change inputfile path according to the available location of file
2. Also, note the name the input file should be exactly same because the code configured i.e. Friends.csv, Employees.csv, People.csv, Students.csv
3. You change the outputFile path and name as per your requirement without any problem.

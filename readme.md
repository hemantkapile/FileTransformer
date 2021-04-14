1. Download the project by using clone option.
2. Ensure you have atleast Java 8 and maven installed in your machine, you can import the project as a maven project.
3. In order to create & exceute the jar please go to following path:
	FileTransformer
4. open cmd here exceute "mvnw package" and after successful exceution of the command under FileTransformer/target "FileTransformer-0.0.1-SNAPSHOT.jar" would have been generated.
5. Then go to FileTransformer/target on cmd and exceute below sample commands :
java -jar FileTransformer-0.0.1-SNAPSHOT.jar --inputFile=E:\Java\csvFiles\Friends.csv --configFile=E:\Java\csvFiles\config\CONFIG_AGE_FILTER.csv --outputFile=E:\Java\csvFiles\Output\Friends.csv
java -jar FileTransformer-0.0.1-SNAPSHOT.jar --inputFile=E:\Java\csvFiles\Employees.csv --configFile=E:\Java\csvFiles\config\CONFIG_COLUMN_MERGER.csv --outputFile=E:\Java\csvFiles\Output\Employees.csv
java -jar FileTransformer-0.0.1-SNAPSHOT.jar --inputFile=E:\Java\csvFiles\People.csv --configFile=E:\Java\csvFiles\config\CONFIG_NEW_COLUMN.csv --outputFile=E:\Java\csvFiles\Output\People.csv
java -jar FileTransformer-0.0.1-SNAPSHOT.jar --inputFile=E:\Java\csvFiles\Students.csv --configFile=E:\Java\csvFiles\config\CONFIG_DATE_FORMATTER.csv --outputFile=E:\Java\csvFiles\Output\Students.csv

Note : 
1. Please change inputFile, configFile, outputFile path according to the available location of file
2. This application supports 4 configurations in csv format seperated by | as follows:
	a) CONFIG_DATE_FORMATTER >> pass Module as "DATE_FORMATTER",TargetColumn Index = column which has date to be formatted,existing dateformat and required date format.
		e.g. DATE_FORMATTER|2|yyyy-MM-dd|MMM d, YYYY
	b) CONFIG_AGE_FILTER >> pass Module as "AGE_FILTER",TargetColumn Index = where the age is mentioned,Condition i.e. age 
	    e.g. AGE_FILTER|1|50|
	c) CONFIG_COLUMN_MERGER >> pass Module as "COLUMN_MERGER", TargetColumn1 Index to be merged,TargetColumn2 Index to be merged and New columnName & Delimiter (here New columnName and delimiter are seperated by '&')
	    e.g. COLUMN_MERGER|1|2|name&, 
	d) CONFIG_NEW_COLUMN >> pass Module as "NEW_COLUMN",TargetColumn2 where age is present,age-ConditionPassValue-ConditionFailValue and New columnName (here age-ConditionPassValue-ConditionFailValue are seperated by ',')
	    e.g. NEW_COLUMN|2|18,T,F|eligible_for_voting

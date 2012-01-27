The USB Robot Controller Application is a Java application intended to make the
control of robots utilizing USB joysticks or game pads easier.

In many cases a user may not know what the functionality of a specific joystick
is. In this case the application has a characterization UI which shows the button
names and allows the user to manipulate them and get the device output values.
All that is necessary for using a joystick is a controller model, function
classes and an application model .xml file.

Setup:
Setup can be done in multiple ways:

1) Run the executbale jar with the arguments rxtx and jinput. This must be
accomplished on the command line.

java -jar USBRobotControllers.jar rxtx
java -jar USBRobotCOntrollers.jar jinput

The order of running these is not important. Select the bin directory of your
JVM and install the system .dll files there.

2) Run the executable jar with the following command:

java -jar -Djava.library.path=resources USBRobotControllers.jar

This method does not require you to copy the system .dll files. However, you
must run the program from the command line. Copying .dll files allows you to
double click the .jar file in windows and execute the program.
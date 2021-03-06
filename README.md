JMX Agent
=========

This is a small connector to kick-start the JMX machinery of a CA-Wily Introscope Agent.

Requirements
============

This Java library is an agent-side plug-in for CA-Wily Introscope. Introscope is a commercial tool for
application performance management (APM) of (large) Java applications in production. In order to use
and/or compile this library you need to have a valid Introscope license. For compilation, a valid Agent.jar
file is required as well. You will need to manually install this JAR file into your local Maven cache,
using the instructions in the POM file of this project.

This library has been developed and tested using Introscope version 8.

* Java 5+
* Introscope Agent installed in application
* Application has an existing JMX Agent (MBean Server)

Installation
------------

    Drop the JMXAgent.jar file into the Introscope Agent directory, where there is a WebAppSupport.jar file.

Configuration
-------------

Add this line to the application's startup configuration command line

    -javaagent:/path/to/JMXAgent.jar

If the Introscope Agent is started using -javaagent then make sure that it is before the -javaagent that starts the JMXAgent. For example:

    java -javaagent:Agent.jar -javaagent:JMXAgent.jar -jar MyApplication.jar


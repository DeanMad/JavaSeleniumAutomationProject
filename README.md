# Java Automation Hackathon
The following project contains automation infrastructure in various fields,including Web,Mobile,Electron,Desktop and API Testing.

## Description
The projects consists of a Main and Test folder each has its own class and packages.
The Main folder contains the utilities,page objects and the workflow of the project.
While the Test folder contains the differing testing files for each platform.

### ConfigFile.xml
This file contains the configuration needed to run the program.
### Dependencies

*The main dependencies are containd in the Poem file,to fully run the tests which were conducted
*on Grafana's both and API the following installer is required:
*https://grafana.com/grafana/download?platform=windows

### Executing program
The program can be excuted using the following mvn commands:
#-mvn test -PWeb
#-mvn test -PApi
#-mvn test -PElectron
#-mvn test -PDesktop
#-mvn test -PAppium

## Note:
The tested program elements were found using xPath and ccSeleactor and are 
subjected to change in the future.

## Authors
Bracha Bachar,Dean Madion,Saed Jaber.

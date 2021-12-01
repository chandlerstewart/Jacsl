# JACSL Mod

## Setup

IDE: 
  - For the purposes of this project the Intellij IDEA IDE was utilized and this setup will assume the usage of this IDE aswell. Eclipse is a viable option as well,       however the setup process may differ.
  - Intellij IDEA is available for download here: https://www.jetbrains.com/idea/download/#section=windows

Operating System:
  - This project was built with Windows 10 and the setup process may differ for MacOS or Linux

Java Version:
  - The Fabric framework we utilized is supported by Java JDK 8
  - Java JDK 8 is available for download here: https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html

Project Setup:
  - Download the most updated version of this project from the master branch
  - Place the project in a convenient location for access
  - Open a project in Intellij IDEA and navigate to the directory for this project
  - Within the Open directory navigation window, select and open the build.gradle file within the project, this will download all dependencies required. This process may take several minutes.
  - Navigate to the right side of your IDE and click the "Gradle" option
    - Navigate to: Jacsl-master -> Tasks -> fabric
    - Run the "runClient" option
    - After the initial run, the IDE GUI run buttons can be utilized

# ![Logo](./images/logo.png) Developer Guide for Photoshop-Ultra-Light
*hello, developer!*

## About the Project

    Language: Java 1.8 or Java 8

    Build tool: Maven 3.1.5

    APIs: OpenCV

## Get Started

1. Get your Java environment ready, download [here](https://java.com/en/download/help/download_options.xml)
2. Make sure maven is installed [Maven](https://maven.apache.org/install.html)

Note: If you're using older Java version, you might want to make sure you have 
[JavaFX](https://docs.oracle.com/javase/8/javafx/get-started-tutorial/jfx-overview.htm) included

## How to Build and Run the Application

**Option 1 (Recommended)**
1. Install or open [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
2. Select `Project from Version Control`
3. Select `Git`
4. Paste `https://github.com/yashdhume/Photoshop-Ultra-Light` in the URL field
5. If not logged in yet, log in to Github account first (bottom left hand side)
6. Select `clone` and the repository should be clone to the workspace
7. Run the project

**Option 2**

1. Clone the repository: `git clone https://github.com/yashdhume/Photoshop-Ultra-Light`
2. Install or open [Eclipse](https://www.eclipse.org/downloads/)
3. Import project to Eclipse
4. Make sure Maven module are included
5. Build and run the application

**Option 3**

1. Clone the repository: `git clone https://github.com/yashdhume/Photoshop-Ultra-Light`
2. Go into the directory: `cd Photoshop-Ultra-Light`
3. Build using Maven: `mvn clean install`
4. Run the Application: `java -cp .\target\PhotoshopUltraLight-1.0-SNAPSHOT.jar Main.Main`


## What's Next?

Now, everything is compiled and running...

Let's [learn more](./USER_GUIDE.md) how to use the application!
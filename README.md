### A basic Java Project assignment for PRO192
Testing basic code checker cpapbility and assesment of coding standard utlity tools online. Using Codacy and Snyk

---

# Student Management System


## Installing Maven using Chocolatey

If you are on Windows and want to install Maven using Chocolatey, follow these steps:

1. Open an elevated Command Prompt or PowerShell (Run as Administrator).

2. Run the following command to install Maven:

```
choco install maven
```

3. After installation, you can verify Maven is installed by running:

```
mvn -version
```

Make sure Chocolatey is installed on your system before running the above commands. For more information, visit https://chocolatey.org/install




## Build and Run Instructions

### Build the Jar

1. Open a terminal and navigate to the `SourceCode` directory where the `pom.xml` file is located.

2. Run the following Maven command to clean and package the project, which will compile the code and create the executable jar file:

```
mvn clean package
```

3. After a successful build, the jar file will be created in the `SourceCode/Output` directory. The jar file name is dynamically set via the `jarname.properties` file.

### Run the Jar

1. Navigate to the `SourceCode/Output` directory.

2. Run the jar file using the following command, replacing the jar file name with the one specified in your `jarname.properties` file (e.g., `StudentManagement-02.jar`):

```
java -jar StudentManagement-02.jar
```

### Notes

- The main class is `app.Main`.
- The jar file name is configured dynamically using the `properties-maven-plugin` and the `jarname.properties` file.
- Ensure you run the commands from the correct directories as specified above.

---

This completes the build and run setup for the basic Student Management System.

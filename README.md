# Web Application Skeleton (Java)

# Prerequisites

* Java SDK (1.6 or greater use '`javac -version`' to check your version)
* [Gradle](http://gradle.org/overview) (build tool)
** if you used [homebrew](http://mxcl.github.com/homebrew/) to install gradle you need to apply a [workaround for the IntelliJ plugin](http://youtrack.jetbrains.com/issue/IDEA-83361#comment=27-356525)
* [IntelliJ Community Edition](http://www.jetbrains.com/idea/download/) (IDE)

## Getting started

1. Ensure you have installed the Prerequisites
1. Create a new directory for your project and change to it
1. Download the skeleton and start a new git repo by executing:

   `curl -L https://github.com/nurous/java-webapp-skeleton/tarball/master | tar zx --strip-components=1 && git init`
1. Run the build (`gradle ideaLibs precommit`) to download libraries and make sure everything works
1. Create your first commit ('`git add . && git commit`')
1. Open the (existing) IntelliJ project
1. Rename the base module (java-webapp-skeleton) to match your project name
1. Rename the package '`your_package`' using IntelliJ's rename refactoring to an appropriate package name
1. Go to the 'TO DO' tab and fix the ones marked with 'MAJOR'.
1. Run the build (`gradle precommit`) to make sure you haven't broken anything
1. Create a commit with your changes ('`git add . && git commit`')
1. Rename `Thingy` to be your first domain model object.
1. The remaining 'TO DO' items are numbered and indicate things you should do to familiarize yourself with the code and begin implementing your application

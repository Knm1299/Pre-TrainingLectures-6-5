package com.revature;

/**
 * What is Maven?
 *      Build tool
 *          Lifecycle steps are incldued as distinct 'goals' that a developer may use in compiling and deploying a java program
 *          This build lifecycle can be customized, each goal can be set up individually in the pom.xml
 * 
 *      Dependency management tool
 *          This is more useful for us in practice
 *          Maven can track what libraries our application needs and what libraries those rely(depend) upon
 * 
 * 
 * 
 *      The pom.xml file is used to configure maven
 *          it stores:
 *              information about the project itself
 *              the steps used if a custom lifecycle is defined(optional)
 *              plugins that extend maven's capabilities(optional)
 *              the libraries(dependencies) we are using
 * 
 *          For our use, we will be just adding dependencies to the pom.xml as we require them
 */
public class App {
    public static void main( String[] args ){

        System.out.println( "Hello World!" );

    }
}

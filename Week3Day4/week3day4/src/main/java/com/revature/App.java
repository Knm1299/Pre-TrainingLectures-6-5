package com.revature;

/**
 *  SDLC, Agile, TDD, Junit
 * 
 *  Today's lecture is about how to approach projects
 *      The simplest approach is Waterfall
 *      Waterfall - inadvisable at scale
 *          gather requirements, deliver project in one shot, never updating requirements, one single development cycle.
 * 
 *      Project owners(stakeholders) - anyone with a vested interest in the project and authority
 *          Requirements evolve as your project does, or as the client's need for your project does
 * 
 *      Agile/Scrum
 *          Agile is a methodology based around work being completed in 'sprints'
 *              essentially, after each week or month, re-evaluate the requirements, and discuss with stakeholders
 *              based on those conversations, develop new requirements or refine old ones, and continue
 *          Agile methodologies such as Scrum use the Software Development Life Cycle
 * 
 *  Software Development Life Cycle (SDLC)
 *      Every company follows a different version of this
 *      anywhere between 5-8 steps depending on who you ask
 *      Defines a cycle made of individual steps designed around periodic re-evaluations of project requirements
 * 
 *      The most important of these steps are:  
 *           - Gather requirements
 *           - Turn requirements into features
 *           - Turn features into code
 *           - Thoroughly test code
 *           - Evaluate if more/different requirements are necessary
 * 
 *      User Stories
 *          Features, written from the perspective of a user
 *              "As a user, when I "..."I should recieve "...
 *              "As a user of the todo application, when I run the application and select 'create new todo item', 
 *                  I should be able to add a todo item to the database"
 * 
 *  TDD - Test Driven Development
 *      Test Driven Development means writing tests that will only pass when your code works, before writing any code.
 *      We've already been doing this with the tests in the labs
 * 
 *      The tests we write should fail originally, because the code necessary hasn't been implemented yet
 * 
 *      This is good because we can confirm that our program is 'feature complete' ie. all features work correctly
 * 
 *  Testing is an art form
 *      The goal with writing good tests is:
 *          dont spend too much time writing them
 *          but 
 *          Make sure that you have as close to 100% line coverage as possible
 *              80% and up is generally acceptable in most circumstances
 *          They need to cover all the edge cases you can think of 
 *              every option of "what can the user input" is accounted for
 * 
 *  Testing strategies
 *     smoke/sanity testing - tests to ensure the program is ready to be tested
 *     Unit                 - testing an atomic portion, the smallest reasonable portion at a time
 *     Integration          - Testing different components together, ensuring that communication between components is working
 *     End to end           - Testing the entire application at once, functionally
 *     UX/acceptance        - Performed by QA or by client/stakeholders, essentially getting notes about usability
 * 
 *  JUnit 4, 5:
 *      Testing framework
 *          Provides libraries
 *          And functionality(usually hooked into by IDEs)
 *      JUnit comes preinstalled as a dependency in the maven template we used yesterday
 * 
 *      Using JUnit
 *          JUnit tests will live in a class named similarly to the ones in your actual application
 *          Package structure reflect the rest of the program
 *          because unit tests are atomic, we should* be testing every method
 * 
 */
public class App {
    public static void main( String[] args ){
        
    }

    public static boolean isSkyBlue(){
        return true;
    }
}

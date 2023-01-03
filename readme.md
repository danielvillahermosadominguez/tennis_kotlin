# The Kata: Tennis
Tennis has a rather quirky scoring system, and to newcomers it can be a little difficult to keep track of. The tennis society has contracted you to build a scoreboard to display the current score during tennis games.

You can read more about Tennis scores on wikipedia which is summarized below:

- A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
- The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as “Love”, “Fifteen”, “Thirty”, and “Forty” respectively.
- If at least three points have been scored by each player, and the scores are equal, the score is “Deuce”.
- If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “Advantage” for the player in the lead.
- You need only report the score for the current game. Sets and Matches are out of scope.

# Acknowledgements
This kata is described on cyber-dojo.org

# Some useful notes about the implementation with Kotlin

## The first gradle empty project
First of all you need to create a Kotlin proyect. We are going to use gradle, so, you will
need to install gradle in your machine. Here you have a link which could be useful:

https://alvaromonsalve.com/2019/05/06/creacion-de-un-proyecto-kotlin-con-gradle/

You can build and test the solution with the following commands:
```
gradle clean build
gradle clean test
```
When you configurate the intelliJ, you could use junit and gradle. And your test will be based on kotlin:
``` kotlin
import kotlin.test.Test
import kotlin.test.assertNotNull

class AppTest {
    @Test fun appHasAGreeting() {
        val classUnderTest = App()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }
```
The gradle file "build.gradle" should have the following lines to detect the tests
``` groovy 
tasks.withType(Test) {
    testLogging {
        exceptionFormat "full"
        events "started", "skipped", "passed", "failed"
        showStandardStreams true
    }
}
```
Some of the tools we have chosen in this kata has been:

```
    testImplementation "org.assertj:assertj-core:3.23.1"

    testImplementation "io.mockk:mockk:1.12.4"

```
## Configuring to use junit 5
In the gradle file you need to include it
``` 
    //testImplementation "io.kotest:kotest-runner-junit5:5.3.2"
    testImplementation 'org.junit.jupiter:junit-jupiter-params:5.9.1'
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.9.1'
    testImplementation 'org.junit.jupiter:junit-jupiter-engine:5.9.1'
```

NOTE:
If you run the test by "gradle clean test" without the "jupiter engine" library (using intelliJ) you will see a message like:

```
    No test were found
```
You will need to change the build.gradle, using the useJUnitPlatform()
```
tasks.withType(Test) {
    testLogging {
        exceptionFormat "full"
        events "started", "skipped", "passed", "failed"
        showStandardStreams true
    }
    useJUnitPlatform()
}
```
And remove from the "useKotlingTest()" call. We really could remove all this
code from the build.gradle

```
testing {
    suites {
        // Configure the built-in test suite
        test {
            // Use Kotlin Test test framework
            useKotlinTest()
        }
    }
}
``` 

Obviously, in your test class, you will need to change your imports with junit:
``` java
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
``` 



# java-test-file-generator

Take a file from console input or from parameters and generates tests files for it.

Through user input it processes just one file and exits. From parameters, it processes all files and then exit.

Only requirement is to have said file(s) as a text file on the root directory. Generated .java files will be put
into the processing directory (it will be created if it doesn't exist).

Example: Given `Person.java` we'd like to generate a number of tests for it

```
void nameShouldNotBeChangedDuringCreation() {}
void personWithoutNameShouldBeNamedJohn() {}
void ageShouldAddOneYear() {}
void lastNameShouldStartWithUpperCaseWhenLowerCaseGiven() {}
void givenAPartnerHasPartnerShouldReturnTrue() {}
void childShouldBeAddedToList() {}
```

we then create a `Person.txt` with just the name of the tests:

```
nameShouldNotBeChangedDuringCreation
personWithoutNameShouldBeNamedJohn
ageShouldAddOneYear
lastNameShouldStartWithUpperCaseWhenLowerCaseGiven
givenAPartnerHasPartnerShouldReturnTrue
childShouldBeAddedToList
```

a `PersonTest.java` will be created inside `./processing/` and it will look like this:

```
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest() {

	@Test
	void nameShouldNotBeChangedDuringCreation() {

	}
	@Test
	void personWithoutNameShouldBeNamedJohn() {

	}
	@Test
	void ageShouldAddOneYear() {

	}
	@Test
	void lastNameShouldStartWithUpperCaseWhenLowerCaseGiven() {

	}
	@Test
	void givenAPartnerHasPartnerShouldReturnTrue() {

	}
	@Test
	void childShouldBeAddedToList() {

	}
```

It's not much, but it can save some typing and repeating and allows for bulk "processing"



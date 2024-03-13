## Lab Report 5

# Part 1 – Debugging Scenario

## Step 1 - Symptom, Bug, and Input

Student Post:

To Whom It May Concern,

I hope this message finds you well. I wanted to ask about resolving my following failed JUnit tests of a method that I have written to reverse the elements of an array of integers and return the output as a new array. 

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab5/StudentEdStemScreenshot.png)

From the output above, the symptom of the test seems to be that the tester is finding zeros in place of the desired elements leading to a discrepancy between what the tester expects and the output of the `reversed()` method.

The failure-inducing input to the `reversed()` method would be the arrays `{ 9,5,8,2,23 }` and `{ 9,5,8,2 }` as per the tests that I have setup.

I feel like I have written the tests correctly, so I may have mixed something up in my implementation of the `reversed()` method in the `ArrayExamples` class, but I am having some difficulty in spotting the issue. Please let me know your thoughts.

## Step 2 - Simulated TA Response

Response:

Hello, thank you for thoroughly describing the symptom, input, and some insight into the bug that you are facing. As you mentioned, the tests that you have setup for the `reversed()` method seem correct. Check your implementation of `reversed()` carefully. You should be assigning values to the new array that you create at the beginning of the method. Also which array should you be returning - the given input or the new array that you create?

## Step 3 - Student Follow-Up

Thank you for providing this key advice on the issue that I am facing. Following your advice, I think I found the issues in my code. Here is a screenshot showing my fix of the `reversed()` method and my tests passing.

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab5/StudentEdStemScreenshot2.png)

Notably, the code change required to fix the bug was to change `arr[i] = newArray[arr.length - i - 1];` to `newArray[i] = arr[arr.length - i - 1];` and change the return value from `arr` to `newArray`.
These fixes addressed the issues that were causing failures previously because although the original code had the correct motivating idea to pass the test cases, it was reassigning values in the provided input to values in a blank array (of zeros), when it should have been assigning values in the blank array to values in the input. Furthermore, the goal of the method `reversed` is to return a new array, so the input `arr` should definitely not be returned, but rather, the new array generated in the method, which is `newArray` should end up being returned.

## Step 4 - Summary Information

### File and Directory Structure Needed

The file and directory structure applied here is as follows using headings

#### lib/
##### hamcrest-core-1.3.jar
##### junit-4.13.2.jar
#### ArrayExamples.java
#### ArrayTests.java
#### test.sh

### Contents of Relevant Files Before Fixing the Bug

The contents of the `ArrayTests.java` and `ArrayExamples.java` files are attached in the screenshot:

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab5/StudentEdStemScreenshot.png)


### Command Line to Trigger the Bug

In the command line, to trigger the bug, we run `bash test.sh` in order to trigger the bug and the contents of the script are:

```
javac -cp ".:./lib/junit-4.13.2.jar:./lib/hamcrest-core-1.3.jar" ArrayTests.java ArrayExamples.java

java -cp ".:./lib/junit-4.13.2.jar:./lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore ArrayTests
```

which are standard commands for compiling and running the Java code in this case.


### Changes to Fix the Bug

The relevant code prior to the change would be:

```
public class ArrayExamples {

  // Returns a *new* array with all the elements of the input array in reversed
  // order
  static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = newArray[arr.length - i - 1];
    }
    return arr;
  }
}
```

and the code after the change that fixes the bug is:

```


public class ArrayExamples {

  // Returns a *new* array with all the elements of the input array in reversed
  // order
  static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      newArray[i] = arr[arr.length - i - 1];
    }
    return newArray;
  }


}

```

Notably, the code change required to fix the bug was to change `arr[i] = newArray[arr.length - i - 1];` to `newArray[i] = arr[arr.length - i - 1];` and change the return value from `arr` to `newArray`.
These fixes addressed the issues that were causing failures previously because although the original code had the correct motivating idea to pass the test cases, it was reassigning values in the provided input to values in a blank array (of zeros), when it should have been assigning values in the blank array to values in the input. Furthermore, the goal of the method `reversed` is to return a new array, so the input `arr` should definitely not be returned, but rather, the new array generated in the method, which is `newArray` should end up being returned.


# Part 2 – Reflection

This quarter has been an important learning experience for me in terms of gaining hands on abilities to be able to utilize the command line in a meaningful and productive way providing valuable skills for my future internships, jobs, research projects, personal projects, etc. One reflection that comes to mind directly is learning how to use bash scripts to collect data on the output of a series of file executions. Since I am taking CSE 151B in Deep Learning this quarter which has been a large challenge for me, I actually applied the Bash scripting I learned in this course to help in one of my programming assignments. The project setup that we had was to have eight to ten training Python scripts which incorporated a series of different model architectures and refinements on top of a baseline model for the purposes of semantic segmentation of images from a certain dataset. Here, I wrote a Bash script in order to execute these training Python files and collect essential data about training and validation accuracies and losses by piping the output of each script to a text file. Although this seems a bit simple, the Bash script really came in useful (clutch) for this programming assignment, notably because without the knowledge from this class, I probably would have pulled an all-nighter running each of the Python scripts one by one on my own (where each script takes half an hour to get all the results) and copying the data from my terminal window. With this approach, I slept soundly while my Bash script retrieved the results for me.

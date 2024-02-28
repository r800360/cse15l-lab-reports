## Lab Report 3

# Part 1 - Bugs

The bug that I chose from Week 4's lab is the concerning the `reversed` method in the `ArrayExamples` class, and the purpose of this method is to take an array of integers and return a new array with all the elements of the input array in reversed order.

Program:

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

Passing and Failure-Inducing Inputs:

```
@Test
public void testReversed() {
  int[] input1 = { };
  assertArrayEquals(new int[]{ }, ArrayExamples.reversed(input1));
}
```
```
@Test
public void testOddReverse() {
  int[] input1 = { 9,5,8,2,23 };
  assertArrayEquals(new int[]{ 23, 2, 8, 5, 9 }, ArrayExamples.reversed(input1));
}
```
```
@Test
public void testEvenReverse() {
  int[] input1 = { 9,5,8,2 };
  assertArrayEquals(new int[]{ 2, 8, 5, 9 }, ArrayExamples.reversed(input1));
}
```


In the code above, the first JUnit test passes, but the two tests below fail.

Symptom:

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab3/ArrayTests.png)

Bug:

The code prior to the change has been attached above, and the code after the change that fixes the bug is:

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



# Part 2 - Researching Commands

For this part of the lab report, the command that I chose was the `grep` command, which I believe was the most useful of the three commands and may alone be a motivation for someone to choose a Linux distribution over other alternatives.

Four interesting command-line options to use with the `grep` command are:

1. `-r` : Although this command-line option is easy to ignore, it makes it possible in the first place to use `grep` with directories and subdirectories by recursively searching them for a String of text. As an example, we can try to search for "Darwin" and "Senator" in `./technical`. The examples of this are as follows:
 ```
[rosachdeva@ieng6-201]:docsearch:210$ grep -r "Darwin" ./technical
./technical/biomed/1471-2105-3-2.txt:        In the 1830's, Charles Darwin's investigation of the
./technical/biomed/1471-2105-3-2.txt:        In the 1970's, Woese and Fox revisited Darwinian
./technical/plos/journal.pbio.0020046.txt:        answers to possible questions and criticisms to avoid stuttering. Charles Darwin also
./technical/plos/journal.pbio.0020046.txt:        stuttered; interestingly, his grandfather Erasmus Darwin suffered from the same condition,
./technical/plos/journal.pbio.0020071.txt:        are many ideologically motivated books opposing natural selection and Darwinism. To
./technical/plos/journal.pbio.0020302.txt:        turn to be consumed by predators. Darwinian evolution would result in many of the same
./technical/plos/journal.pbio.0020311.txt:        out by Charles Darwin and his son Francis in 1880. The Darwins were able to demonstrate
./technical/plos/journal.pbio.0020346.txt:        on the traditional comparative approach, which was always the strength of Darwinian
./technical/plos/journal.pbio.0020347.txt:        described by Charles Darwin (1859).
./technical/plos/journal.pbio.0020347.txt:        Not all genetic variation is created equal. When Darwin first introduced the concept of
./technical/plos/journal.pbio.0020347.txt:        evolution (Darwin 1859), he challenged the prevailing view that species were fixed entities
./technical/plos/journal.pbio.0020439.txt:        location within the head (Hsieh 2003). Charles Darwin was right when he wrote that people
./technical/plos/journal.pbio.0020439.txt:        extra sense” (F. Darwin 1905). Today's biologists increasingly recognize that appropriate
```

Here, the `grep` command looks into key subdirectories in order to find the String "Darwin", and it finds key matches within journal entries in the `biomend` and `plos` subdirectories. Notably, the purpose here would be to look for the name of the famous scientist (Charles) Darwin within these journal records to learn more about Darwin and more about how this research applies or utilizes the work of Darwin.

```
[rosachdeva@ieng6-201]:docsearch:209$ grep -r "Senator" ./technical
./technical/911report/chapter-13.1.txt:                Harman (D-Calif.). In the Senate, Senators Bob Graham (D-Fla.) and Dianne Feinstein
./technical/911report/chapter-13.5.txt:                Director Mueller, andTTIC Director Brennan to Senators Susan Collins and Carl Levin
./technical/911report/chapter-3.txt:                intelligence community, such as those offered by Senators Boren and McCurdy. That
./technical/biomed/1472-6947-2-7.txt:            Senators Graham and Snowe, has been introduced also in
./technical/government/About_LSC/State_Planning_Report.txt:Commission on Legal Needs in Maine, chaired by former Senator
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:Prepared for: Senators James M. Jeffords and Joseph I. Lieberman
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:In response to a May 17, 2001 request from Senators James M.
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:electric power sector. In their request, Senators Jeffords and
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:In conducting the modeling requested by Senators Jeffords and
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:technologies. In accordance with the Senators' request, the
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:On May 17, 2001, Senators James M. Jeffords (VT) and Joseph I.
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:specified by the Senators. We are aware that EIA has modeled the
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:This report responds to the Senators' request. The results
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:In the letter to Administrator Whitman, Senators Jeffords and
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:As previously noted, the letter from Senators Lieberman and
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:Senators' request by mapping in the critical assumptions of the CEF
./technical/government/Env_Prot_Agen/nov1.txt:Senator Jeffords for tackling this important issue and for
./technical/government/Env_Prot_Agen/nov1.txt:EIA conducted to respond to a request from Senators Smith,
./technical/government/Env_Prot_Agen/nov1.txt:from Senators Jeffords and Lieberman. In the
./technical/government/Gen_Account_Office/July11-2001_gg00172r.txt:We are sending copies of this letter to Senator George V.
./technical/government/Gen_Account_Office/July11-2001_gg00172r.txt:Voinovich, Chairman, and Senator Max S. Baucus, Ranking Minority
./technical/government/Gen_Account_Office/June30-2000_gg00135r.txt:Committee on Government Reform; and to Senator Fred Thompson,
./technical/government/Gen_Account_Office/May1998_ai98068.txt:this problem, Senators Fred Thompson and John Glenn, Chairman and
./technical/government/Gen_Account_Office/Oct15-2001_d0224.txt:Report to Senator Robert F. Bennett,
./technical/government/Gen_Account_Office/Oct15-2001_d0224.txt:Dear Senator Bennett:
./technical/government/Gen_Account_Office/Sept14-2002_d011070.txt:Dear Senator Voinovich:
./technical/government/Gen_Account_Office/ai9868.txt:this problem, Senators Fred Thompson and John Glenn, Chairman and
./technical/government/Gen_Account_Office/d0269g.txt:It was prepared at the request of Senator Joseph I. Lieberman,
./technical/plos/pmed.0020209.txt:            by Senator Grassley and by Congressman Hinchey, at least partly address these
```

Here, the `grep` command is able to look into various subdirectories in order to find the String "Senator", and it finds key matches in subdirectories such as `911report` and `government`. Notably, the purpose here would be to look for documentation of senators, who are people in key positions of power, within these records and we could say that the findings within the `911report` subdirectory are critical findings.

In both examples above, we can observe how applying the `grep` command with the recursive flag `-r` is significantly faster than searching for Strings manually though all of the files.

2. `-i`: This command-line option applies a search through `grep` in which the case of the String argument is ignored. The examples of this are attached below:

```
[rosachdeva@ieng6-201]:docsearch:211$ grep -ir "Darwin" ./technical
./technical/biomed/1471-2105-3-2.txt:        In the 1830's, Charles Darwin's investigation of the
./technical/biomed/1471-2105-3-2.txt:        In the 1970's, Woese and Fox revisited Darwinian
./technical/biomed/gb-2001-2-9-research0035.txt:        manually evaluating the results from BLAST and DARWIN (data
./technical/biomed/gb-2001-2-9-research0035.txt:          and DARWIN. BLAST analyses were carried out for both the
./technical/biomed/gb-2001-2-9-research0035.txt:        GenProtEC, BLAST and DARWIN analyses, and MAGPIE
./technical/biomed/gb-2001-2-9-research0035.txt:            DARWIN analysis
./technical/biomed/gb-2001-2-9-research0035.txt:            DARWIN (version 2.0) was used to detect
./technical/biomed/gb-2001-2-9-research0035.txt:            the basis of the DARWIN results. In our hands, DARWIN
./technical/biomed/gb-2001-2-9-research0035.txt:            BLAST and DARWIN analyses. The automatic function
./technical/biomed/gb-2003-4-9-r58.txt:        locations. The DARWIN server [ 30 ] was used to calculate
./technical/plos/journal.pbio.0020046.txt:        answers to possible questions and criticisms to avoid stuttering. Charles Darwin also
./technical/plos/journal.pbio.0020046.txt:        stuttered; interestingly, his grandfather Erasmus Darwin suffered from the same condition,
./technical/plos/journal.pbio.0020071.txt:        are many ideologically motivated books opposing natural selection and Darwinism. To
./technical/plos/journal.pbio.0020302.txt:        turn to be consumed by predators. Darwinian evolution would result in many of the same
./technical/plos/journal.pbio.0020311.txt:        out by Charles Darwin and his son Francis in 1880. The Darwins were able to demonstrate
./technical/plos/journal.pbio.0020346.txt:        on the traditional comparative approach, which was always the strength of Darwinian
./technical/plos/journal.pbio.0020347.txt:        described by Charles Darwin (1859).
./technical/plos/journal.pbio.0020347.txt:        Not all genetic variation is created equal. When Darwin first introduced the concept of
./technical/plos/journal.pbio.0020347.txt:        evolution (Darwin 1859), he challenged the prevailing view that species were fixed entities
./technical/plos/journal.pbio.0020439.txt:        location within the head (Hsieh 2003). Charles Darwin was right when he wrote that people
./technical/plos/journal.pbio.0020439.txt:        extra sense” (F. Darwin 1905). Today's biologists increasingly recognize that appropriate
```

Similar to before, the purpose here would be to look for the name of the famous scientist (Charles) Darwin within these journal records to learn more about Darwin and more about how this research applies or utilizes the work of Darwin. However, as compared to the previous results, we now see that case sensitivity is removed from the search to give us more results that include the name of the scientist in all-caps, and these special search results seem to highlight a special type of analysis which could be of significance for someone studying this research.

```
[rosachdeva@ieng6-201]:docsearch:507$ grep -ir "Experimentally" ./technical | head
./technical/biomed/1471-2091-2-7.txt:        deneddylated state. As this shield is experimentally
./technical/biomed/1471-2091-2-9.txt:          experimentally.
./technical/biomed/1471-2091-3-4.txt:        However, this model has not been tested experimentally. In
./technical/biomed/1471-2105-1-1.txt:        yield. Furthermore, experimentally it was shown that
./technical/biomed/1471-2105-1-1.txt:        aerobically and anaerobically). Experimentally,
./technical/biomed/1471-2105-2-8.txt:        experimentally before considering them to be "genes". Both
./technical/biomed/1471-2105-3-14.txt:          (hypothetical, predicted and experimentally verified)
./technical/biomed/1471-2105-3-30.txt:          stripe pairs have been identified experimentally. Ahab
./technical/biomed/1471-2105-3-30.txt:          the experimentally estimated sizes of the modules. Ahab
./technical/biomed/1471-2105-3-30.txt:          experimentally characterized modules
```

Here, we piped the output of `grep` into the `head` command as the command output was too long to show in the report. We see the first ten lines of the output of a grep search for the term "Experimentally" in a manner that is both recursive in looking at files under the `biomed` subdirectory and not case-sensitive as we see both "Experimentally" and "experimentally". This output is useful as we can essentially understand the author's voice (who is presumably a biomedical scientist), and how the author discusses procedures and methods surrounding the author's work.



3. `-l`: This command-line option takes the results of a regular `grep` search and outputs the files in which matches are found. The same command output applying all three of the discussed flags is attached below: 

```
[rosachdeva@ieng6-201]:docsearch:543$ grep -irl "Senator" ./technical
./technical/911report/chapter-12.txt
./technical/911report/chapter-13.1.txt
./technical/911report/chapter-13.3.txt
./technical/911report/chapter-13.5.txt
./technical/911report/chapter-3.txt
./technical/911report/chapter-6.txt
./technical/biomed/1472-6947-2-7.txt
./technical/government/About_LSC/State_Planning_Report.txt
./technical/government/Env_Prot_Agen/jeffordslieberm.txt
./technical/government/Env_Prot_Agen/nov1.txt
./technical/government/Gen_Account_Office/July11-2001_gg00172r.txt
./technical/government/Gen_Account_Office/June30-2000_gg00135r.txt
./technical/government/Gen_Account_Office/May1998_ai98068.txt
./technical/government/Gen_Account_Office/Oct15-2001_d0224.txt
./technical/government/Gen_Account_Office/Sept14-2002_d011070.txt
./technical/government/Gen_Account_Office/ai9868.txt
./technical/government/Gen_Account_Office/d0269g.txt
./technical/government/Gen_Account_Office/pe1019.txt
./technical/government/Media/Politician_Practices.txt
./technical/plos/journal.pbio.0020272.txt
./technical/plos/journal.pbio.0030127.txt
./technical/plos/pmed.0020209.txt
```

In this example, the purpose is to document all of the files containing any mention of the term "Senator" to find places where the research may have connections to senators, who are people in positions of power, without seeing each of the explicit file matches - this output could be used to select target files to copy over and analyze more thoroughly (which could probably be implemented through commands like `scp` or `rsync`). The way that the command works is by searching the `./technical` directory recursively for "Senator" while ignoring case and using the `l` tag portion (in `-irl`) to extract only the filenames from the output of the command.

```
[rosachdeva@ieng6-201]:docsearch:545$ grep -irl "Darwin" ./technical
./technical/biomed/1471-2105-3-2.txt
./technical/biomed/gb-2001-2-9-research0035.txt
./technical/biomed/gb-2003-4-9-r58.txt
./technical/plos/journal.pbio.0020046.txt
./technical/plos/journal.pbio.0020071.txt
./technical/plos/journal.pbio.0020302.txt
./technical/plos/journal.pbio.0020311.txt
./technical/plos/journal.pbio.0020346.txt
./technical/plos/journal.pbio.0020347.txt
./technical/plos/journal.pbio.0020439.txt
```

In this example, the purpose is to document all of the files containing any mention of the famous scientist, Charles Darwin, to see the places in which the research has connections to him without having to see explicit file matches - this output could be used to select target files to copy over and analyze more thoroughly (which could probably be implemented through commands like `scp` or `rsync`). The way that the command works is by searching the `./technical` directory recursively for "Darwin" while ignoring case and using the `l` tag portion (in `-irl`) to extract only the filenames from the output of the command.


4. `-c`: This command-line option takes the results of a regular `grep` search and creates a count of the frequency of search results per file. `-v`: This command selects lines that do not match a certain String argument search through `grep` (so it is essentially a complementary or complement-based search technique). Normally, I would have only presented a single option, but these options make sense together when searching a large database of files as discussed in the examples below:

```
[rosachdeva@ieng6-201]:docsearch:516$ grep -irc "Darwin" ./technical | grep -v ':0'
./technical/biomed/1471-2105-3-2.txt:2
./technical/biomed/gb-2001-2-9-research0035.txt:7
./technical/biomed/gb-2003-4-9-r58.txt:1
./technical/plos/journal.pbio.0020046.txt:2
./technical/plos/journal.pbio.0020071.txt:1
./technical/plos/journal.pbio.0020302.txt:1
./technical/plos/journal.pbio.0020311.txt:1
./technical/plos/journal.pbio.0020346.txt:1
./technical/plos/journal.pbio.0020347.txt:3
./technical/plos/journal.pbio.0020439.txt:2
```

Here, we have a much more sophisticated application of `grep`: We are conducting a statistical study of the frequency of keyword "Darwin" to understand how many times each file references the famous scientist in the research here (which goes along with our earlier `grep` searches on the scientist), and we can note that the `./technical/biomed/gb-2001-2-9-research0035.txt` is a clear outlier in how it mentions Darwin 7 times. The way that this works is that `grep -irc "Darwin" ./technical` will give us the frequency counts of the recursive search for "Darwin" in all subdirectories of `./technical`, which will return the above results intermixed with a lot of files that have 0 results for the search term ("Darwin"), so to get nontrivial results as we see above, we pipe the output of the command into grep with `-v` to actually filter out any line occurrence that contains the colon symbol followed by 0.

```
[rosachdeva@ieng6-201]:docsearch:517$ grep -irc "Senator" ./technical | grep -v ':0'
./technical/911report/chapter-12.txt:1
./technical/911report/chapter-13.1.txt:1
./technical/911report/chapter-13.3.txt:2
./technical/911report/chapter-13.5.txt:2
./technical/911report/chapter-3.txt:2
./technical/911report/chapter-6.txt:1
./technical/biomed/1472-6947-2-7.txt:1
./technical/government/About_LSC/State_Planning_Report.txt:1
./technical/government/Env_Prot_Agen/jeffordslieberm.txt:11
./technical/government/Env_Prot_Agen/nov1.txt:3
./technical/government/Gen_Account_Office/July11-2001_gg00172r.txt:2
./technical/government/Gen_Account_Office/June30-2000_gg00135r.txt:1
./technical/government/Gen_Account_Office/May1998_ai98068.txt:1
./technical/government/Gen_Account_Office/Oct15-2001_d0224.txt:2
./technical/government/Gen_Account_Office/Sept14-2002_d011070.txt:1
./technical/government/Gen_Account_Office/ai9868.txt:1
./technical/government/Gen_Account_Office/d0269g.txt:1
./technical/government/Gen_Account_Office/pe1019.txt:1
./technical/government/Media/Politician_Practices.txt:1
./technical/plos/journal.pbio.0020272.txt:1
./technical/plos/journal.pbio.0030127.txt:1
./technical/plos/pmed.0020209.txt:1
```

Here, we have a similar idea to the previous example with the motivation of looking for documentation of senators, who are people in key positions of power, and understand which file or files may give us the most information on this; notably, we see a clear outlier and critical search result, which is `./technical/government/Env_Prot_Agen/jeffordslieberm.txt` - this file makes some mention of the term "Senator" 11 times, so using this file, we can better understand the political context of the research being done potentially. The way that the command works is that `grep -irc "Senator" ./technical` will give us the frequency counts of the recursive search for "Senator" in all subdirectories of `./technical`, which will return the above results intermixed with a lot of files that have 0 results for the search term ("Darwin"), so to get nontrivial results as we see above, we pipe the output of the command into grep with `-v` to actually filter out any line occurrence that contains the colon symbol followed by 0.

In summary, `grep` is very versatile and comes with numerous features with regards to finding pieces of text or the number of occurrences of text in a collection of file - the `grep` command alone serves as a good motivation for having or installing a Linux distribution, and a lot of the study on `grep` discussed here really only touches the iceberg of what can be done with such a powerful command along with the ability to combine or compose command line options or flags, such as `-r` (recursive), `-i` (ignore casing), `-c` (count), `-v` (complementary search), and of course `|` (pipe), to name the few that were used in this report. Hopefully, this resubmission was a bit more enjoyable and interesting to read than my original submission!

Source for all options: [https://man7.org/linux/man-pages/man1/grep.1.html]

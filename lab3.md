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

Here, the `grep` command is able to look into various subdirectories such as `government` and `plos` in order to find the provided String argument. This is significantly faster than searching for String arguments manually though all of the files.

2. `-i`: This command-line option applies a search through `grep` in which the case of the String argument is ignored. The same command output applying both of the discussed flags is attached below:

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

```
[rosachdeva@ieng6-201]:docsearch:213$ grep -ir "Experimentally" ./technical
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
./technical/biomed/1471-2105-3-30.txt:        where nothing is known experimentally about the
./technical/biomed/1471-2105-3-30.txt:          We collected a total of 199 experimentally
./technical/biomed/1471-2105-3-30.txt:          experimentally known modules. Any algorithm that would
./technical/biomed/1471-2105-3-34.txt:          the experimentally determined protein-interaction map
./technical/biomed/1471-2105-3-34.txt:          experimentally determined interconnections among network
./technical/biomed/1471-2105-3-38.txt:          experimentally [ 23 ] . In each of the diagrams, there
./technical/biomed/1471-2105-3-4.txt:        alternative method is to experimentally normalize these
./technical/biomed/1471-2105-4-25.txt:          cis DB is mapping of experimentally
./technical/biomed/1471-2105-4-25.txt:          August 1, 2003 the goal is to integrate experimentally
./technical/biomed/1471-2105-4-25.txt:          experimentally known
./technical/biomed/1471-2105-4-25.txt:          experimentally demonstrated transcription start site;
./technical/biomed/1471-2105-4-25.txt:            for which at least 5-10 experimentally known binding
./technical/biomed/1471-2121-2-10.txt:        experimentally dissect such interactions, it is important
./technical/biomed/1471-2121-2-10.txt:          theoretically and experimentally a non-reducible
./technical/biomed/1471-2121-2-11.txt:          experimentally useful cell lines were obtained that
./technical/biomed/1471-2121-2-21.txt:        experimentally co-expressed together with GnRH receptors in
./technical/biomed/1471-2121-3-4.txt:        developing a more detailed but experimentally tractable
./technical/biomed/1471-213X-1-12.txt:        are no reports that experimentally tested this hypothesis
./technical/biomed/1471-213X-1-6.txt:        tested experimentally. Recent embryological study of the
./technical/biomed/1471-2164-2-2.txt:          experimentally and both, as expected of C-terminal
./technical/biomed/1471-2164-2-2.txt:          experimentally. Experimental data suggests that fungal
./technical/biomed/1471-2164-3-33.txt:          after the two experimentally characterized proteins in
./technical/biomed/1471-2164-3-33.txt:          of the experimentally characterized members of this
./technical/biomed/1471-2164-3-7.txt:          for certain genes experimentally. This did not speed up
./technical/biomed/1471-2164-3-7.txt:          experimentally determined cDNA sequence of the vectors.
./technical/biomed/1471-2164-3-7.txt:          average of the difference of the experimentally analyzed
./technical/biomed/1471-2164-3-7.txt:          Experimentally determined fingerprints from single
./technical/biomed/1471-2164-3-7.txt:          in experimentally derived fragment lengths to the real
./technical/biomed/1471-2164-3-7.txt:        patterns experimentally analyzed from single clone
./technical/biomed/1471-2164-3-7.txt:          empirical length), because the experimentally analyzed
./technical/biomed/1471-2164-4-15.txt:        with this experimentally-determined data.
./technical/biomed/1471-2172-3-10.txt:        specified and determined experimentally.
./technical/biomed/1471-2180-1-31.txt:        putative [ 12 13 ] , others experimentally demonstrated
./technical/biomed/1471-2180-1-33.txt:        experimentally and the β-hemolysis positive
./technical/biomed/1471-2180-2-1.txt:        including an experimentally induced helix hand inversion
./technical/biomed/1471-2180-2-1.txt:        structures then undergo an experimentally induced helix
./technical/biomed/1471-2180-2-1.txt:        actual distributions found experimentally.
./technical/biomed/1471-2180-2-35.txt:          experimentally evaluate procedures to measure the
./technical/biomed/1471-2180-3-11.txt:        experimentally:
./technical/biomed/1471-2202-2-7.txt:          study. Experimentally induced changes in β-actin levels
./technical/biomed/1471-2210-1-7.txt:        Prior to testing our hypothesis experimentally, and
./technical/biomed/1471-2210-2-8.txt:        experimentally active molecules being predicted to be
./technical/biomed/1471-2210-2-8.txt:        experimentally inactive molecules are predicted to be
./technical/biomed/1471-2253-2-5.txt:          experimentally determined for each solute (and organ).
./technical/biomed/1471-2253-2-5.txt:          Kwair and Kfwat are known experimentally and are entered.
./technical/biomed/1471-2253-2-5.txt:          equal and correspond to the experimentally measured end
./technical/biomed/1471-2334-2-26.txt:        with experimentally induced endotoxic shock.
./technical/biomed/1471-2334-2-26.txt:        arterial pressure in experimentally-induced endotoxic shock
./technical/biomed/1471-2334-2-26.txt:        experimentally induced by Griffin
./technical/biomed/1472-6793-1-2.txt:        determined experimentally by following the uptake of
./technical/biomed/1472-6793-1-2.txt:        experimentally by measuring the release of the ubiquitous
./technical/biomed/1472-6807-1-1.txt:        selected and purchased to be experimentally tested
./technical/biomed/1472-6807-1-1.txt:          experimentally tested
./technical/biomed/1472-6807-2-1.txt:        confirmed experimentally as being part of the acetylcholine
./technical/biomed/1472-6807-2-1.txt:        predictive, and need to be confirmed experimentally;
./technical/biomed/1472-6807-2-3.txt:          be tested experimentally.
./technical/biomed/1472-6807-2-5.txt:          experimentally, we can construct a model of the wild-type
./technical/biomed/1472-6807-3-1.txt:          the experimentally identified or predicted active sites
./technical/biomed/1472-6807-3-1.txt:          the experimentally determined structure of DDRP revealed
./technical/biomed/1472-6807-3-1.txt:          Using the experimentally determined structure as a
./technical/biomed/1472-6807-3-2.txt:          Correlation between experimentally determined and
./technical/biomed/1472-6807-3-2.txt:          correlation coefficient of the experimentally determined
./technical/biomed/1472-6904-2-5.txt:          what is measured experimentally. In PKQuest the user
./technical/biomed/1472-6904-2-5.txt:          Since the venous concentration is known experimentally
./technical/biomed/1472-6904-2-5.txt:          observed experimentally for propranolol. It is shown that
./technical/biomed/1472-6904-2-5.txt:          type equation similar to what was found experimentally
./technical/biomed/1472-6904-2-7.txt:          These experimentally derived values are in good agreement
./technical/biomed/1472-6904-2-7.txt:          experimentally. The liver metabolism and tubule secretion
./technical/biomed/1472-6904-2-7.txt:        of these parameters were measured experimentally (cProt
./technical/biomed/1472-6904-2-7.txt:        ratio of liver to renal clearance is known experimentally,
./technical/biomed/1472-6904-3-1.txt:          experimentally available.
./technical/biomed/1476-069X-1-3.txt:        above background can be experimentally shown to drive
./technical/biomed/ar624.txt:        controlling experimentally induced autoimmune
./technical/biomed/cc103.txt:          Experimentally, the effectiveness of diuretics in the
./technical/biomed/cvm-2-6-278.txt:        experimentally induced coronary artery constrictions, as
./technical/biomed/gb-2001-2-12-research0051.txt:          recently been proposed and experimentally validated. One
./technical/biomed/gb-2001-2-12-research0051.txt:          was then validated experimentally by showing that MJ1477
./technical/biomed/gb-2001-2-12-research0051.txt:          between these proteins and an experimentally
./technical/biomed/gb-2001-2-12-research0051.txt:          an experimentally characterized enzyme; conservation of
./technical/biomed/gb-2001-2-12-research0051.txt:          experimentally demonstrated enzymatic activity; and
./technical/biomed/gb-2001-2-12-research0051.txt:          experimentally and evidence was presented that the PAS
./technical/biomed/gb-2001-2-12-research0054.txt:          of start codons are not verified experimentally, could
./technical/biomed/gb-2001-2-3-research0007.txt:          experimentally determined structures of IPNS (PDB:1ips),
./technical/biomed/gb-2001-2-4-research0011.txt:          frequencies, both in experimentally derived clones and
./technical/biomed/gb-2001-2-4-research0012.txt:          of which are experimentally inaccessible. In the face of
./technical/biomed/gb-2001-2-6-research0018.txt:          lingual epithelium [ 35]. The best experimentally
./technical/biomed/gb-2001-2-6-research0020.txt:          experimentally determined operons, as found in the
./technical/biomed/gb-2001-2-7-research0024.txt:          experimentally.
./technical/biomed/gb-2001-2-9-research0035.txt:          This reduction is due to functions being experimentally
./technical/biomed/gb-2001-2-9-research0035.txt:          experimentally characterized. Enzymes are the largest
./technical/biomed/gb-2001-2-9-research0037.txt:        Experimentally, one can attempt to solve the problem by
./technical/biomed/gb-2001-2-9-research0037.txt:            experimentally. We chose genes known to play a role in
./technical/biomed/gb-2001-3-1-research0001.txt:        nondestructive, real-time and experimentally flexible -
./technical/biomed/gb-2002-3-10-research0056.txt:            be confirmed experimentally.
./technical/biomed/gb-2002-3-10-research0056.txt:            isolated experimentally and three others have been
./technical/biomed/gb-2002-3-10-research0056.txt:            experimentally for ABI1, GDH2, or TPC1.
./technical/biomed/gb-2002-3-11-research0061.txt:          The experimentally characterized PRC-barrel-containing
./technical/biomed/gb-2002-3-11-research0062.txt:          subtracting the average ratio from the experimentally
./technical/biomed/gb-2002-3-12-research0072.txt:          experimentally. Statistical models of RSS variability
./technical/biomed/gb-2002-3-12-research0072.txt:        has not yet been, or perhaps cannot be, experimentally
./technical/biomed/gb-2002-3-12-research0080.txt:        define experimentally the transcribed portions of the
./technical/biomed/gb-2002-3-12-research0082.txt:        the experimentally known biology of the organism.
./technical/biomed/gb-2002-3-12-research0083.txt:            the merged model was not experimentally indicated. A
./technical/biomed/gb-2002-3-12-research0083.txt:            the experimentally reported position, which in some
./technical/biomed/gb-2002-3-12-research0083.txt:        experimentally verified SWISS-PROT and TrEMBL sequences was
./technical/biomed/gb-2002-3-12-research0083.txt:            to change translation start sites to the experimentally
./technical/biomed/gb-2002-3-3-research0012.txt:          proteins that have been experimentally investigated are
./technical/biomed/gb-2002-3-5-research0021.txt:        to begin to test these models experimentally is to engineer
./technical/biomed/gb-2002-3-5-research0021.txt:        experimentally downregulating expression of specific genes
./technical/biomed/gb-2002-3-5-research0023.txt:          category that has been experimentally characterized. It
./technical/biomed/gb-2002-3-5-research0025.txt:          experimentally verified. For organisms that are known to
./technical/biomed/gb-2002-3-9-research0044.txt:        conservation. Finally, we experimentally validated a subset
./technical/biomed/gb-2002-3-9-research0044.txt:        confirm a subset of our predictions experimentally. An
./technical/biomed/gb-2002-3-9-research0044.txt:        candidates experimentally. These same factors (differential
./technical/biomed/gb-2002-3-9-research0044.txt:        39 cases that we attempted to experimentally verify) was
./technical/biomed/gb-2002-3-9-research0051.txt:          et al. [ 44] affirms experimentally
./technical/biomed/gb-2003-4-2-r11.txt:        has been studied experimentally, and possesses LRAT
./technical/biomed/gb-2003-4-2-r16.txt:        The utility of both experimentally and computationally
./technical/biomed/gb-2003-4-2-r9.txt:          experimentally the effect of mismatches on sensitivity
./technical/biomed/gb-2003-4-5-r30.txt:        experimentally in cultured cells by cloning a reporter gene
./technical/biomed/gb-2003-4-5-r34.txt:            the synthetic patterns using an experimentally derived
./technical/biomed/gb-2003-4-7-r42.txt:          2. We also note that these experimentally verified miRNAs
./technical/biomed/gb-2003-4-7-r42.txt:          5' end to another experimentally verified miRNA (miR-279,
./technical/biomed/gb-2003-4-7-r42.txt:          The 5' ends of a large subset of experimentally
./technical/biomed/gb-2003-4-8-r51.txt:        experimentally, the new finding of a putative PH domain
./technical/biomed/rr171.txt:        described previously during experimentally induced
./technical/plos/journal.pbio.0020019.txt:        whether it is possible to verify these results experimentally. Bergman and Siegal (2003)
./technical/plos/journal.pbio.0020042.txt:        which no function has been experimentally determined in any case. A recent success among
./technical/plos/journal.pbio.0020042.txt:        experimentally tractable organism such as
./technical/plos/journal.pbio.0020042.txt:        hypotheses that can be tested experimentally. By enabling the community to join in this
./technical/plos/journal.pbio.0020100.txt:        these questions, we need to move to experimentally accessible multicellular organisms, such
./technical/plos/journal.pbio.0020350.txt:        nectar behind). Indeed, when one bumblebee type is experimentally removed, the other one is
```



Source for all options: https://man7.org/linux/man-pages/man1/grep.1.html

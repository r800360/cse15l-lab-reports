## Lab Report 4

# Step 4 - Log into ieng6

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab4/Step4.png)

> Keys Pressed: `<alt+tab> <shift+down> <control+c> <alt+tab> <right click> <enter>`, `cs15lwi24 <enter>`. Here, since my last name is a bit long and the command is a bit hard to remember, I had the command `ssh rosachdeva@ieng6-201.ucsd.edu` ready in a Notepad. With this in mind, I used the "Alt Tab" keyboard shortcut to switch over to the Notepad, selected the command with the "Shift Down" keyboard shortcut, and used the "Control C" keyboard shortcut to copy the command. After that, I used the "Alt Tab" keyboard shortcut to switch over to my Command Prompt, and used "Right Click" to paste (which is just a two finger tap on a mousepad). Finally, I pressed the Enter key to run the `ssh` command at which point my SSH keys were used to complete my log in to the ieng6 server, and I immediately executed `cs15lwi24` to begin work for this class as instructed.

# Step 5 - Clone repository fork with SSH URL

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab4/Step5.png)

> Keys Pressed: `<control+l> <alt+tab> <down> <shift+down> <control+c> <alt+tab> <right click> <enter>`. Here, I used the "Control L" keyboard shortcut to clear my terminal or screen, and since the command is a bit hard to remember, I had the command `git clone git@github.com:r800360/lab7.git` ready below the `ssh` command from the previous step in the Notepad. With this in mind, I used the "Alt Tab" keyboard shortcut to switch over to the Notepad and pressed the down arrow to deselect the `ssh` command from before and move my cursor to the beginning of the `git clone` command. Then, I selected the command with the "Shift Down" keyboard shortcut, and used the "Control C" keyboard shortcut to copy the command. After that, I used the "Alt Tab" keyboard shortcut to switch over to my Command Prompt, and used Right Click to paste (which is just a two finger tap on a mousepad). Finally, I pressed the Enter key to run the `git clone` command at which point the files in the `git` repository were copied or cloned over to my local machine as depicted in the screenshot above.

# Step 6 - Run tests, demonstrating failure

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab4/Step6.png)

> Keys Pressed: `<control+l> cd lab7 <enter>`, `ls <enter>`, `bash t <tab> <enter>`. Here, I used the "Control L" keyboard shortcut to clear my screen and used the change directory (`cd`) command to enter the git repository. Then, I used the list (`ls`) command to see which files are present and attempt to locate a bash script. After seeing the `test.sh` script which contains the necessary `javac` and `java` commands to compile and run the code, I used the `bash` command with tab autocompletion to have the command line autofill the name of the script and execute the script. This ran the configured JUnit tests to demonstrate that one of the tests (`testMerge2()`) failed.

# Step 7 - Edit the code file to fix the failing test

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab4/Step7.png)

> Keys Pressed: `vim L <tab> . (dot) <tab> <enter>`, `/cha <enter> <enter> <right> <right> <right> <right> <right> i <delete> 2 <escape> :x <enter> `. Here, I used tab autocompletion twice to get the terminal to autofill `ListExamples.java`, and when I entered the file, I used the `vim` search capability with the forward slash to search the comment directly above where the change needed to be made. Then, I used the enter key to get to the line I needed to change and navigated to the appropriate place with the right arrow key. After this, I pressed `i` for Insert Mode in `vim` and made my change of removing the 1 and putting 2 in its place to change `index1` to `index2`. Finally, I pressed `Escape` to exit Insert Mode and applied the `:x` shortcut which replaces `:wq` to quickly save my changes and exit.

# Step 8 - Run tests, demonstrating success

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab4/Step8.png)

> Keys Pressed: `<up> <up> <up> <enter>`. Here, I used the up arrow key to access the `bash test.sh` command which at this time was 3 commands up in the command history. Then, I hit the enter key to execute the script and run the configured JUnit tests in order to demonstrate that all of the tests passed and were successful.

# Step 9 - Commit and push the resulting change to my Github account

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab4/Step9.png)

> Keys Pressed: `git add . <enter>`, `git commit -m "Changed index1 to index2 to fix ListExamples.java" <enter>`, `git push <enter>`. As someone who has worked on a good number of collaborative projects, these steps were committed to muscle memory. I started by using the `git add` command with the `.` (dot) shortcut to add all changes in the working directory to my commit. Then, I used the `git commit` command with the `-m` tag to write a custom commit message in the line where I was typing the command. Finally, I used the `git push` command to push my changes to my Github account.

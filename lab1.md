## Lab Report 1

Here, we demonstrate common examples of the `cd`, `ls`, and `cat` commands as applied to without arguments, to a directory, and to a file within the workspace that was created during the first lab session.

We begin with the `cd` command, which is short for "change directory". Starting at the `/home/lecture1` working directory and running the command with no arguments, we have,

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab1/cd_command_no_arguments.png)

Here, we observe that the `cd` command changed from the aforementioned working directory to `~` (which is the `/home/` directory) without any additional output as a default behavior of the command because we did not specify a directory to change to as an argument for the command. From this behavior, it is clear that this is not an error.

Continuing, when we start at the `/home/` working directory and run the `cd` command with the directory containing the translated "Hello World" messages from the first lab session, we have,
![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab1/cd_command_directory.png)

Here, we observe that the `cd` command changed the green directory portion of the prompt from `~` (which is the `/home/` working directory) to `~/lecture1/messages` according to our specification for the command. We passed a directory as an argument to the command which is a standard usage of the command which is why we observed this output. As per this standard usage, the output is not an error.  

Finally, we can start at the `/home/` working directory and run the `cd` command with the `en-us.txt` translated "Hello World" message from the first lab session, and we have,

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab1/cd_command_file.png)

Here, we observe that the `cd` command did not change our directory because our directory before was `~` (which is the `/home/` working directory) and our directory after was `~` (which is still the `/home/` working directory). This is because the command instead returned an error because the command is not intended to take a file as an argument but rather a directory. This is why our error message points to the file that we passed in and contains the message "Not a directory", showing that we did not apply the command properly in this case and that the command was looking for a directory for us to change to as opposed to a file.

After this, we advance to the `ls` command which is short for "list". Starting at the `/home/lecture1` working directory and running the command with no arguments, we have,

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab1/ls_command_no_arguments.png)

We can see from the output that the contents of the current `/home/lecture1` working directory were listed. In this working directory, there was the `./messages/` directory which contained the translated "Hello World" messages from the lab session, the `Hello.java` file from the lab session, the Hello.class file that we compiled in the lab session, and the Github `README`. Therefore, the `ls` command with no arguments worked as expected in listing out the files and highlighting the `./messages/` directory in blue. In this sense, the output was not an error.

Continuing, when we start at the `/home/` working directory and run the `ls` command with the directory containing the translated "Hello World" messages from the first lab session, we have,

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab1/ls_command_directory.png)

Here, we observe from the output that the `ls` command travelled to the `/home/lecture1/messages` directory and listed out the translated "Hello World" message files that were in the directory from the lab activity. These were the `en-us.txt` file, `es-mx.txt` file, `fr.txt` file (that I made separately), and `zh-cn.txt` file. Therefore, the `ls` command with a directory as an argument worked as expected in listing out files in a specified directory. Due to this, the output was not an error.

Finally, we can start at the `/home/` working directory and run the `ls` command with the `en-us.txt` translated "Hello World" message from the first lab session, and we have,

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab1/ls_command_file.png)

Here, we observe from the output that the `ls` command took our input file path and returned the same file path to us (which was `/home/lecture1/messages/en-us.txt`). Since the `ls` command is meant to list single files and directories, this is an expected output and the base case of the "list" command since it travelled to a singular file. Due to this, the output is not an error, and there is no error message.

Lastly, we will demonstrate the `cat` command, which is short for "concatenate". Starting at the `/home/lecture1` working directory and running the command with no arguments, we have,
![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab1/cat_command_no_arguments.png)

This was an interesting output as the output was initially blank, but when I entered pieces of text into the terminal, then I received a copy of the text as output. I think that the `cat` command was reading my text as input and returning it as standard output in this case, and I did not realize that the `cat` command could do this. I also had to exit the command execution using the Control-C terminating shortcut. The output was not an error but was fascinating.

Continuing, when we start at the `/home/` working directory and run the `cat` command with the directory containing the translated "Hello World" messages from the first lab session, we have,

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab1/cat_command_directory.png)

Here, we observe from the output that the `cat` command returned an error which contained the command, the directory we passed in which was `/home/lecture1/messages/`, and the error message "Is a directory". We received this output error because the `cat` command is intended to be used with files or a sequence of files that can be combined and printed out to the terminal window. Therefore, the command did not know what to combine or print out when we passed in a directory, so it makes sense why we have received an error when trying this. 

Finally, we can start at the `/home/` working directory and run the `cat` command with the `en-us.txt` translated "Hello World" message from the first lab session, and we have, 

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab1/cat_command_file.png)

We can see from the output that the `cat` command returned the contents of the en-us.txt file here into the terminal which was "Hello World". We received this output as this is a standard use case of the `cat` command which reads the raw contents of a file that is passed in and prints it out to the terminal. Since we gave a valid directory to an existing text file in the filesystem, the command was able to read it and print the phrase "Hello World". Due to this, we see that the output is not an error.

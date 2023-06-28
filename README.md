# movie-picker#
This is a pure Java command line app that works with a movie database in a .csv file to provide the user the possibility to search in that database and get movie recommendations.

Installation on Windows 11 with PowerShell 5.1 (see version with `Get-Host` command):
- have Maven and JDK installed (I have Maven 3.8.7. and JDK 17.0.5)
- check if Maven is installed and is accessible (`mvn --version`). You should see the version number appear.
- check if JDK is installed and is accessible (`java --version`). You should see the version number appear.
- `git clone <ssh-link-to-repo> <target-folder>` -- Drop the angle brackets ("<>") from placeholders like "<ssh-link-to-repo>" and just replace the explanatory text (e.g. "ssh-link-to-repo") with the real value (it can be the actual file name, destination path, etc.).  
- `cd` into target folder you've just chosen when you cloned the repository in the previous command.
- `mvn compile`
- `mvn package`
- `java -jar .\target\<full-name-of-compiled-file-with-jar-extension>` -- Look into the target folder and you'll see the neccessary file.

<img width="556" alt="image" src="https://github.com/Geri306/netflix-recommendations/assets/107036298/91999e61-1fab-451f-b9c9-7fc430b13e4c">

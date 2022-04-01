# MeshCentral
This is my gui for MeshCentral tested on a ubuntu based system.

# Install
Make sure you have the latest java installer installed (openJDK).

## Ubuntu
sudo apt install git\
sudo apt install openjdk-13-jdk
\
\
\
\
Copy the folder Meshcentral/ to /home/$USER/
So you would get /home/$USER/MeshCentral/data/...

When ready run the .jar file.
You might need to give the file excecute permissions: sudo chmod 775 MeshCentral.jar\
Command to run the jar file:\
- First check if openjdk is installed with: java -version\
- Then run the MeshCentral.jar file: java -jar MeshCentral.jar\

# Questions
If you have any question please start a new Issue on github or contact me via anthony.tacquet@gmail.com

# Desktop file
Create a file: sudo nano /user/share/appilications/meshcentral.desktop
Move the meshcentral.png to your Pictures folder
Add content below:

[Desktop Entry]\
Encoding=UTF-8\
Version=1.0\
Type=Application\
Terminal=false\
Exec=/path/to/MeshCentral.jar\
Name=MeshCentral\
Icon=/home/$USER/Pictures/meshcentral.png

You may need to log out and back in for it to work.

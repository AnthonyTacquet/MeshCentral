# MeshCentral
This is my gui for MeshCentral tested on a ubuntu based system.

# Install
Make sure you have the latest java installer installed (openJDK).
Copy the folder Meshcentral/ to /home/$USER/
So you would get /home/$USER/MeshCentral/...
When ready run the .jar file.
You might need to give the file excecute permissions: sudo chmod 775 MeshCentral.jar

# Questions
If you have any question please start a new Issue on github or contact me via anthony.tacquet@gmail.com

# Desktop file
Create a file: sudo nano /user/share/appilications/MeshCentral.Desktop
Add content below:

[Desktop Entry]\
Encoding=UTF-8\
Version=1.0\
Type=Application\
Terminal=false\
Exec=/path/to/MeshCentral.jar\
Name=MeshCentral\
Icon=/path/to/image if you have one

You may need to log out and back in for it to work.

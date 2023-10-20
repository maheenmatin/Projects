# Maheen Matin

-In IntelliJ IDEA, open the directory "WhereAmI".
Then, go to "File" --> "Project Structure". 
In "SDKs", apply JDK 17. 
In "Global Libraries", click "+" in the second column, 
then click "Java".
In the "CityEngine40" directory, select the "CityEngine.jar"
file. Finally, click "Apply" and "OK".

-The prologue was something I built to practice using
the CityEngine - and, as a result, the code is quite
unorganised.

-The prologue is not part of the main level. By 
default, I have set it to execute before the main 
level. However, you can disable the prologue and skip 
to the main level by going to the Master Class in the
Master Package, then assigning the chapter field to 2.

-The main level is controlled using A for left, D for
right, W for jump and S for attack. The aim of the game
is to kill as many of the demons as possible in
60 seconds. The game will end when 60 seconds have
elapsed. Alternatively, if you fall and hit the spikes 
or if a demon "catches" you - in that, you collided
with a demon, but you were not attacking (holding the
S key).

-After the game ends, your final score and high score
will be displayed. You can press R to restart the game
(main level only).
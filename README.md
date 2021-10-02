# DrinkingGame

The project “Drinking game”

Rules.

2 players, 1 random number. Players by each turn counting the numbers starting from 1. But the number which contains or divides with the random cannot be displayed. The right numbers cannot be skipped. If the player says the “wrong” number or skippes the "right one", he drinks, and the counting continues till one of the players has drinked 5 times. Then the player counts as “drunk” and the opposit player winns. The end of the game.

Idea.

At the beginning we had two main ideas – “The drinking game” and an online shop for the socks. When we talked more about theese ideas we came to conclussion that the online shop idea would involve more database and less coding part and game idea would propouse the oppossit. So we made a choice to do “the drinking game”.
We dont`t know exact name for this game but the main idea and the rules for our game is gotten out of the card game “Kava” that Kia bought in “Jāņa Rozes grāmatnīca”. This card game contains bunch of cards which displays tasks for the players and if a player can`t, wont or make mistakes doing a task, he or she drinks. And our game is one of the tasks in “Kava1”.

Process of project.

At the begining we thought that we may split the parts of the project between our selves but because of inexperience of doing theese kind of projects we couldn`t possible be sure how much and what exactly we would be suppose of doing. What we did assume – there will be database part and coding part where the last one would be splited – outside game and in game logic parts. Una voluntiered to be our database guru. Kia as a past time “drinking game” user included her self in the game logic part. Irina agreed to type the code for an outside game part (comunication with user and  participants) and later on – to create and manage Player class. After that everything happened so fast and haotic:
•	extremeley messy sketches in Photoshop
•	the code writing and sharing using codeshare.io
•	Zoom meetings where we all (including our database guru) were looking to the code and trying to figure it out what the hell is wrong with that, and playing arround with characters and order in the code hoping to improve it
•	in our darkest struggling moments asking for a divine hints of our tutor Kārlis

It would look like this:

Zoom -> codewriting/sharing -> Zoom (sketches) ->  codewriting/sharing -> struggling -> Zoom -> asking for help -> Zoom -> codewriting/sharing -> Zoom (struggling) -> codewriting/sharing -> Zoom -> asking for help -> codewriting/sharing...etc

Process of making a game.

Array.

First we made methods and used this methods for making an array which would contain only the right numbers based on random number. We also decided that a random number will be somewhere between 3-9 (3 and 9 included) because with number 1 our array would be complete emty and with number 2 – would be too much skipped numbers.

Players.

At the beginning we thought that a game can contain several players but in the process we decided to include only 2, to make our game a bit simpler. Player names is going to be saved in two places – an array and in the class. Player class also contained methods to input/read data and count mistakes made by players.



Who drinks.

To decide which player drinks after we asked to enter the number the “for” loop checked if this number is equal as one in the array and in exact place. In that we cought two rabbits with one shot – checking if the number is in array and the next one to be count. At the start we struggled because for each task – switch player turns and switch the number to the next one – we had “for” loop but it raised the issue that a game stucked in the one “for” loop and could not get in the next one. So for switching the players one “for “ loop we changed for the “if/else” statement and that solved our problem.

Database.

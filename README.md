## Territory Tactician
The project is a territory management and strategy game where players choose to build and manage either a Kingdom or a Dynasty. Players are tasked with:

1. Assigning villagers (with various professions like Knights, Blacksmiths, Farmers, etc.) to different buildings (such as Homes, Forges, and Barracks).
2. Managing resources like food production and gold, ensuring the survival and growth of their territory.
3. Enhancing the territory by leveraging the unique benefits of each villager's profession (e.g., Knights increase defense, Farmers produce food, Blacksmiths enhance attack power).
4. Building structures within the territory and managing the capacity and profession distribution within those buildings.
5. Fighting enemy territories, using accumulated resources and defense strategies to attack and defend against other territories.
6. Players can also restart the game, wiping their progress and starting fresh by selecting a new Kingdom or Dynasty to manage.

# Prerequisites
Java version 22.0.1 
# Steps to set up the project locally.
If you are forking from Github clone this 
git@github.com:BenyamWorku/Java_Assessment.git
# Commands to compile the code using build tools.
javac app/MainApp.java Territory/*.java Villagers/*.java Buildings/*.java Enemy/EnemyTerritory.java

# Instructions on how to execute the compiled program.
java app/MainApp.java

# Folder Structure

```plaintext
📦 TerritoryManagementGame
├── 📂 app
│   └── MainApp.java          # Main application logic and game loop
├── 📂 buildings
│   ├── Barracks.java         # Barracks building for Knights
│   ├── Building.java         # Abstract base class for all buildings
│   ├── Forge.java            # Forge building for Blacksmiths
│   └── Home.java             # Home building for multiple professions
├── 📂 territory
│   ├── Dynasty.java          # Dynasty territory type
│   ├── Kingdom.java          # Kingdom territory type
│   └── Territory.java        # Abstract base class for all territories
├── 📂 villagers
│   ├── Blacksmith.java       # Blacksmith profession
│   ├── Engineer.java         # Engineer profession
│   ├── Farmer.java           # Farmer profession
│   ├── Healer.java           # Healer profession
│   ├── Knight.java           # Knight profession
│   ├── Merchant.java         # Merchant profession
│   ├── Scholar.java          # Scholar profession
│   └── Villager.java         # Abstract base class for all villagers
├── 📂 enemy
│   └── EnemyTerritory.java   # Enemy territory logic and combat
├── 📂 utils
│   └── HelperFunctions.java  # Utility functions for input handling and other common tasks
└── README.md                 # Project description and instructions


## Provide examples of how to use the application.


## Tech-debts
### TODO
- [X] Get rid of Directions expressed in Char
  - [X] Introduce Enum for Directions
  - [X] Refactor the code to use Enum instead of Char
    - [X] Create a mapper to convert Char to Enum 
    - [X] Use mapper in determineNextDirectionForMoveCommand method
    - [X] Use mapper in whatIsOnTheLeftOf method
      - [X] create a mapper to convert Enum to Char
      - [X] return mapped enum in whatIsOnTheLeftOf
    - [X] Use mapper in whatIsOnTheRightOf method
      - [X] return mapped enum in whatIsOnTheLeftOf
    - [X] Move whatIsOnTheLeftOf and whatIsOnTheRightOf to Direction class
    - [X] adding Direction in Enum format to RoverPosition
    - [X] making sure that wherever we are using Direction in Char format, we are also using Enum format
      - [X] update whatIsOnTheRightOf to accept Enum and char both as input
      - [X] update whatIsOnTheLeftOf to accept Enum and char both as input
      - [X] initialize direction property in the constructor of Rover
      - [X] update the method called getCurrentPosition to return the direction in Enum format
        - [X] create enum value for directions so that the first letter is returned
      - [X] update the method called determineNextDirectionForMoveCommand to work with position.direction
      - [X] remove the direction property with char format from RoverPosition
        
 
### Done
- [X] Add a test for HelloWorld class.

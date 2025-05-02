
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
        
 


- [X] Make properties private
    - [X] Make properties private in RoverPosition
        - [X] make direction property private
          - [X] create a getter for direction property
          - [X] create a setter for direction property
          - [X] use getter for accessing direction property
          - [X] use setter for updating direction property
        - [X] make x property private
          - [X] create a getter for x property
          - [X] create a setter for x property
          - [X] use getter for accessing x property
          - [X] use setter for updating x property
        - [X] make y property private
          -[X] create a getter for y property
          -[X] create a setter for y property
          -[X] use getter for accessing y property
          -[X] use setter for updating y property

- [X] Remove setters from RoverPosition class
  - [X] Move instantiation of Position from Rover class to RoverPosition class
      - [X] create a constructor in RoverPosition class
      - [X] Use the constructor in Rover class
  - [X] Move position changing logic to RoverPosition class
    - [X] move moveDown to RoverPosition class
    - [X] move moveUp to RoverPosition class
    - [X] move moveLeft to RoverPosition class
    - [X] move moveRight to RoverPosition class
    - [X] remove setters from RoverPosition class
    - [X] move turnLeft to RoverPosition class
    - [X] move turnRight to RoverPosition class
    - [X] move the move method to RoverPosition class

- [X] Move getCurrentPosition to RoverPosition class
  
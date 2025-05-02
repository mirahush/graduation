## Tech-debts
### TODO
- [ ] Get rid of Directions expressed in Char
  - [X] Introduce Enum for Directions
  - [ ] Refactor the code to use Enum instead of Char
    - [X] Create a mapper to convert Char to Enum 
    - [X] Use mapper in determineNextDirectionForMoveCommand method
    - [X] Use mapper in whatIsOnTheLeftOf method
      - [X] create a mapper to convert Enum to Char
      - [X] return mapped enum in whatIsOnTheLeftOf
    - [X] Use mapper in whatIsOnTheRightOf method
      - [X] return mapped enum in whatIsOnTheLeftOf
    - [X] Move whatIsOnTheLeftOf and whatIsOnTheRightOf to Direction class
 
### Done
- [X] Add a test for HelloWorld class.

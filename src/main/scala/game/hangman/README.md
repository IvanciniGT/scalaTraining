# Can we create all the game in just 1 single file?

Ye we can!!!!

# But... should we do that? 

for sure we should not.
- Messy code
- Code extremely hard to read, maintain and test
- Reuse of code is not possible

# Let's define some components.

- game logic
- UI
- To play a turn... status of a match

We play against the computer... 
Can you imagine more games that could be played like thi one? tic-tac-toe, battleship, etc...

Maybe we want to define what a game like those is... and then we can reuse part of the UI and part of the logic.

Are you going to play just 1 round... we may play several..

HAve a counter of the wins and losses of the player

----

enum Winner:
  case Player, Computer, None

trait Game
    def setUI(ui: GameUI): Unit
    def setLogic(logic: GameLogic): Unit
    def playOneRound(): Winner
    def setAdditionalDetail() 

trait GameLogic

? HangmanGame extends Game:
    def playOneRound(): Winner
    - HangmanGameLogic
    - UI
    - Status


object HangmanGameLogic extends GameLogic:

trait HangmanGameUI extends GameUI:

HangmanGameConsoleUI extends HangmanGameUI
HangmanGameDesktopUI extends HangmanGameUI

----
Play Games
    Identify ourserlves
    Score (statistics) Played gamnes.. wins... lost

trait Player
    def name: String
    def score: Score
//    def play(game: Game): Winner




///

In Spain the ID Card
- 8 digits
- 1 letter: Control character HASH of the number

23000001 / 23
        --------------
       1   1000000 
       ^
    REMAINDER

Each remainder (0..22) has a char associated
0 -> T
1 -> R
2 -> W

You are creating an app (webapp)
And you have to capture the ID Card of the user

FRONTEND                        ---->           BACKEND
                                                                Defines custom business logic
                  To send inform. to the backend                    |                                ^ INSERT INTO People (...)
                    v                                               v                                   v
Form Component -> Service  --- REST request --> Controller -->  Service -> Repository -> DB (ID Validation - logic) PL/SQL
    ^                                                ^                           ^
 To Capture information                              |                           |  Defines the persistance logic
                                                     |
                                                Logic for exposing a service thru a protocol (REST & SOAP)
                                                    In case person data is not valid, return HTTP 400 CODE   - BAD REQUEST

                                                                     ^
                                                                    def addPerson(person: Person): Unit
                                                                        Persiste the person in the DB (thru the repository)
                                                                        Send an email to that person

                                                Rest Controller
                                                SOAP Conatroller


You have 1 single place to add that validation(logic)... Which would be the place?

DATE : day / month / year
                    
Databases validates dates... with logic
    Month should be between 1 and 12

    Day should be between 1 and 31 if month is 1, 3, 5, 7, 8, 10, 12
                       1 and 30 if month is 4, 6, 9, 11
                        1 and 28 if month is 2  (29 if leap year)

---

HangmanGame
    -> HangmanGameLogic
    -> HangmanGameUI
    -> HangmanGameStatus

Let's create some tests for the HangmanGame.

What kind of tests should we do?
- Unit tests for all those 4 components
- Integration tests for:
  - HangmanGame + HangmanGameLogic
  - HangmanGame + HangmanGameUI
  - HangmanGame + HangmanGameStatus
- Some system tests for the whole game


We classify tests by using different taxonomies:
- Depending on the test scope
    - Unit tests            Is a test that is focus on a unique/single caracteristic of an ISOLATED component
    - Integration tests     Is a test that is focus on the COMMUNICATION between 2 components   
    - End2End tests         Is a test that is focus on the BEHAVIOUR of the system as a whole
- Depending on the test objective
    - Functional tests
    - Non-functional tests
        - Performance
        - Scalability
        - HA
        - Load
        - Security
        - Usability
        - etc...
  
Test Doubles: Martin Fowler
----------------------------
Dummies
Stubs
Fakes
Spies
Mocks 

---

# Tests

## Unit tests

- HangmanGameConsoleUI.gameStart(gameStatus: HangmanGameStatus): Unit
- HangmanGameConsoleUI.gameEnd(gameStatus: HangmanGameStatus): Unit
- HangmanGameConsoleUI.askForNewChar(): Char
- HangmanGameConsoleUI.provideCharFeedBack(char: Char, gameStatus: HangmanGameStatus)
- HangmanGameConsoleUI.showGameStatus(gameStatus: HangmanGameStatus): Unit

- HangmanGameLogicImpl.startGame(setOfAllowedWords: List[String]):HangmanGameStatus
- HangmanGameLogicImpl.newChar(newChar:Char, currentStatus:HangmanGameStatus):HangmanGameStatus


- AbstractHangmanGame.play(player: Player, setOfAllowedWords:List[String]): Winner.Winner  // HARD TO TEST



- ClassicalConsoleHangmanGame protected (filename:String, val name: String) extends AbstractHangmanGame (HangmanGameLogicImpl, HangmanGameConsoleUI){
- readFileLines(file:String): List[String] 
- wordsSet():List[String] 
- play(player: Player): Winner.Winner

- object ClassicalConsoleHangmanGameCountriesEdition















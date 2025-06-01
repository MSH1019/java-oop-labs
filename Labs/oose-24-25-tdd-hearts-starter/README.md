# Card Game
NO PAIR PROGRAMMING
## Backgound

This week you will be looking at further applying the knowledge you've gained on writing tests and mocking, through test-driven development.

Hints:
* A lot of these tasks and the code you will be working with should be familiar to you from previous labs. If not, you may wish to re-visit the labs on unit testing and mocking.
* Read through each task fully before attempting. There may be notes or hints at the end of each section that can make your work easier.

## Background
* See [https://moodle.gla.ac.uk/mod/page/view.php?id=5031924](https://moodle.gla.ac.uk/mod/page/view.php?id=5031924) for a description of Hearts.

## Task One - EasyComputerTest and EasyComputer - Medium
You will now use test-driven development to first write tests for, then implement code for an easy-to-beat computer player in a game of Hearts.

First write tests for the following scenarios and commit the code to GitLab, then implement the following methods and commit again:
* `getComputerSwapCards` should always return the three lowest ranked cards held by the computer player as a Hand instance.
    * The test should be straightforward to implement.
    * For implementing the method in `EasyComputer`, you may find it helpful to look through the methods implemented in `Hand`.
* `computerPlays` should return the next `Card` a computer will play, based on the following logic:
    * If there is no trump suit currently in play (i.e.: no cards have been played yet), the first card in their hand should be returned.
    * If there is a trump suit in play:
        * Let's call the computer's highest card of the trump suit `highestOwnCard`, and the highest card of the trump suit currently in play `highestPlayedCard`.
        * If `highestOwnCard` has a lower rank than `highestPlayedCard`, then return `highestOwnCard`.
        * Otherwise, return the lowest ranked card in the computer's hand that matches the trump suit.
    * If there is no trump suit yet, or the computer does not have a card matching the trump suit, return the first card in their hand.
    * Examples and notes:
        * A trump suit is the suit of the first card played 
        * If the computer is holding the hand `C3,C4,C5,H5` and the only card played so far was a `C2`, then `computerPlays` should return `C3`
        * If the card played in the above case was a `C7`, then `computerPlays` should return `C5`
        * Note that the examples above use the String representations of Hands and Cards, *do **not** make your `computerPlays` return a String*.

## Task Two - MockHeartsTest - Easy
You will now use test-driven development and mocking to test and implement methods for human players to swap cards at the start of a round of Hearts.

You will start by creating tests for the `Hearts` methods `requestHumanSwapCards` and `humanSwapsCards`.

In `src\test\java\card\game\hearts\MockHeartsTest.java`:
* Create the following tests (remember to use the `@Test` annotation):
    * `testRequestHumanSwapCards`
        * Mock `mockScanner.nextLine` to return `"DK,DQ,D3"`
        * Call `requestHumanSwapCards` and assert that it returns the specified cards
    * `testHumanSwapsCardsTwice`
        * Create a `Hand computerHand` variable with the list of cards `"C2,C3,C4"`
        * Mock `mockScanner.nextLine` to first return `"DK,D3,D8"` (note that `hand` does not contain a `"D8"`), then `"DQ"`
        * Call `humanSwapCards(hand, computerHand)` and assert it returns `"DK, D3, DQ"`
    * `testSwapCards`
        * Call `initiatePlayers(4, "Derek")`
        * Give the user the `hand` as their Hand
        * Give the player index 1 (the first computer player) the hand `"DA,D2,H3,D4,D5,D6,D7,D8,D9,D10,DJ,DQ,DK"`
        * Mock `mockScanner.nextLine` to return `"DK,D3,DQ"`
        * Call `hearts.swapCards(1)`
        * Assert that player at index 1 has 13 cards
    * Create a further four tests for `determineScore`
        * Keep in mind that in Hearts, each card in the Hearts suit is worth 1 point, and the Queen of Spades is worth 13
* Take care with where you use spaces for your method calls and asserts
* Most of the above tests will fail because `requestHumanSwapCards` and `humanSwapsCards` are unimplemented and return `null`, this will be fixed in the next Task

## Task Three - Hearts - Hard
Your next task is to implement the methods you created tests for.

In `src\main\java\card\game\hearts\Hearts.java`:
* First, implement the `requestHumanSwapCards` method which:
    * Asks a user to give a list of cards they'd like to swap, by going through the following rough steps:
        * Takes in the user's hand and a number of cards to swap as parameters
        * Print the user's cards
        * Ask the user to pick the given number of cards by listing them
        * Repeat the above two steps up to a maximum of 3 (make this a constant!) times if the user input is not a valid series of cards
            * Note: in this method you do not need to check if the user actually has these cards or if the user has given the correct number of cards. These values are only used to present information to the user
        * Return a `Hand` object based on the user input if it was correct, or null otherwise
    * Passes the first three tests you wrote
* Next, implement the `humanSwapsCards` method which:
    * Uses `requestHumanSwapCards` to request a player to give a certain number of cards to swap (based on the `NUMBER_OF_CARDS_TO_SWAP` constant) and attempts to swap these cards with a given list of cards a computer player has already selected for swapping
    * Should follow the below rough steps:
        * Take in the user's hand and a computer player's hand as parameters
        * While the given number of swaps hasn't happened and a maximum number of requests to swap hasn't been reached (3, just like the other method you implemented)
            * Ask the user to specify the cards they'd like to swap using `requestHumanSwapCards`
            * For any cards that are actually in the user's hand, they should be removed from that hand and kept track of
                * Hint: `Hand` has a method for doing this
            * Change how many cards still need to be swapped and increment the loop counter as appropriate
        * Add to the user's hand the cards the computer player chose to swap
        * Return a `Hand` object of the valid cards the player selected and chose to swap
    * Passes the tests you implemented previously
* Note that implementing these methods may require using or adding new variables or constants to the `Hearts` class
* Hint: There are many methods in `Hand`, `Game`, and `CardGame` that can make implementing these methods easier

## NO PAIR PROGRAMMING

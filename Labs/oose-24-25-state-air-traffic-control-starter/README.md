# State Design Pattern
## Version
* Initial - Derek Somerville - 7th March 2025
## Task One - Traffic Light - Easy
`src/main/java/traffic_light`

You will change the traffic light flow to: Red -> Blue -> Green -> Amber -> Red, by fully implementing a new traffic light colour: Blue.
* See [video](https://mediaspace.gla.ac.uk/media/State+Traffic+Light+-+Blue/1_s2y1ss30) ~ 3 minutes 
* Add a Blue colour to `LightColour.java`.
* Create a `BlueState.java` that implements `ColourState.java`
    * Create a constructor for BlueState which is passed a parameter of `TrafficLight`
    * Create `getColour` to return the correct value from the `LightColour` enumerator
    * Create a `setState` that changes to `GreenState` when called
* Amend `RedState.setState` so that it sets to `BlueState`
## Air Traffic Control
`src/main/java/air_traffic_control`

You will now implement an Air Traffic Control system with AirCraft that utilises the State Design Pattern for takeoff and landing.
Each step of these processes will be defined in `AirCraftStage` and be implemented via a State class that extends `AirCraftState`.
The `setState` method of each State associated with a stage of the takeoff/landing process will progress the air craft to the next stage and State.

## Task Two Climb Out - Easy
* Create `ClimbOutState.java`
    * The class should extend `AirCraftState`
    * The constructor should be passed in an `AirCraft` and set `AirCraftStage` appropriately
* `AirDistanceState.setState` should call airCraft.setState to set to a `new ClimbOutState` instance
## Task Three - Cruise - Easy
* Create `CruiseState.java` 
    * The class should extend `AirCraftState`
    * The constructor should be passed in an `AirCraft` and set `AirCraftStage` appropriately
    * The class should have two constants defined:
        * An integer which specifies the distance at which an `AirCraft` can land, with a value of 50
        * An integer which specifies the speed of an `AirCraft` in the cruising state, also with a value of 50
    * The class should implement an override for setState which does the following:
        * if `airCraft.distanceToTravel` is within the landing distance (inclusive) then transition to `LandState`
        * otherwise decrement airCraft.distanceToTravel by the cruising speed and set the state to a `new CruiseState`
        * Hint: check and use the methods in `AirCraft`
    * Override `ClimbOutState.java` setState method to proceed to cruise state.
## Task Four - Land - Medium
So far we have been creating states in a way that whenever a new state is reached a new instance of the relevant class is created.
While it is unlikely to cause issues, we could make the code run more efficiently by using the Singleton pattern.
As such, for the `LandState` you will utilise the Singleton pattern as well so that only one instance of the State exists at any given time.
* Create `LandState.java`
    * The class should extend `AirCraftState`
    * The class should implement an override for `setState` which simply prints out "Finished"
    * The constructor should be passed in an `AirCraft` and set `AirCraftStage` appropriately
* Modify `LandState` such that it implements the Singleton pattern:
    * Create a static `LandState` field which keeps track of the single, unique instance of LandState you will be working with
    * Create a static `getInstance` method which:
        * Takes in an `AirCraft` as a parameter
        * If there is no unique instance yet, instantiates one using the given `AirCraft`
        * sets the `airCraft` field of the unique instance to the given `AirCraft`
        * returns the unique instance
* Amend `CruiseState` to use `LandState.getInstance` instead of creating a new instance when transitioning to `LandState`
## Task Five - Check your work so far - Very Easy
* Run `AirTrafficControl.main` to check you get the following for the first plane:
    * Henry PARKED
    * Henry GO_TO_RUNWAY
    * Henry GROUND_ROLL
    * Henry AIR_DISTANCE
    * Henry CLIMB_OUT
    * Henry CRUISE
    * Henry LAND
    * Finished
## Task Six - Helicopter - Easy
You've implemented states, now you will implement a new vehicle that can use them.
* Create a `Helicopter.java` AirCraft that can have states
* `Helicopter.getFirstState` should return `AirDistanceState`
## Task Seven - Factory and Air Traffic Control - Medium
Creating air craft then adding them to the system is repetitive, so you will now use the Factory Design Pattern to simplify this process.
* Create `AirCraftFactory.java` with a single method, createAirCraft based on the FactoryDesignPattern, which:
    * is passed an `AirCraftType`, a name, and a distance to travel
    * makes a new `AirCraft` of the appropriate AirCraftType and AirCraft subclass
    * returns this new `AirCraft`
* Amend `AirTrafficControl` to use the new factory class and method you created:
    * Create a new `AirCraftFactory` field and initialise it
    * Create a new `add` method which:
        * takes `AirCraftType`, name, and distance to travel as parameters
        * calls the `createAirCraft` factory method to create an air craft
        * adds the newly created aircraft using the other `add` method
## Task Eight - Air Traffic Control - Easy
Now write some code to check that your changes in Task Seven work.
* Amend `AirTrafficControl.main` to add a Helicopter and an `AirLiner` using the new `AirTrafficControl`. Add method you created in Task Seven.
* When you run your new main, the AirLiner should behave similarly to Henry the Plane, however your Helicopter should go from the `PARKED` to the `AIR_DISTANCE` state at which point it should behave similarly as the other two air craft.


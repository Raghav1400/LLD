

**Problem**
* A parking lot is an area where cars can be parked for a certain amount of time.
* A parking lot can have multiple floors with each floor having a different number of slots and each slot being suitable for different types of vehicles.


**Requirements**
* 1. functional requirements :They are the requirements stated by the user which one can see directly in the final product.
* 2. non-functional requirements :These are the quality constraints that the system must satisfy according to the project contract.

**Functional requirements**
* 1. parking lot has many floors
* 2. can park different types of vehicle, e.g.: type1, type2, type3
* 3. charge money according to time vehicle parked
* 4. has many in and out gates

**Entities**
1. Parking lot
2. vehicles --> different type
3. Parking floor

**Entities relationship**
1. parking lot has parking floor
2. different types of slots and vehicles have is a relation with parent classes

functionalities
1. parking lot can register a vehicle to a slot
2. unregister a vehicle
3. 
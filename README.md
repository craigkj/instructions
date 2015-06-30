Installation
============

```git clone git@github.com:craigkj/instructions.git```
or
```git clone https://github.com/craigkj/instructions.git```
or download the file as a zip at https://github.com/craigkj/instructions

Running the app
---------------

The app uses gradle for project/dependency management, so once you have cloned the repo you should just be able to run:

```gradle build```

as the repo should contain everything that it needs to run.

Running the tests
-----------------

Tests are built using Junit and can also be run via gradle:

```gradle test```

(Can be found in:
src/test/java/instructions/InstructionQueueTest.java)


Dev Notes
---------

1. **Composition over inheritance**
InstructionQueue contains an instance (is composed) of a priorityQueue as we want to make use of much of its functionality (namely the sorting) however we dont want to expose all of the functionality that comes with a priority queue (as that would include duplicating validation across both add and offer methods). This also gives us more control over the interface that we expose on the InstructionQueue

2. **Few comments?**
I subscribe heavilly to the idea of self documenting code. Code comments tend not to get maintained very well and thus can actually be harmful rather than helpful, also this is a fairly simple example and all methods should be self explanatory.

3. **Instruction Queue Priority**
The instruction priorities have a map to 'low, medium and high' priorities, however this just maps to numeric sorting so the map has been omitted for simplicity. This could have been implemented as an enum if required for reference.

4. **Project Structure**
I also like to keep projects simple until complexity is required, hence no sub directories for 'models' or 'exceptions' which you might normally see (particularly in mvc of mvvm architecture).

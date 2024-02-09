# Bonus
Great, you're making good progress! Feel free to work on this voluntary bonus task as well. What is it about? The client would like to have a guest list that includes the names of all guests.

To prevent the list from getting lost, it should be saved in a text file and also read from it. This task will be presented to you in the form of test cases. First, write the test, then the implementation. Only proceed to the next test when all previous tests are passing.

## Test 1: Write a test shouldBeEmptyInitially that

1. creates an instance of the GuestList class
2. calls the setGuests method with an empty list
3. then calls getGuests (the result should be a list of strings)
4. and checks that the result is an empty list

## Test 2: Write a test shouldReadSameGuestsAsWrittenBefore that

1. creates an instance of the GuestList class
2. calls the setGuests method with "Karl" and "Ute"
3. then calls getGuests (the result should be a list of strings)
4. and checks that the result contains "Karl" and "Ute"

## Test 3: Write a test shouldWriteToFileSystem that

1. creates an instance of the GuestList class
2. calls the setGuests method with "Theodor" and "Anette"
3. and checks that the file guests.txt has been created and contains the lines "Theodor" and "Anette" Hint: Define the file path with Path.of("guests.txt") Hint: Read and write using the java.nio.file.Files class

## Test 4: Write a test shouldReadFromFileSystem that

1. writes "Stephan" and "Max" (as lines) to the file guests.txt
2. creates an instance of the GuestList class
3. then calls getGuests
4. and checks that "Stephan" and "Max" have been read Hint: Define the file path with Path.of("guests.txt") Hint: Read and write using the java.nio.file.Files class

## Test 5: Write a test that checks if an exception occurs when reading the file that does not exist

## Test 6: Add an addGuest method that takes a string guest as a parameter and writes it as an additional line to the file.

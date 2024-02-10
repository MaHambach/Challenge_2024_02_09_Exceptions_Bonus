import com.github.mahambach.GuestList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestGuestList {

    @Test
    void shouldBeEmptyHere() {
        GuestList guestList = new GuestList();
        guestList.setGuests(new ArrayList<>());

        List<String> guests = guestList.getGuests();

        assertTrue(guests.isEmpty());
    }

    @Test
    void shouldReadSameGuestsAsWrittenBefore(){
        GuestList guestList = new GuestList();
        guestList.setGuests(List.of("Karl", "Ute"));

        List<String> actualGuests = guestList.getGuests();

        assertEquals(List.of("Karl", "Ute"), actualGuests);
    }

    @Test
    void shouldWriteToFileSystem() {
        GuestList guestList = new GuestList();
        guestList.setGuests(List.of("Theodor", "Anette"));

        guestList.writeToFile("guests.txt");

        List<String> actualGuests = new ArrayList<>();
        Path path = Paths.get("guests.txt");
        try {
            List<String> names = Files.readAllLines(path);
            actualGuests.addAll(names);
        } catch (IOException e) {
            fail();
        }

        assertEquals(List.of("Theodor", "Anette"), actualGuests);
    }

    @Test
    void shouldReadFromFileSystem() {
        GuestList guestList = new GuestList();
        List<String> expectedGuests = List.of("Stephan", "Max");
        Path path = Paths.get("guests.txt");
        try {
            Files.write(path, List.of("Stephan", "Max"));

            guestList.writeToFile("guests.txt");

            guestList.readFromFile("guests.txt");

            assertEquals(expectedGuests, guestList.getGuests());
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    void shouldThrowExceptionWhenReadingNonExistingFile() {
        GuestList guestList = new GuestList();

        assertThrows(IOException.class, () -> guestList.readFromFile("non-existing-file.txt"));
    }
}

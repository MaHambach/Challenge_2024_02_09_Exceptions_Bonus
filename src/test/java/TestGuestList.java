import com.github.mahambach.GuestList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        List<String> actualGuests = guestList.readFromFile("guests.txt");

        assertEquals(List.of("Theodor", "Anette"), actualGuests);
    }
}

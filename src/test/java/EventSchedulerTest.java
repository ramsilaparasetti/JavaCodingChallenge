import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class EventSchedulerTest {


    private EventScheduler eScheduler;


    private Event event1 = new Event("E1", "Music", "London", setDate(5));
    private Event event2 = new Event("E2", "Dance", "Birmingham", setDate(10));
    private Event event3 = new Event("E3", "Rap", "Cardiff", setDate(5));
    private Event event4 = new Event("E4", "Classical", "Bristol", setDate(2));
    private Event event5 = new Event("E5", "HipHop", "Nottingham", setDate(1));


    @Before
    public void setup() {
        eScheduler = new EventScheduler();
        eScheduler.addEvent(event1);
        eScheduler.addEvent(event2);
    }



    @Test
    public void test_addEvent_addsEvent_givenNewEvent() {
        eScheduler.addEvent(event3);
        assertEquals(3, eScheduler.getEvents().size());
    }

    @Test
    public void test_addEvent_throwsException_givenExistingEvent() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> eScheduler.addEvent(event2));
        String expectedMessage = "Event already exist";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void test_removeEvent_removesEvent_givenExistingEvent() {
        eScheduler.removeEvent("E1");
        assertEquals(1, eScheduler.getEvents().size());
    }

    @Test
    public void test_removeEvent_throwsException_givenInvalidEvent() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> eScheduler.removeEvent("E4"));
        String expectedMessage = "Event does not exist";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void test_getEventsAtTime_returnsEvents_givenTime() {
        eScheduler.addEvent(event3);
        assertEquals(2, eScheduler.getEventsAtTime(setDate(5)).size());
    }

    @Test
    public void test_getEventsAtTime_throwsException_whenNoEventExistsForGivenDate() {
        eScheduler.addEvent(event3);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> eScheduler.getEventsAtTime(setDate(15)));
        String expectedMessage = "No events for given date";
        assertEquals(expectedMessage, exception.getMessage());
    }

    private Date setDate(int daysToAdd){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
        Date date = calendar.getTime();
        return date;
    }
}
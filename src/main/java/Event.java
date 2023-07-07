//Simple Event Scheduling System:
// Design a system for scheduling events.
// Implement an Event class with fields like eventId, title, location, and time.
// Implement an EventScheduler class which manages a list of Event objects.
// The EventScheduler class should have methods like addEvent(Event event), removeEvent(String eventId), getEventsAtTime(Date time).
// Implement appropriate exceptions and error handling. Write tests to verify your solution.


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {

    private String eventId;
    private String title;
    private String location;
    private Date time;

    public String getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public Date getTime() {
        return time;
    }

    public Event(String eventId, String title, String location, Date time) {
        if(eventId == null){
            throw new IllegalArgumentException("Event Id cannot be null");
        }
        this.eventId = eventId;
        this.title = title;
        this.location = location;
        this.time = time;
    }
}

class EventScheduler {

    private List<Event> events;

    public EventScheduler() {
        this.events = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

//    addEvent(Event event), removeEvent(String eventId), getEventsAtTime(Date time)
    public void addEvent(Event event){
        if(events.contains(event)){
            throw new IllegalArgumentException("Event already exist");
        }
        else{
            events.add(event);
        }
    }

    public void removeEvent(String eventId) {
        boolean eventExistsFlag = false;
        for(Event event:events){
            if(event.getEventId().equals(eventId)){
                events.remove(event);
                eventExistsFlag = true;
                break;
            }
        }
        if (!eventExistsFlag){
            throw new IllegalArgumentException("Event does not exist");
        }
    }

    public List<Event> getEventsAtTime(Date time){
        boolean eventExistsFlag = false;
        List<Event> eventsToReturn = new ArrayList<>();
        for(Event event:events){
            if(event.getTime().equals(time)){
                eventsToReturn.add(event);
                eventExistsFlag = true;
            }
        }
        if (!eventExistsFlag){
            throw new IllegalArgumentException("No events for given date");
        }
    return eventsToReturn;
    }
}

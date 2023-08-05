import java.time.LocalDateTime;

public class Event {
    private int id;
    private String name;
    private String description;
    private LocalDateTime timeCreated;
    private LocalDateTime timeOfEvent;
    private String location;
    private ArrayList<Reminder> remindList;

    public Event(int id, String name, String description, LocalDateTime timeCreated, LocalDateTime timeOfEvent, String location, ArrayList<Reminder> remindList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timeCreated = timeCreated;
        this.timeOfEvent = timeOfEvent;
        this.location = location;
        this.remindList = remindList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDateTime getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(LocalDateTime timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Reminder> getRemindList() {
        return remindList;
    }

    public void setRemindList(ArrayList<Reminder> remindList) {
        this.remindList = remindList;
    }
}

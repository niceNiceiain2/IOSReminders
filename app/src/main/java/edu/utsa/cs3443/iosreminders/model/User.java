import java.util.ArrayList;



public class User {
    private int userId;             // Unique identifier for the user
    private String username;       // Username of the user
    private String email;          // Email address of the user
    private String password;       // Password of the user
    private ArrayList<Event> eventList; // List to store the user's events 
    private MenuView menuView;     // Reference to the user's MenuView 

    
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.eventList = new ArrayList<>(); // The eventList as an empty ArrayList

    }

    // Getter for userId
    public int getUserID() {
        return userId;
    }

    // Getter for username
    public String getName() {
        return username;
    }

    // Setter for username
    public void setName(String username) {
        this.username = username;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }



    // Method to add an event to the user's eventList
    public void addEvent(Event event) {

        eventList.add(event);
    }

    // Method to remove an event from the user's eventList
    public void removeEvent(Event event) {

        eventList.remove(event);
    }

    // Method to get the user's eventList
    public ArrayList<Event> getEventList() {

        return eventList;
    }

 

    // Method to associate a MenuView object with the user 
    public void setMenuView(MenuView menuView) {

        this.menuView = menuView;
    }

    // Method to get the associated MenuView object 
    public MenuView getMenuView() {

        return menuView;
    }

    // There is a separate Event class
    class Event {
    // Event class properties and methods
    // ...
  }

  // There is a separate MenuView class
    class MenuView {
      // MenuView class properties and methods
    // ...
    }
}
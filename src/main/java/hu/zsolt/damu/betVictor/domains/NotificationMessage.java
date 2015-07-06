package hu.zsolt.damu.betVictor.domains;


/**
 * Created by TamasZsolt on 01/07/2015.
 */

public class NotificationMessage {

    private String message;

    public NotificationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

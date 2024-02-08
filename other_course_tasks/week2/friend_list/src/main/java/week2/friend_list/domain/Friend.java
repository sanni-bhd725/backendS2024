package week2.friend_list.domain;

public class Friend {

    public String firstName, lastName;

    public Friend() {
    }

    public Friend(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Friend [firstName=" + firstName + ", lastName=" + lastName + "]";
    }

}

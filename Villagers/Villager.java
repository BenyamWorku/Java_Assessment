package Villagers;


public abstract class Villager {

    String FirstName;
    String LastName;
    int Age;

    public Villager(String firstName, String lastName, int age) {
        FirstName=firstName;
        LastName=lastName;
        Age=age;
    }

    public String getFirstName(){
        return FirstName;
    }
    
    public String getLastName(){
        return LastName;
    }

    public int getAge() {
        return Age;
    }

    public void setFirstName(String firstName) {
        FirstName=firstName;
    }

    public void setLastName(String lastName) {
        LastName=lastName;
    }

    public void setAge(int age) {
        Age=age;
    }

    public abstract void print();
}

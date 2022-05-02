/**
 * Class for generic sports player can be inherited as base class for all types of sports player
 */
public abstract class SportsPlayer {

    protected String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String leftOrRightHanded;
    private String leftOrRightFooted;

    /**
     * Constructor for sports player.
     * @param firstName the players first name.
     * @param lastName the players last name.
     * @param age the players age.
     * @param gender the players gender.
     * @param leftOrRightHanded is the player left or right handed.
     * @param leftOrRightFooted is the player left or right footed.
     */
    public SportsPlayer(String firstName, String lastName, int age, String gender, String leftOrRightHanded, String leftOrRightFooted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.leftOrRightHanded = leftOrRightHanded;
        this.leftOrRightFooted = leftOrRightFooted;
    }

    /**
     * Constructor for all sports that don't require left or right footed.
     * @param firstName the players first name.
     * @param lastName the players last name.
     * @param age the players age.
     * @param gender the players gender.
     * @param leftOrRightHanded is the player left or right handed.
     */
    public SportsPlayer(String firstName, String lastName, int age, String gender, String leftOrRightHanded) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.leftOrRightHanded = leftOrRightHanded;
    }

    /***
     * Gets sports players first name.
     * @return Sports players first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets sports players first name.
     * @param firstName Sports players last name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets sports players last name.
     * @return Sports players last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets sports players last name.
     * @param lastName Sports players last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets sports players full name.
     * @return Sports players full name formatted.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Gets sports players age.
     * @return Sports players age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets sports players age.
     * @param age Sports players age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets sports players gender.
     * @return Sports players gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets sports players gender.
     * @param gender Sports players gender.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets whether sports player is left or right handed.
     * @return left or right handed.
     */
    public String getLeftOrRightHanded() {
        return leftOrRightHanded;
    }

    /**
     * Sets whether sports player is left or right handed.
     * @param leftOrRightHanded left or right handed.
     */
    public void setLeftOrRightHanded(String leftOrRightHanded) {
        this.leftOrRightHanded = leftOrRightHanded;
    }

    /**
     * Gets whether sports player is left or right footed.
     * @return left or right footed.
     */
    public String getLeftOrRightFooted() {
        return leftOrRightFooted;
    }

    /**
     * Sets whether sports player is left or right footed.
     * @param leftOrRightFooted left or right footed.
     */
    public void setLeftOrRightFooted(String leftOrRightFooted) {
        this.leftOrRightFooted = leftOrRightFooted;
    }

}

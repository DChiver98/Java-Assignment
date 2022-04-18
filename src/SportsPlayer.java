public abstract class SportsPlayer {

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String leftOrRightHanded;
    private String leftOrRightFooted;

    public SportsPlayer(String firstName, String lastName, int age, String gender, String leftOrRightHanded, String leftOrRightFooted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.leftOrRightHanded = leftOrRightHanded;
        this.leftOrRightFooted = leftOrRightFooted;
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

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLeftOrRightHanded() {
        return leftOrRightHanded;
    }

    public void setLeftOrRightHanded(String leftOrRightHanded) {
        this.leftOrRightHanded = leftOrRightHanded;
    }

    public String getLeftOrRightFooted() {
        return leftOrRightFooted;
    }

    public void setLeftOrRightFooted(String leftOrRightFooted) {
        this.leftOrRightFooted = leftOrRightFooted;
    }
}

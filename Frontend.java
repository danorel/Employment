import java.io.*;
import java.util.ArrayList;

public class Frontend implements Employee, Serializable{
    /*
        Instances of the class Frontend.
        Name, surname, age, salary, success of the Front-end Programmer.
     */
    private transient String path;

    private ArrayList<String> FrontendTeam = new ArrayList<String>();
    //
    private int fID;
    private String name;
    private String surname;
    private int age;
    private int salary;

    // Success level
    private char[] success = new char[5];
    private int currentStar;
    // If success level = MAX, 5 star level, that you can be promoted to Team leader.
    private boolean isTeamLeader;

    /*
        Constructor with no parameters.
     */
    public Frontend(){
        this.fID = 0;
        this.name = null;
        this.surname = null;
    }
    /*
        Constructor with parameters person's name, surname and Id.
     */
    public Frontend(String features, int fId){
        this.fID = fId;
        String []person = features.split(" ");
        this.name = person[0];
        this.surname = person[1];
        this.age = Integer.parseInt(person[2]);
        this.FrontendTeam.add(this.name);
    }

    @Override
    public String getSuccessLevel() {
        int counter = 0;
        String stars = "";
        while(this.success.length != counter){
            stars += this.success[counter];
            counter++;
        }
        return stars;
    }

    @Override
    public void saveEmployee(Employee employee) {
        try{
            File directory = new File("Data");
            directory.mkdir();
            this.path = directory.getPath() + "/";
            FileOutputStream FOS = new FileOutputStream(this.path + "Frontend.ser");
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(employee);
            OOS.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void recoverEmployee() {
        try {
            FileInputStream FIS = new FileInputStream(this.path + "Frontend.ser");
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            Object emp = OIS.readObject();
            Frontend employee = (Frontend) emp;
            OIS.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void voteForLeader() {

    }

    @Override
    public void doTask() {
        int success = (int)(Math.random());
        if(success == 1){
            this.success[currentStar] = '*';
            this.currentStar++;
        } else {
            this.success[currentStar] = ' ';
            this.currentStar--;
        }
    }
}

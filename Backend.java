import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

public class Backend implements Employee, Serializable {
    /*
        Instances of the class Backend.
     */
    private transient String path;
    private transient String filename = "Backend.ser";

    private ArrayList<String> BackendTeam = new ArrayList<String>();
    private int bID;
    private String name;
    private String surname;
    private int age;
    private int salary;

    // Success level
    private Stack<Character> success = new Stack();
    private int currentStar;
    // If success level = MAX, 5 star level, that you can be promoted to Team leader.
    private boolean isTeamLeader;

    public Backend(String features, int bId) {
        String[] person = features.split(" ");
        this.name = person[0];
        this.surname = person[1];
        this.age = Integer.parseInt(person[2]);
    }

    @Override
    public String getSuccessLevel() {
        int counter = 0;
        String stars = "";
        while(this.success.size() != counter){
            this.success.push('*');
            stars += this.success.add('*');
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
            FileOutputStream FOS = new FileOutputStream(this.path + this.filename);
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(employee);
            OOS.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void recoverEmployee() {
        try{
            FileInputStream FIS = new FileInputStream(this.path + this.filename);
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            Object emp = OIS.readObject();
            Backend employment = (Backend) emp;
            OIS.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void voteForLeader() {

    }

    @Override
    public void doTask() {
        int success = (int)(Math.random() * 2);
        if(success == 2){
            this.success.push('*');
            this.success.push('*');
        } else if(success == 1) {
            this.success.push('*');
        } else {
            if(!this.success.empty()){
                this.success.pop();
            }
        }
    }

    private void checkStars(){

    }
}

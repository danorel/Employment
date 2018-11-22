import sun.security.krb5.internal.crypto.Des;

import java.io.*;
import java.util.ArrayList;
public class Designer implements Employee, Serializable {
    /*
        Instances of the class Designer.
     */
    private transient String path;

    private ArrayList<Designer> DesignerTeam = new ArrayList<Designer>();
    private int bID;
    private String name;
    private String surname;
    private int age;
    private int salary;

    // Success level
    private char[] success = new char[5];
    private int currentStar;
    // If success level = MAX, 5 star level, that you can be promoted to Team leader.
    private boolean isTeamLeader;

    public Designer(){
        this.bID = 0;
        this.name = null;
        this.surname = null;
        this.isTeamLeader = false;
    }
    /*
        Constructor with parameters person's name, surname and Id.
     */
    public Designer(String features, int bId){
        this.bID = bId;
        String []person = features.split(" ");
        this.name = person[0];
        this.surname = person[1];
        this.age = Integer.parseInt(person[2]);
        this.isTeamLeader = false;
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
            FileOutputStream FOS = new FileOutputStream(this.path + "Designer.ser");
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(employee);
            OOS.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void recoverEmployee() {
        try {
            FileInputStream FIS = new FileInputStream(this.path + "Designer.ser");
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            Object emp = OIS.readObject();
            Designer employee = (Designer) emp;
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

    }

    private void showListOfCandidates(){
        int counter = 0;
        for(Designer designer : DesignerTeam){
            if(designer.currentStar == 5){
                System.out.println(designer.name + " " + designer.surname);
            }
        }
    }
}

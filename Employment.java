import java.util.*;
import java.lang.*;

public class Employment {

    public static void main(String[] args) {
//        ArrayList<Employee> employees = new ArrayList<>();
//        ArrayList<Frontend> frontendStaff = new ArrayList<>();
//        ArrayList<Backend> backendStaff = new ArrayList<>();
//        ArrayList<Designer> designerStaff = new ArrayList<>();
//        frontendStaff.add(new Frontend("Daniel Orel 17", 1));
//        frontendStaff.add(new Frontend("Sasha Mironovich 17", 2));
//        employees.add(frontendStaff.get(0));
//        employees.add(frontendStaff.get(1));
//        for(Employee emp: employees){
//            System.out.println(emp.callEmployee());
//        }

        ArrayList<Employee> staff = new ArrayList<>();
        ArrayList<Designer> designers = new ArrayList<>();
        ArrayList<Frontend> frontends = new ArrayList<>();
        ArrayList<Backend> backends = new ArrayList<>();
        designers.add(new Designer("Daniel Orel 17", 1));
        designers.add(new Designer("Den Kurochkin 20", 2));
        frontends.add(new Frontend("Sasha Mironovich 17", 1));
        backends.add(new Backend("Dan Merejko 17", 1));

        for(int times = 0; times < 5; times++){
            backends.get(0).doTask();
        }
        System.out.println(backends.get(0).getSuccessLevel());

        backends.get(0).saveEmployee(backends.get(0));

        for(Employee empls : staff){
            empls.saveEmployee(empls);
        }
    }
}
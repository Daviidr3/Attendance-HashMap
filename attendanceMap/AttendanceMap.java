package attendanceMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author David Vasquez
 *
 * Assignment 1.
 *
 * This program implements a Map that stores Employee objects and tracks
 * attendance.
 *
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class AttendanceMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //begin processing .txt file
        readFile();

    }

    /**
     * Reads the file and creates employee objects to store in HashMap.
     */
    private static void readFile() {
        //creating path and inicializing HashMap.
        String filePath = "src/attendanceMap/employee.txt";
        HashMap<Employee, Integer> attendance = new HashMap<>();

        /**
         * Try catch to begin reading file.
         */
        try {
            //creating buffered reader to read file.
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;

            //loop through each line of file.
            while ((line = br.readLine()) != null) {

                //Read lines into an array and spliting values at each ",".
                String[] values = (line.split(","));

                String employeeId = values[0];

                String firstName = values[1];

                String lastName = values[2];

                //casting String to double.
                double salary = Double.parseDouble(values[3]);

                //Creating employee object.
                Employee person = new Employee(employeeId, firstName, lastName.trim(), salary);

                //Calling helper to map Employee to attendance HashMap.
                attendanceMap(person, attendance);

            }

        } catch (IOException e) {
            //catch exception for no file.
            System.out.println(e);
        }
        //Open menu.
        menu(attendance);
    }

    /**
     * Displays menu for user.
     *
     * @param attendance HashMap.
     */
    private static void menu(HashMap<Employee, Integer> attendance) {
        //inicializing Scanner to take input.
        Scanner in = new Scanner(System.in);

        //boolean to continue menu looping.
        boolean menuTerminate = false;

        //menu displays.
        while (menuTerminate != true) {

            System.out.println("To continue please select one of the following menu options.");
            //menu print.
            System.out.println("\t 1.) Display");
            System.out.println("\t 2.) Add an Employee");
            System.out.println("\t 3.) Search");
            System.out.println("\t 0.) Exit");

            System.out.println("");
            //menu option selection.
            int menuOption = in.nextInt();

            //menu options.
            switch (menuOption) {
                case 1:
                    //Menu option 1, displaces HashMap.
                    printMap(attendance);
                    break;
                case 2:
                    //menu option 2, allows the entry of a new Employee.
                    addEmployee(attendance);
                    break;
                case 3:
                    //menu option 3, searches for employee by taking their id.
                    employeeSearch(attendance);
                    break;
                case 0:
                    //menu exit.
                    menuTerminate = true;
                    break;
                default:
                    //if invalid option is inputted.
                    System.out.println("Enter a valid option!");
                    break;
            }
            System.out.println("");
        }

    }

    /**
     * Maps Employee object to track attendance.
     *
     * @param person Employee.
     * @param attendance HashMap.
     */
    private static void attendanceMap(Employee person, HashMap<Employee, Integer> attendance) {
        //check if employee key already exist.
        if (attendance.containsKey(person)) {
            //increament attendance.
            attendance.put(person, attendance.get(person) + 1);
        } else {
            //insert if new element.
            attendance.put(person, 1);
        }

    }

    /**
     * Search's HashMap for Employee Key.
     *
     * @param attendance HashMap.
     */
    public static void employeeSearch(HashMap<Employee, Integer> attendance) {
        //inicialize Scanner.
        Scanner in = new Scanner(System.in);

        //take in id to search.
        System.out.println("Enter Employee ID of staff being searched.");
        String id = in.next();

        //create a employee key with the id that is being looked for.
        Employee key = new Employee(id, "", "", 0.0);

        //check if the key exists.
        if (attendance.containsKey(key)) {

            Iterator<Employee> iterator = attendance.keySet().iterator();
            System.out.print("Employee found: ");

            //loop through the keySet until the employee is found and print.
            while (iterator.hasNext()) {

                Employee person = iterator.next();

                if (person.equals(key)) {

                    System.out.print(person);
                }

            }

        } else {

            //if employee is not found.
            System.out.println("Employee does not exist.");
        }
        System.out.println("");
    }

    /**
     * Allows an employee object to be added into HashMap.
     *
     * @param attendance HashMap.
     */
    private static void addEmployee(HashMap<Employee, Integer> attendance) {
        Scanner in = new Scanner(System.in);

        //collect employee information.
        System.out.println("Enter Employee ID.");
        String employeeId = in.next();

        System.out.println("Enter first name.");
        String firstName = in.next();

        System.out.println("Enter last name.");
        String lastName = in.next();

        System.out.println("Enter salary.");
        double salary = in.nextDouble();

        //create the new employee
        Employee employee = new Employee(employeeId, firstName, lastName, salary);

        //helper method to insert into HashMap.
        attendanceMap(employee, attendance);

    }

    /**
     * Displays map in tabular format.
     *
     * @param attendance HashMap.
     */
    private static void printMap(HashMap<Employee, Integer> attendance) {

        //print fields for employee.
        System.out.println("EMPLOYEE ID    |    FIRST NAME    |    LAST NAME    |    SALARY    |   ATTENDANCE|");

        System.out.println("_________________________________________________________________________________|");

        //print employee keys and integer values.
        for (Employee key : attendance.keySet()) {
            System.out.print(key + " |   ");
            System.out.print(attendance.get(key));

            System.out.println("");
            System.out.println("_________________________________________________________________________________|");
        }

    }
}

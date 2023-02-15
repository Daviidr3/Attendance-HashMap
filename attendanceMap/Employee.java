package attendanceMap;

import java.util.Objects;

/**
 *
 * @author David Vasquez.
 *
 * Employee object class.
 *
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class Employee {

    //inicializing employee fields.
    protected String employeeId;
    protected String firstName;
    protected String lastName;
    protected double salary;

    /**
     * Constructor for employee object.
     *
     * Throws IAE for negative salary.
     *
     * @param employeeId employee's id.
     * @param firstName employee's first name.
     * @param lastName employee's last name.
     * @param salary employee's wages.
     */
    public Employee(String employeeId, String firstName, String lastName, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        if (this.salary < 0.0) {

            throw new IllegalArgumentException("employee cannot have a negative value");

        }
        this.salary = salary;
    }

    /**
     * Employee Id getter.
     *
     * @return employeeId String.
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Employee id setter.
     *
     * @param employeeId String.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Employee first name getter.
     *
     * @return String firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Employee first name setter.
     *
     * @param firstName String.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Employee last name setter.
     *
     * @return String lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Employee last name setter.
     *
     * @param lastName String.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Employee salary getter.
     *
     * @return double salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Employee salary setter.
     *
     * Throws IAE for negative salary.
     *
     * @param salary double.
     */
    public void setSalary(double salary) {
        if (this.salary < 0.0) {

            throw new IllegalArgumentException("employee cannot have a negative value");

        }
        this.salary = salary;
    }

    /**
     * Employee toString override.
     *
     * @return String employee.
     */
    @Override
    public String toString() {
        return "employeeId:" + employeeId + "| firstName:" + firstName + "| lastName:" + lastName + "| salary:" + salary;
    }

    /**
     * Employee hashCode override.
     *
     * @return int hashCode.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.employeeId);
        return hash;
    }

    /**
     * Equals override.
     *
     * @param obj Employee.
     * @return Boolean.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equals(this.employeeId, other.employeeId);
    }

}

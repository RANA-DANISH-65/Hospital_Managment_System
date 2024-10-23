public class Staff extends Person {
    private String jobRole;
    private double salary;

    public Staff(String name, int age, String address, String jobRole, double salary) {
        super(name, age, address);
        this.jobRole = jobRole;
        this.salary = salary;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayJobRole() {
        System.out.println("The Work: " + getJobRole());
    }

    @Override
    public String toString() {
        return super.toString() + ", Job Role=" + jobRole + ", Salary=" + salary;
    }
}

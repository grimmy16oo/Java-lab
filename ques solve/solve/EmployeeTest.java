class Employee{
    private String firstName;
    private String lastName;
    private double salary;
    private double overtimeRate;

    public Employee(String firstName,String lastName,double salary,double overtimeRate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.overtimeRate = overtimeRate;
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
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        if(salary > 0)
            this.salary = salary;
    }
    public double getOvertimeRate() {
        return overtimeRate;
    }
    public void setOvertimeRate(double overtimeRate) {
        this.overtimeRate = overtimeRate;
    }

    public double overTimeAmount(int totalOverTime)
    {
            double overtime = totalOverTime * overtimeRate;
            return overtime;
    }
    public void displayYearly()
    {
        System.out.println(12 * salary);
    }
}


class EmployeeTest
{
    public static void main(String[] args)
    {
        Employee e1 = new Employee("max","price",60000,1.5);
        Employee e2 = new Employee("sam","rocks",72000,2.0);

        e1.displayYearly();
        e2.displayYearly();

        e1.setSalary(60000 + (60000 * 10/100));
        e2.setSalary(72000 + (72000 * 10/100));

        e1.displayYearly();
        e2.displayYearly();

        e1.setOvertimeRate(0.5);;
        System.out.println(e1.getSalary() + e1.overTimeAmount(20));

        e2.setOvertimeRate(0.9);;
        System.out.println(e2.getSalary() + e2.overTimeAmount(28));

    }

}


class Student {
    private String name;
    private int rollNumber;
    private double attendancePercentage;
    private char grade;

    public Student(String name, int rollNumber)
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.attendancePercentage = 0.0;
        this.grade = 'F';
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public double getAttendancePercentage()
    {
        return attendancePercentage;
    }
    public void setAttendancePercentage(double attendancePercentage)
    {
        if(attendancePercentage >= 0 && attendancePercentage <= 100)
            this.attendancePercentage = attendancePercentage;
        else
            System.out.println("Attendance must be between 0-100");
    }
    public char getGrade()
    {
        return grade;
    }
    public void setGrade(char grade)
    {
        if(grade == 'A' || grade == 'B' || grade == 'C' || grade == 'D' || grade == 'F')
            this.grade = grade;
        else
            System.out.println("Grades must be A,B,C,D,F");
    }

    public void display()
    {
        System.out.println("Student name : " + name);
        System.out.println("Student roll : " + rollNumber);
        System.out.println("Student Attendance percentage : " + attendancePercentage);
        System.out.println("Student grade : " + grade);
    }
}

class Main{
    public static void main(String[] args)
    {
        Student s = new Student("Alice",101);
        s.setAttendancePercentage(85.0);
        s.setGrade('B');

        Student s1 = new Student("Bob", 102);
        s1.setAttendancePercentage(75.5);
        s1.setGrade('C');

        Student s2 = new Student("Sam",103);
        s2.setAttendancePercentage(92.0);
        s2.setGrade('A');

        System.out.println("/////////////Initial info/////////////");
        s.display();
        s1.display();
        s2.display();

        s.setAttendancePercentage(90.0);
        s.setGrade('A');

        s1.setAttendancePercentage(80.0);
        s1.setGrade('B');

        s2.setAttendancePercentage(100.0);
        s2.setGrade('A');

        System.out.println("/////////////Updated info/////////////");
        s.display();
        s1.display();
        s2.display();
    }
}
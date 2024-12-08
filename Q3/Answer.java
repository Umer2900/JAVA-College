class Student 
{
    private String name;
    private String ID;
    private int[] grades;
    private int gradeCount;

    // Constructor to initialize the student with name, ID, and maximum number of grades
    public Student(String name, String ID, int maxGrades) {
        this.name = name;
        this.ID = ID;
        this.grades = new int[maxGrades];
        this.gradeCount = 0;
    }

    // Method to add grades to the student
    public void addGrade(int grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount] = grade;
            gradeCount++;
        } else {
            System.out.println("Maximum number of grades reached.");
        }
    }

    // Method to calculate the average grade
    public double calculateAverageGrade() {
        int total = 0;
        for (int i = 0; i < gradeCount; i++) {
            total += grades[i];
        }
        return gradeCount == 0 ? 0 : (double) total / gradeCount;
    }

    // Method to find the highest grade
    public int findHighestGrade() {
        int highest = grades[0];
        for (int i = 1; i < gradeCount; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
        }
        return highest;
    }

    // Method to find the lowest grade
    public int findLowestGrade() {
        int lowest = grades[0];
        for (int i = 1; i < gradeCount; i++) {
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }
        return lowest;
    }

    // Method to display the grade report
    public void displayGradeReport() {
        System.out.println("Grade Report for " + name + " (ID: " + ID + "):");
        System.out.print("Grades: ");
        for (int i = 0; i < gradeCount; i++) {
            System.out.print(grades[i] + " ");
        }
        System.out.println();
        System.out.println("Average Grade: " + calculateAverageGrade());
        System.out.println("Highest Grade: " + findHighestGrade());
        System.out.println("Lowest Grade: " + findLowestGrade());
        System.out.println("----------------------------");
    }
}

class StudentGradeManagementSystem 
{
    public static void main(String[] args) 
    {
        // Create student objects and add grades
        Student student1 = new Student("Umer", "S101", 5); // Max 5 grades
        student1.addGrade(85);
        student1.addGrade(92);
        student1.addGrade(78);
        student1.addGrade(88);
        student1.addGrade(90);

        Student student2 = new Student("Ahmed", "S102", 4); // Max 4 grades
        student2.addGrade(90);
        student2.addGrade(85);
        student2.addGrade(80);
        student2.addGrade(75);

        // Display grade report for each student
        student1.displayGradeReport();
        student2.displayGradeReport();
    }
}

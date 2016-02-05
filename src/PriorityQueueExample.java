import java.util.*;

public class PriorityQueueExample
{  
    public static void main (String[ ] args)
    {
        new PriorityQueueExample().run();
    } // method main
    
    public void run()
    {
        final int DEFAULT_INITIAL_CAPACITY = 11;
        final String PROMPT1 = "Please enter student’s name and GPA, or " ;
        final String PROMPT2 = " to quit: ";
        final String SENTINEL = "***";
        final String RESULTS1 = "\nHere are the student names and GPAs, " +
            "in increasing order of GPAs:";
        final String RESULTS2 = "\nHere are the student names and GPAs, " +
            "in alphabetical order of names:";
        
        PriorityQueue<Student> pq1 = new PriorityQueue<Student>(),
                               pq2 = new PriorityQueue<Student>
                                          (DEFAULT_INITIAL_CAPACITY, new ByName());
        
        Scanner sc = new Scanner (System.in);
        
        String line;
        while (true)
        {
            System.out.print (PROMPT1 + SENTINEL + PROMPT2);
            line = sc.nextLine();
            if (line.equals (SENTINEL))
                break;
            pq1.add (new Student (line));
            pq2.add (new Student (line));
        } // while
        System.out.println (RESULTS1);
        while (!pq1.isEmpty())
            System.out.println (pq1.remove());
        System.out.println (RESULTS2);
        while (!pq2.isEmpty())
            System.out.println (pq2.remove());
    } // method run
} // class PriorityQueueExample


class Student implements Comparable<Student>
{
    protected String name;
    
    protected double gpa;
    
    /**
     * Initializes this Student object from a specified String object.
     *
     * @param s - the String object used to initialize this Student object.
     *
     */
    public Student (String s)
    {
        Scanner sc = new Scanner (s);
        name = sc.next();
        gpa = sc.nextDouble();
    } // constructor
    
    /**
     * Compares this Student object to a specified Student object by
     * grade point average.
     *
     * @param otherStudent - the specified Student object.
     *
     * @return a negative integer, 0, or a positive integer, depending
     * on whether this Student object’s grade point average is less than,
     * equal to, or greater than otherStudent’s grade point average.
     *
     */
    public int compareTo (Student otherStudent)
    {
        if (gpa < otherStudent.gpa)
            return -1;
        if (gpa > otherStudent.gpa)
            return 1;
        return 0;
    } // method compareTo
    
    /**
     * Returns a String representation of this Student object.
     *
     * @return a String representation of this Student object: name " " gpa
     *
     */
    public String toString()
    {
        return name + " " + gpa;
    } // method toString
} // class Student

class ByName implements Comparator<Student>
{
    public int compare (Student stu1, Student stu2)
    {
        String name1 = new Scanner (stu1.toString()).next(),
               name2 = new Scanner (stu2.toString()).next();
        return name1.compareTo (name2);
    } // method compare
} // class ByName
package edu.cscc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Lab10 sort the students
 * @author Brian Pawletzki
 * @version 20191029T1941
 */
public class Main {

    public static void main(String[] args) {
        Student[] students = TestData.createStudents();
        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                String lastname1 = s1.getLastName();
                String lastname2 = s2.getLastName();
                return lastname1.compareTo(lastname2);
            }
        });
        printStudentList("Students Sorted By LastName", students);

        // sort students by major
        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                String major1 = s1.getMajor();
                String major2 = s2.getMajor();
                return major1.compareTo(major2);
            }
        });
        printStudentList("Students Sorted By Major", students);

        // sort students by zip code
        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                int zipcode1 = s1.getZipcode();
                int zipcode2 = s2.getZipcode();
                //Cast as Integer to make the compareTo work
                return ((Integer)zipcode1).compareTo((Integer) zipcode2);
            }
        });
        printStudentList("Students Sorted By Zip Code", students);

        // sort students by GPA
        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                Double gpa1 = s1.getGpa();
                Double gpa2 = s2.getGpa();
                // reverse the sort by comparing gpa2 to gpa1
                return gpa2.compareTo(gpa1);
            }
        });
        printStudentList("Students Sorted By GPA", students);
    }

    public static void printStudentList(String title, Student[] list) {
        final String format = "%-12s %-12s %-18s %-12s %-12s\n";
        System.out.println(title);
        System.out.printf(format, "First Name", "Last Name", "Major", "Zip Code", "GPA");
        for (Student s : list) {
            System.out.printf(format, s.getFirstName(), s.getLastName(), s.getMajor(), s.getZipcode(), s.getGpa());
        }
        System.out.println("==============================================================\n");
    }
}

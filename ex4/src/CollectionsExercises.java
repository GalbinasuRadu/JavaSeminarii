import java.util.*;

public class CollectionsExercises {

    public static void main(String[] args) {

        // 1. ArrayList<String> of student names
        ArrayList<String> names = new ArrayList<>();

        names.add("Ana");
        names.add("Radu");
        names.add("Maria");
        names.add("Andrei");
        names.add("Ioana");

        System.out.println("All names:");
        for (String name : names) {
            System.out.println(name);
        }

        names.remove(2); // removes the 3rd name

        System.out.println("After removing the 3rd name:");
        System.out.println(names);


        // 2. Sum of Integers
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        double average = (double) sum / numbers.size();

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);


        // 3. Reverse a list manually
        List<Integer> reversed = new ArrayList<>();

        for (int i = numbers.size() - 1; i >= 0; i--) {
            reversed.add(numbers.get(i));
        }

        System.out.println("Reversed list: " + reversed);


        // 4. Unique Words Counter
        String sentence = "java is fun and java is powerful";

        String[] words = sentence.split(" ");

        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            uniqueWords.add(word);
        }

        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Unique words count: " + uniqueWords.size());


        // 5. Word Frequency Counter
        String text = "apple banana apple orange banana apple";

        String[] textWords = text.split(" ");

        Map<String, Integer> frequency = new HashMap<>();

        for (String word : textWords) {
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        System.out.println("Word frequency:");
        System.out.println(frequency);


        // 6. Phone Book
        Map<String, String> phoneBook = new HashMap<>();

        phoneBook.put("Ana", "0711111111");
        phoneBook.put("Radu", "0722222222");
        phoneBook.put("Maria", "0733333333");

        String searchName = "Radu";

        if (phoneBook.containsKey(searchName)) {
            System.out.println(searchName + "'s phone: " + phoneBook.get(searchName));
        } else {
            System.out.println("Name not found.");
        }

        System.out.println("Phone book entries:");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        // 7. Students management system
        List<Student> students = new ArrayList<>();

        students.add(new Student("Ana", 9));
        students.add(new Student("Radu", 8));
        students.add(new Student("Maria", 10));
        students.add(new Student("Andrei", 7));

        System.out.println("All students:");
        for (Student student : students) {
            System.out.println(student);
        }

        Student bestStudent = students.get(0);

        for (Student student : students) {
            if (student.getGrade() > bestStudent.getGrade()) {
                bestStudent = student;
            }
        }

        System.out.println("Student with highest grade: " + bestStudent);


        // 8. Sort students by name
        students.sort(Comparator.comparing(Student::getName));

        System.out.println("Students sorted by name:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort students by grade descending
        students.sort(Comparator.comparing(Student::getGrade).reversed());

        System.out.println("Students sorted by grade descending:");
        for (Student student : students) {
            System.out.println(student);
        }


        // 9. Remove duplicates from objects
        List<Student> studentsWithDuplicates = new ArrayList<>();

        studentsWithDuplicates.add(new Student("Ana", 9));
        studentsWithDuplicates.add(new Student("Radu", 8));
        studentsWithDuplicates.add(new Student("Ana", 9));
        studentsWithDuplicates.add(new Student("Maria", 10));

        Set<Student> uniqueStudents = new HashSet<>(studentsWithDuplicates);

        System.out.println("Unique students:");
        for (Student student : uniqueStudents) {
            System.out.println(student);
        }


        // Optional 10. LRU Cache simplified
        LinkedHashMap<Integer, String> cache = new LinkedHashMap<>(3, 0.75f, true);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        cache.get(1);

        cache.put(4, "Four");

        if (cache.size() > 3) {
            Integer firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }

        System.out.println("LRU cache: " + cache);


        // Optional 11. Merge Two Maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 2);
        map1.put("banana", 3);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 4);
        map2.put("orange", 5);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (map1.containsKey(key)) {
                map1.put(key, map1.get(key) + value);
            } else {
                map1.put(key, value);
            }
        }

        System.out.println("Merged map: " + map1);
    }
}


class Student {

    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + " - grade: " + grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;

        return grade == other.grade && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }
}
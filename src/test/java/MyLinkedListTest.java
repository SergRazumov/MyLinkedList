import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MyLinkedListTest {

    final MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
    @Before
    public void start() {
        myLinkedList.add(new Student("Sergey", 22, 301));
        myLinkedList.add(new Student("Andrey", 20, 401));
        myLinkedList.add(new Student("Maria", 30, 501));
    }

    @Test
    public void size() {
        Assert.assertEquals(myLinkedList.size(), 3);
    }

    @Test
    public void contains() {
        Assert.assertTrue(myLinkedList.contains(new Student("Andrey", 20, 401)));
    }

    @Test
    public void toArray() {
        Object[] mass =  myLinkedList.toArray();
        Assert.assertEquals(mass.length, 3);
        System.out.println(Arrays.toString(mass));
    }

    @Test
    public void testToArray() {
        Student[] massStudent =  myLinkedList.toArray(new Student[3]);
        Assert.assertEquals(massStudent.length, 3);
        System.out.println(Arrays.toString(massStudent));
    }

    @Test
    public void add() {
        MyLinkedList<Student> emptyList = new MyLinkedList<>();
        emptyList.add(new Student("Test", 0, 0));
        Assert.assertEquals(emptyList.size(), 1);
        emptyList.add(new Student("Sergey", 22, 301));
        emptyList.add(new Student("Andrey", 20, 401));
        emptyList.add(new Student("Maria", 30, 501));
        Assert.assertEquals(emptyList.size(), 4);

        for(Student student:emptyList) {
            System.out.println(student);
        }
    }

    @Test
    public void remove() {
        MyLinkedList<Student> emptyList = new MyLinkedList<>();
        emptyList.add(new Student("Test", 0, 0));
        Assert.assertFalse(emptyList.remove(new Student("Test1", 0, 0)));
        emptyList.add(new Student("Sergey", 22, 301));
        emptyList.add(new Student("Andrey", 20, 401));
        Assert.assertTrue(emptyList.remove(new Student("Sergey", 22, 301)));
        Assert.assertEquals(emptyList.size(), 2);

        for(Student student:emptyList) {
            System.out.println(student);
        }
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(myLinkedList.containsAll((MyLinkedList<Student>) myLinkedList));
    }

    @Test
    public void addAll() {
        MyLinkedList<Student> second = new MyLinkedList<>();
        second.add(new Student("Sergey", 22, 301));
        second.add(new Student("Andrey", 20, 401));
        Assert.assertTrue(myLinkedList.addAll(second));

        for(Student student:myLinkedList) {
            System.out.println(student);
        }
    }

    @Test
    public void testAddAll() {
        MyLinkedList<Student> second = new MyLinkedList<>();
        Assert.assertTrue(second.addAll(myLinkedList));
        for(Student student:second) {
            System.out.println(student);
        }

        System.out.println();

        Assert.assertTrue(second.addAll(3 , myLinkedList));
        for(Student student:second) {
            System.out.println(student);
        }

        System.out.println();

        MyLinkedList<Student> thirdList = new MyLinkedList<>();
        thirdList.add(new Student("Test", 0, 0));
        thirdList.add(new Student("Test1", 1, 1));
        Assert.assertTrue(myLinkedList.addAll(1 , thirdList));
        for(Student student:myLinkedList) {
            System.out.println(student);
        }
    }

    @Test
    public void removeAll() {
        MyLinkedList<Student> second = new MyLinkedList<>();
        second.add(new Student("Sergey", 22, 301));
        second.add(new Student("Andrey", 20, 401));
        second.add(new Student("Maria", 30, 501));
        Assert.assertTrue(myLinkedList.removeAll(second));
        Assert.assertEquals(myLinkedList.size(), 0);
        for(Student student:myLinkedList) {
            System.out.println(student);
        }
    }

    @Test
    public void retainAll() {
        MyLinkedList<Student> second = new MyLinkedList<>();
        second.add(new Student("Sergey", 22, 301));
        second.add(new Student("Andrey", 20, 401));
        Assert.assertTrue(myLinkedList.retainAll(second));
        Assert.assertEquals(myLinkedList.size(), 2);
        for(Student student:myLinkedList) {
            System.out.println(student);
        }
    }
}
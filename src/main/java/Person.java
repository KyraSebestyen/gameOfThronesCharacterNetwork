import java.util.Objects;

public class Person implements Comparable<Person> {
    private static int lfid = 0;
    private final String name;
    private final int id;

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    public Person(String name) {
        this.name = name;
        this.id = Person.lfid++; //laufende ID
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


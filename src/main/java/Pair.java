import java.util.Objects;

public class Pair {
    Person person1;
    Person person2;

    public Pair(Person person1, Person person2) {
        this.person1 = person1;
        this.person2 = person2;
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return (person1.equals(pair.person1) && person2.equals(pair.person2)) || (person2.equals(pair.person1) && person1.equals(pair.person2));
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return  person1 + "," + person1.getId() + "," + person2 + "," + person2.getId();
    }
}

import java.util.*;
import java.util.stream.Collectors;

public class Scene {
    private Set<Person> persons = new HashSet<>();

    public void addPerson(Person person){
        persons.add(person);
    }

    public Set<Pair> getPairs(){
        Set<Pair> result = new HashSet<>();
        persons.forEach(person -> {
            result.addAll(persons
                    .stream()
                    .filter(person2 -> !person.equals(person2))
                    .map(person2 -> new Pair(person, person2))
                    .collect(Collectors.toList()));
    });
        return result;
    }

    public List<Person> getPersons(){
        return new ArrayList<>(persons);
    }


    @Override
    public String toString() {
        return "Scene: " + persons.stream().map(Person::toString).collect(Collectors.joining(", "));
    }
}

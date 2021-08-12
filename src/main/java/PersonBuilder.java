import java.util.HashMap;
import java.util.Map;

public class PersonBuilder {
    private Map<String, Person> persons = new HashMap<>();

    public Person getPersonByName(String name){
        Person person;
        if(persons.containsKey(name)){
            person = persons.get(name);
        } else {
            person = new Person(name);
        }
        persons.put(name, person);
        return person;
    }

    public void printAllPersons(){
        persons.values().stream().sorted().forEach((person) -> System.out.println(person.getName() + " (ID: " + person.getId() + ")"));
    }
}

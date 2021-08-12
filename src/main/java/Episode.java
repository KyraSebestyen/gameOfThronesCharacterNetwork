import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Episode {
    private String name;
    private List<Scene> scenes = new ArrayList<>();

    public Map<Person, Integer> getOccurrences() {
        Map<Person, Integer> result = new HashMap<>();
        scenes.forEach(scene -> {
            scene.getPersons().forEach(person -> {
                int oldCount = result.getOrDefault(person, 0);
                int newCount = oldCount + 1;
                result.put(person, newCount);
            });
        });
        return result;
    }

    public Map<Pair, Integer> getPairedOccurrences(){
        Map<Pair, Integer> result = new HashMap<>();
        scenes.forEach(scene -> {
            scene.getPairs().forEach(pair -> {
                int oldCount = result.getOrDefault(pair, 0);
                int newCount = oldCount + 1;
                result.put(pair, newCount);
            });
        });
        return result;
    }

    public void addScene(Scene scene){
        scenes.add(scene);
    }

    public Episode setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Episode " + name + ":\n" + scenes.stream().map(Scene::toString).collect(Collectors.joining("\n"));
    }
}

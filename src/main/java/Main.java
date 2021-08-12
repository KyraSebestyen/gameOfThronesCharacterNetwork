import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
//        PersonBuilder personBuilder = new PersonBuilder();
//        InformationReader informationReader = new InformationReader("season5episode1.txt", personBuilder);
//        Episode episode = informationReader.read();
//        System.out.println(episode);
//        Map<Person,Integer> persons = episode.getOccurrences();
//        Map<Pair,Integer> pairedOccurrences = episode.getPairedOccurrences();
//
//        System.out.println(persons);
//        System.out.println(pairedOccurrences);

        ProcessAllFiles processAllFiles = new ProcessAllFiles();
        List<Episode> episodes = processAllFiles.process();
//        episodes.forEach(System.out::println);
       // processAllFiles.printPersons();
        episodes.stream().flatMap((Episode episode) -> episode
                .getPairedOccurrences()
                .entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, toList())))
                .entrySet().stream()
                .map(entry -> {
                    return Map.entry(entry.getKey(), entry.getValue().stream().reduce(Integer::sum).get());
                })
                .map(entrySet -> entrySet.getKey() + "," + entrySet.getValue())
                .forEach(System.out::println);



    }
}

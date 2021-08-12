import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationReader {
    private PersonBuilder personBuilder;
    private File file;

    public InformationReader(File file, PersonBuilder personBuilder) {
        this.file = file;
        this.personBuilder = personBuilder;
    }

    public Episode read() throws IOException, URISyntaxException{
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Episode episode = new Episode();
        String line;
        Scene currentScene = null;

        while((line = bufferedReader.readLine()) != null){
            if(line.equals("\r\n")){
                continue;
            }
            if(sceneDetected(line)){
                currentScene = new Scene();
                episode.addScene(currentScene);
            } else if(personDetected(line) != null){
                Person person = personBuilder.getPersonByName(personDetected(line));
                currentScene.addPerson(person);
            }
        }
        return episode;
    }

    public String personDetected(String line){
        String patternOneName = "^([A-Z]+):(.*)$";
        Matcher matcherOneName = Pattern.compile(patternOneName).matcher(line);
        String patternOneNameTwoParts = "^([A-Z]+ [A-Z]+):(.*)$";
        Matcher matcherOneNameTwoParts = Pattern.compile(patternOneNameTwoParts).matcher(line);
        if(matcherOneName.matches()){
            return matcherOneName.group(1);
        } else if (matcherOneNameTwoParts.matches()){
            return matcherOneNameTwoParts.group(1);
        }
        return null;
    }

    public boolean sceneDetected(String line){
        String pattern = "((INT)|(EXT)|(CUT TO))([.:]).*";
        Matcher sceneMatcher = Pattern.compile(pattern).matcher(line);
        return sceneMatcher.matches();
    }
}

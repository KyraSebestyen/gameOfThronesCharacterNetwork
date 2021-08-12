import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessAllFiles {
    private PersonBuilder personBuilder = new PersonBuilder();

    public List<Episode> process() {
        Collection<File> files = FileUtils.listFiles(new File("C:/Users/micro/IdeaProjects/gameOfThrones3/src/main/resources"), null, false);
        return files.stream().map(file -> {
            try {
                return new InformationReader(file, personBuilder).read().setName(file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }
    public void printPersons(){
        personBuilder.printAllPersons();
    }

}

package fileservice;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class FileService {

    public static List<String> getMap() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(Objects.requireNonNull(FileService.class
                .getClassLoader()
                .getResource("map.txt"))
                .toURI()));
    }

    public static void saveMapToFile(List<String> map) throws URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(FileService.class
                .getClassLoader()
                .getResource("map.txt"))
                .toURI());
        try(var in = Files.newBufferedWriter(path))
        {
            for(String l:map){
                in.write(l);
                in.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

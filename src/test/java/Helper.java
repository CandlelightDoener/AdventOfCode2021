import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Helper {

    static Stream<String> readFileAsStream(String fileName) {
        Path path = Paths.get("resources/"+fileName);
        try {
            return Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Collection<String> readFile(String fileName) {
        return readFileAsStream(fileName).collect(Collectors.toList());
    }
}

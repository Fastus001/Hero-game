package fileservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    @Test
    void getMap() throws IOException, URISyntaxException {
        final List<String> map = FileService.getMap();
        assertEquals(10,map.size());
    }

    @Test
    void saveMapToFile() throws IOException, URISyntaxException {
        final List<String> map = FileService.getMap();
        FileService.saveMapToFile(map);
    }
}
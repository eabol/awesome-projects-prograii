package main.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class FileReader {

    protected FileReader() {
    }

    //@@ https://devqa.io/java-read-json-file-as-string/
    //It simply picks up a file and parses it as String

    public String readAsString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

}

package api.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

public class FileEncodingReaderImpl implements FileEncodingReader{
    @Override
    public Reader read(File file, Charset fileEncoding) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file, fileEncoding);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileReader;
    }
}

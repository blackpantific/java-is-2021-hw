package api.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

public class FileEncodingReaderImpl implements FileEncodingReader{
    @Override
    public Reader read(File file, Charset fileEncoding) {


        try {
            FileReader fileReader = new FileReader(file, fileEncoding);
            return fileReader;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}

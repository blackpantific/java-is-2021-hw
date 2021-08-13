package api.file;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileEncodingWriterImpl implements FileEncodingWriter{

    @Override
    public void write(File file, InputStream data, Charset dataEncoding) {

        try (FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8)){

            int c = -1;
            while((c = data.read()) >=0){
                fileWriter.write((char)c);
            }

            fileWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void write(File file, InputStream data, Charset dataEncoding, Charset fileEncoding) {

        try (FileWriter fileWriter = new FileWriter(file, fileEncoding)){

            int c = -1;
            while((c = data.read()) >=0){
                fileWriter.write((char)c);
            }

            fileWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package api.file;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileEncodingWriterImpl implements FileEncodingWriter{

    @Override
    public void write(File file, InputStream data, Charset dataEncoding) {

        createFile(file);

        try (FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8)){

            writeToFile(data, dataEncoding, fileWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void write(File file, InputStream data, Charset dataEncoding, Charset fileEncoding) {

        var charset = StandardCharsets.UTF_8;

        createFile(file);

        if(fileEncoding != null){
            charset = fileEncoding;
        }

        try (FileWriter fileWriter = new FileWriter(file, charset)){

            writeToFile(data, dataEncoding, fileWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeToFile(InputStream data, Charset dataEncoding, FileWriter fileWriter) throws IOException {
        var amount = data.available();
        char[] buffer = new char[amount];
        StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(data, dataEncoding);

        int numAll = 0;

        for (int numRead; (numRead = in.read(buffer, 0, buffer.length)) > 0; ) {
            out.append(buffer, 0, numRead);
            numAll = numRead;
        }
        char[] toWrite = new char[numAll];

        out.getChars(0, numAll, toWrite, 0);

        fileWriter.write(toWrite);
    }

    private void createFile(File file) {
        if(!file.isAbsolute()){

            Path currentRelativePath = Paths.get("");
            var projectFolderPath = currentRelativePath.toAbsolutePath().toString();
            var fullPath = Paths.get(projectFolderPath, file.toString());
            fileCheck(fullPath);
        }else {
            fileCheck(file.toPath());
        }
    }

    private void fileCheck(Path path){
        if(Files.exists(path))
        {
            // do some work
        }else{

            var parentFolderPath = path.resolveSibling("");

            try {
                var newFile = Files.createDirectories(parentFolderPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            File fileToCreate = new File(path.toString());
            try {
                var res = fileToCreate.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // do some work

        }
    }

}

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


        if(!file.isAbsolute()){

            Path currentRelativePath = Paths.get("");
            var projectFolderPath = currentRelativePath.toAbsolutePath().toString();
            var fullPath = Paths.get(projectFolderPath, file.toString());
            fileCheck(fullPath);

        }else {
            fileCheck(file.toPath());

        }




        try (FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8)){

            int c = -1;
            while((c = data.read()) >=0){
                fileWriter.write(c);
            }

            fileWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
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

    @Override
    public void write(File file, InputStream data, Charset dataEncoding, Charset fileEncoding) {

        var charset = StandardCharsets.UTF_8;

        if(!file.isAbsolute()){

            Path currentRelativePath = Paths.get("");
            var projectFolderPath = currentRelativePath.toAbsolutePath().toString();
            var fullPath = Paths.get(projectFolderPath, file.toString());
            fileCheck(fullPath);

        }else {
            fileCheck(file.toPath());

        }
        if(fileEncoding != null){
            charset = fileEncoding;
        }


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

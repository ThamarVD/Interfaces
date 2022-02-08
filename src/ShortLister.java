import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<Object> words = new ArrayList<>();

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                while(reader.ready())
                {
                    rec = reader.readLine();
                    for(String word : rec.split(" "))
                        words.add(word);

                }
                reader.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        ArrayList<Object> accWords = collectAll(words);
        for(Object word : accWords)
            System.out.println("\"" + (String) word + "\" is a small word");
    }
    static ArrayList<Object> collectAll(ArrayList<Object> words){
        ShortWordFilter shortWF = new ShortWordFilter();
        ArrayList<Object> accWords = new ArrayList<>();
        for (Object x : words)
            if(shortWF.accept(x))
                accWords.add(x);
        return accWords;
    }
}

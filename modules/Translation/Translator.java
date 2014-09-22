package project.modules.Application.Translation;

import java.util.HashMap;
import java.util.Iterator;
import project.modules.Application.Library.FileManager;

public class Translator
{
    public HashMap<String, String> vocabulary;
    private String fileDirectory = "modules/Translation/Languages/";
    private String fileExtension = ".csv";
    private String filePath;

    public Translator(String language)
    {
        FileManager fileManager = new FileManager(
            (filePath = fileDirectory + language + fileExtension)
        );

        vocabulary = new HashMap<String, String>();

        HashMap<Integer, String> map = fileManager.getMap();
        Iterator<Integer> keySetIterator = map.keySet().iterator();
        while (keySetIterator.hasNext()) {
            Integer key = keySetIterator.next();
            String[] parse = map.get(key).split(";");

            vocabulary.put(parse[0], parse[1]);
        }
    }

    public String __(String key)
    {
        if (vocabulary.containsKey(key)) {
            return vocabulary.get(key);
        } else {
            throw new IllegalArgumentException(
                "Tradução inexistente: [" + key + "]" +
                "\n\tArquivo: \"" + filePath + "\""
            );
        }
    }
}

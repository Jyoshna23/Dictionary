package com.example.dictonary;

import java.io.*;
import java.util.HashMap;

public class wordDictionary {
    HashMap<String,String> wordList;

    wordDictionary()
    {
        this.wordList = new HashMap<>();
    }
    void addword(String word, String meaning)
    {
        wordList.put(word,meaning);
    }

    HashMap<String,String> getwordList()
    {
        return wordList;
    }

    void serializeMap(){
        try{
            FileOutputStream os = new FileOutputStream("wordList");
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(wordList);
            os.close();
            oos.close();
        }
        catch(IOException io){
            io.printStackTrace();
        }
    }

    void deserializeMap() {
        try {
            FileInputStream is = new FileInputStream("wordList");
            ObjectInputStream ois = new ObjectInputStream(is);

            wordList = (HashMap<String, String>) ois.readObject();
        } catch (IOException io) {
            io.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found");
        }
    }
}

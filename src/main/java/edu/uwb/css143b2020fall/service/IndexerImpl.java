package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexerImpl implements Indexer {

    public static void main(String[] args) {
        List<String> docs = new ArrayList<String>();
        docs.add("say hello world like you mean hello world not just world");
        docs.add("hello world");
        docs.add("world seattle rains hello abc world");

        String[] words = new String[docs.size()];
        List<String> names = new ArrayList<>();
        List<List<Integer>> table = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        t.add(0);
        for (int i = 0; i < docs.size(); i++)
        {   int a = 0;
            words = docs.get(i).split("\\s+");
            for (int x = 0; x < words.length; x++) {

                table.add(t);
                System.out.println(table + "+ 1");
                boolean condition = false;

                for (int y = 0; y < names.size(); y++)
                {
                    if (words[x].equals(names.get(y))) {
                        condition = true;
                        a++;
                        table.get(a).add(x);
                        System.out.println(table + "+ 2");
                        break;
                    }
                }
                if (condition == false) {
                    table.get(a).add(x);
                    System.out.println(table + "+ 3");
                    names.add(words[x]);
                }
            }
        }
        for (int c = 0; c < names.size(); c++){
            table.get(c).remove(0);
        }
        System.out.println(names);
        System.out.println(table);
        /*
        for(int c = 0; c < docs.size(); c++){
            words = docs.get(c).split("\\s+");
            for(int k = 0; k < names.size(); k++){
                for(int l = 0; l < words.length; l++){
                    if (names.get(k).equals(words[l])){
                        table.add(null);
                    }
                }
            }
        }

         */
    }

    public Map<String, List<List<Integer>>> index(List<String> docs) {
        Map<String, List<List<Integer>>> indexes = new HashMap<>();
        // add your code
        List<List<Integer>> table = new ArrayList<>();
        String[] words = new String[docs.size()];
        int[] position = new int[docs.size()];
        for (int i = 0; i < docs.size(); i++) {
            words = docs.get(i).split("\\s+");
            position[i] = i;
        }
        //for (int x = 0; x <)
        return indexes;
    }
}
package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexerImpl implements Indexer {

    public static void main(String[] args) {
        Map<String, List<List<Integer>>> indexes = new HashMap<>();
        List<String> docs = new ArrayList<String>();
        docs.add("say hello world like you mean hello world not just world");
        docs.add("hello world");
        docs.add("world seattle rains hello abc world");

        String[] words = new String[docs.size()];
        List<String> names = new ArrayList<>();
        List<List<Integer>> table = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        //t.add(0);
        for (int i = 0; i < docs.size(); i++) {
            //int a = 0;
            words = docs.get(i).split("\\s+");
            for (int x = 0; x < words.length; x++) {

                //table.add(t);
                //System.out.println(table + "+ 1");
                boolean condition = false;

                for (int y = 0; y < names.size(); y++) {
                    if (words[x].equals(names.get(y))) {
                        condition = true;
                        //a++;
                        //table.get(a).add(x);
                        //System.out.println(table + "+ 2");
                        break;
                    }
                }
                if (condition == false) {
                    //table.get(a).add(x);
                    //System.out.println(table + "+ 3");
                    names.add(words[x]);
                }
            }
        }
        List<Integer>[] arr = new ArrayList[docs.size() * names.size()];
        for (int i = 0; i < (docs.size() * names.size()); i++) {
            arr[i] = new ArrayList<Integer>();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(names);
        System.out.println(table + "before");
        for(int n = 0; n < names.size(); n++){
            for(int d = 0; d < docs.size(); d++){
                words = docs.get(d).split("\\s+");
                for (int a = 0; a < arr.length; a++) {
                    for (int w = 0; w < words.length; w++) {
                        System.out.println(names.get(d) + " current name");
                        System.out.println(words[w] + " current word");
                        System.out.println("");
                        if (names.get(n).equals(words[w])) {
                            arr[a].add(w);
                            System.out.println(arr[a] + " added");
                            System.out.println(table + " table");
                            System.out.println(" ^ in if statement");

                        }

                    }
                    table.add(arr[a]);
                    indexes.put(names.get(n), table);
                    System.out.println(table);
                    System.out.println(d +" is d");
                    System.out.println(t + " cleared");
                    System.out.println(indexes + "hashmap");
                }
            }
        }
    }

    public Map<String, List<List<Integer>>> index(List<String> docs) {
        Map<String, List<List<Integer>>> indexes = new HashMap<>();
        // indexes.put(names.get(i), table.get(i))
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
package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexerImpl implements Indexer {

    public Map<String, List<List<Integer>>> index(List<String> docs) {

        Map<String, List<List<Integer>>> indexes = new HashMap<>();
        String[] words = new String[docs.size()];
        List<String> names = new ArrayList<>();
        List<List<Integer>> table = new ArrayList<>();
        List<Integer> t = new ArrayList<>();

        for (int i = 0; i < docs.size(); i++) {
            if(docs.isEmpty() || docs.contains("")){
                indexes.clear();
                return indexes;
            }
            words = docs.get(i).trim().split("\\s+");
            for (int x = 0; x < words.length; x++) {

                boolean condition = false;

                for (int y = 0; y < names.size(); y++) {
                    if (words[x].equals(names.get(y))) {
                        condition = true;
                        break;
                    }
                }
                if (condition == false) {
                    names.add(words[x]);
                }
            }
        }

        for(int n = 0; n < names.size(); n++){
            for(int d = 0; d < docs.size(); d++){
                words = docs.get(d).trim().split("\\s+");
                for (int w = 0; w < words.length; w++) {

                    if (names.get(n).equals(words[w])) {
                        t.add(w);

                    }

                }
                table.add(new ArrayList<Integer>(t));
                t.clear();

            }
            indexes.put(names.get(n), new ArrayList<List<Integer>>(table));
            table.clear();

        }
        return indexes;
    }
}
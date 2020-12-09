package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexerImpl implements Indexer {

    public static void main(String[] args){

        List<String> docs = new ArrayList<>();
        docs.add("world world hello world");
        docs.add("world world hallo");
        docs.add("world seattle hello abc world day");
        docs.add("abc hello world fun");

        Map<String, List<List<Integer>>> indexes = new HashMap<>();
        String[] words = new String[docs.size()];
        List<String> names = new ArrayList<>();
        List<List<Integer>> table = new ArrayList<>();
        List<Integer> t = new ArrayList<>();

        for (int i = 0; i < docs.size(); i++) {

            /*
            if(docs.isEmpty() || docs.contains("")){
                indexes.clear();

            }

             */
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

        //System.out.println(search("hello", indexes));
    }

    public static List<Integer> search(String keyPhrase, Map<String, List<List<Integer>>> index) {
        List<Integer> result = new ArrayList<>();
        // add your code
        List<List<Integer>> value = new ArrayList<>();
        List<Integer> doc_val = new ArrayList<>();
        String[] input = keyPhrase.trim().split("\\s+");
        //check if all words in key phrase are present in hashMap index

        for(int i=0; i < input.length; i++){
            if (!index.containsKey(input[i])){
                System.out.println ("phase is not present");
            }
        }


        value = index.get(input[0]);
        List<Integer> doc_temp = new ArrayList<>(value.size());
        for (int i=0; i< value.size(); i++){
            if(!(value.get(doc_temp.get(i)).isEmpty())){
                doc_val.add(i);
            }
        }
        for (int j=0; j<doc_val.size();j++){

            for (int k=1; k<input.length; k++){
                if(index.get(input[k]).get(doc_temp.get(j)).isEmpty()){
                    doc_val.remove(j);
                }
            }

        }
        /*
        for(int i = 0; i < input.length; i++){
            //int doc_val;
            int loc_val;
            if (index.containsKey(input[i])){
                //value = index.get(input[i]);
                //List<Integer> doc_temp = new ArrayList<>(value.size());
                for(int j = 0; j < value.size(); j++){
                    //if(!(value.get(doc_temp.get(j)).isEmpty())){
                        doc_val = j;
                        for(int k = 0; k < value.get(doc_temp.get(j)).size(); k++ ){
                            loc_val = value.get(doc_temp.get(j)).get(k);
                        }
                    }
                }
            }else{
                return result;
            }

        }*/

        return result;
    }

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
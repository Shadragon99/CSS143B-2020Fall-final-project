package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearcherImpl implements Searcher {

    public List<Integer> search(String keyPhrase, Map<String, List<List<Integer>>> index) {
        List<Integer> result = new ArrayList<>();

        List<List<Integer>> value = new ArrayList<>();
        List<Integer> doc_val = new ArrayList<>();
        String[] input = keyPhrase.trim().split("\\s+");
        //check if all words in key phrase are present in hashMap index

        for(int i=0; i < input.length; i++){
            if (!index.containsKey(input[i])){
                //System.out.println ("phase is not present");
                return result;
            }
        }


        value = index.get(input[0]);
        List<Integer> doc_temp = new ArrayList<>();
        for(int a = 0; a < value.size(); a++){
            doc_temp.add(a);
        }
        for (int i=0; i< value.size(); i++){
            if(!(value.get(doc_temp.get(i)).isEmpty())){
                doc_val.add(i);
            }
        }

        if(input.length == 1){

            return doc_val;
        }

        for (int j=doc_val.size()-1; j>=0 ;j--){

            for (int k=1; k<input.length; k++){
                if(index.get(input[k]).get(doc_temp.get(doc_val.get(j))).isEmpty()){
                    doc_val.remove(j);
                    //j--;
                }
            }

        }

        for(int l = 0; l < doc_val.size(); l++){
            boolean match = false;
            for(int m = 0; m < input.length-1; m++) {
                value = index.get(input[m]);
                List<Integer> pos_temp = new ArrayList<>();
                List<Integer> pos_temp1 = new ArrayList<>();
                pos_temp = value.get(doc_val.get(l));
                value = index.get(input[m+1]);
                pos_temp1 = value.get(doc_val.get(l));
                for(int n = 0; n < pos_temp.size(); n++){
                    for(int o = 0; o < pos_temp1.size(); o++){
                        if(pos_temp.get(n) + 1 == pos_temp1.get(o)){
                            match = true;
                            break;
                        } else{
                            match = false;
                        }
                    }
                }
                if(!match){
                    break;
                }
            }
            if(match){
                result.add(doc_val.get(l));
            }
        }

        return result;
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

    }
}
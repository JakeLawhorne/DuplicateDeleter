package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] strArray) {
        super(strArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        StringDuplicateDeleter deleter = new StringDuplicateDeleter(this.array);
        int len = deleter.array.length;
        String[] result = Arrays.copyOf(deleter.array, len);
        for (int i = 0; i < len; i++) {
            int count = getOccurrences(result[i]);
            if(count >= maxNumberOfDuplications){
                String temp = result[i];
                for(int j = i; j < len; j++){
                    if(Objects.equals(result[j], temp)){
                        result[j] = null;
                    }
                }
            }
        }
        int nonDuplicate = 0;
        for (int i = 0; i < len; i++) {
            if (result[i] != null) {
                nonDuplicate++;
            }
        }
        String[] uniqueArr = new String[nonDuplicate];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (result[i] != null) {
                uniqueArr[j++] = result[i];
            }
        }
        return uniqueArr;
    }
    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        StringDuplicateDeleter deleter = new StringDuplicateDeleter(this.array);
        int len = deleter.array.length;
        String[] result = Arrays.copyOf(deleter.array, len);
        for (int i = 0; i < len; i++) {
            int count = getOccurrences(result[i]);
            if(count == exactNumberOfDuplications){
                String temp = result[i];
                for(int j = i; j < len; j++){
                    if(Objects.equals(result[j], temp)){
                        result[j] = null;
                    }
                }
            }
        }
        int nonDuplicate = 0;
        for (int i = 0; i < len; i++) {
            if (result[i] != null) {
                nonDuplicate++;
            }
        }
        String[] uniqueArr = new String[nonDuplicate];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (result[i] != null) {
                uniqueArr[j++] = result[i];
            }
        }
        return uniqueArr;
    }
}

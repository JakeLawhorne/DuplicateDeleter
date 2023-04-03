package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {


    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        IntegerDuplicateDeleter deleter = new IntegerDuplicateDeleter(this.array);
        int len = deleter.array.length;
        Integer[] result = Arrays.copyOf(deleter.array, len);


        if (maxNumberOfDuplications <= 1) {
            return new Integer[0];
        } else {
            for (int i = 0; i < len; i++) {
                int count = getOccurrences(result[i]);
                if(count >= maxNumberOfDuplications){
                   int temp = result[i];
                    for(int j = i; j < len; j++){
                        if(Objects.equals(result[j], temp)){
                            result[j] = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            int nonDuplicate = 0;
            for (int i = 0; i < len; i++) {
                if (result[i] != Integer.MAX_VALUE) {
                    nonDuplicate++;
                }
            }
            Integer[] uniqueArr = new Integer[nonDuplicate];
            int j = 0;
            for (int i = 0; i < len; i++) {
                if (result[i] != Integer.MAX_VALUE) {
                    uniqueArr[j++] = result[i];
                }
            }
            return uniqueArr;
        }
    }
    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        IntegerDuplicateDeleter deleter = new IntegerDuplicateDeleter(this.array);
        int len = deleter.array.length;
        Integer[] result = Arrays.copyOf(deleter.array, len);
            for (int i = 0; i < len; i++) {
                int count = getOccurrences(result[i]);
                if(count == exactNumberOfDuplications){
                    int temp = result[i];
                    for(int j = i; j < len; j++){
                        if(Objects.equals(result[j], temp)){
                            result[j] = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            int nonDuplicate = 0;
            for (int i = 0; i < len; i++) {
                if (result[i] != Integer.MAX_VALUE) {
                    nonDuplicate++;
                }
            }
            Integer[] uniqueArr = new Integer[nonDuplicate];
            int j = 0;
            for (int i = 0; i < len; i++) {
                if (result[i] != Integer.MAX_VALUE) {
                    uniqueArr[j++] = result[i];
                }
            }
            return uniqueArr;
        }
    }


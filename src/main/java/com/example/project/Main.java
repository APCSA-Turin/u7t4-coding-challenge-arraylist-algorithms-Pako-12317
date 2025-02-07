package com.example.project;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    /** Inserts toInsert after each String in stringList
    *  that contains the letter "i"
    *
    *  DOES mutate (modify) elements of stringList.
    *  PRECONDITION: stringList.size() > 0, toInsert.length() > 0
    *
    *  @param stringList  original arraylist of Strings
    *  @param str String to insert
    */
    public static ArrayList<String> insertAfterI(ArrayList<String> stringList, String str) {
        for (int i = 0; i < stringList.size(); i++) {
            String current = stringList.get(i);
            if (current.contains("i")) {
                stringList.add(i + 1, str);
                i++; // Skip the newly inserted string
            }
        }
        return stringList;
    }

    /** Removes all Strings from stringList that have a length of 3
    *
    *  DOES mutate (modify) elements of stringList.
    *  PRECONDITION: stringList.size() > 0
    *
    *  @param stringList  original arraylist of Strings
    */
    public static ArrayList<String> removeThree(ArrayList<String> stringList) {
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).length() == 3) {
                stringList.remove(i);
                i--; // Adjust the index since the list has shrunk
            }
        }
        return stringList;
    }

    /** Returns an ArrayList with all elements of arr reversed
    *
    *  Does NOT mutate (modify) elements in intList.
    *  PRECONDITION: intList.size() > 0
    *
    *  @param intList  original array of integers
    */
    public static ArrayList<Integer> reverseArray(int[] intList) {
        ArrayList<Integer> reversed = new ArrayList<>();
        for (int i = intList.length - 1; i >= 0; i--) {
            reversed.add(intList[i]);
        }
        return reversed;
    }

    /** Appends an uppercase version of each string to the end of wordList;
     *  the uppercase versions appear in the same order as the lowercase versions
     *  for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "my", "best", "friend", "HELLO", "MY", "BEST", "FRIEND"]
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITIONS: wordList.size() > 0,
     *                 all words in wordList are initially lowercase
     *
     *  @param wordList  arraylist of Strings
     */
    public static ArrayList<String> duplicateUpperEnd(ArrayList<String> wordList) {
        ArrayList<String> result = new ArrayList<>(wordList);
        for (String word : wordList) {
            result.add(word.toUpperCase());
        }
        return result;
    }

    /** Returns an arraylist of Strings that represents the input sentence parsed
    *  into separate words, using a single space (" ") as the delimiter
    *
    *  For example, if sentence = "This is my sentence!"
    *  this method return the arraylist: [This, is, my, sentence!]
    *
    *  PRECONDITION: sentence does not end with a space and each word is
    *                separated by exactly one space
    *
    *  @param sentence  the input String
    *  @return  new arraylist of Strings containing the words of sentence
    */
    public static ArrayList<String> parseSentence(String sentence) {
        String[] words = sentence.split(" ");
        return new ArrayList<>(Arrays.asList(words));
    }

    /** Moves all words in wordList that begin with "b" to the front of
    *  wordList; all "b" words that are moved should appear in the same order
    *  in the modified arrayList as they did before being moved
    *
    *  For example, this method will take a wordList:
    *  ["apple", "banana", "cherry", "donut", "Bagel", "danish", "berry", "baguette", "soda"]
    *  and modify it to
    *  ["banana", "Bagel", "berry", "baguette", "apple", "cherry", "donut", "danish", "soda"]
    *
    *  DOES mutate (modify) elements in wordList
    *  PRECONDITIONS: - wordList.size() > 0
    *                 - all strings in wordList have length >= 1
    *
    *  @param wordList  arraylist of words
    */
    public static ArrayList<String> moveBWords(ArrayList<String> wordList) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> nonBWords = new ArrayList<>();
        
        for (String word : wordList) {
            if (word.toLowerCase().startsWith("b")) {
                result.add(word);
            } else {
                nonBWords.add(word);
            }
        }
        
        for (String nonB : nonBWords) {
            result.add(nonB);
        }
        
        return result;
    }

    /** Removes all duplicate values from an intList, leaving only the first
     *  occurrence in the arrayList; for example, this method will modify
     *  [1, 2, 5, 4, 2, 2, 1, 6, 4, 4, 8, 1, 7, 4, 2] --> [1, 2, 5, 4, 6, 8, 7]
     *
     *  DOES mutate (modify) elements in intList
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  intList of Integers
     */
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> intList) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer num : intList) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    /** Returns true if the first and last element of the array are the same
     *  and the list has a size greater than zero.
     */
    public static boolean sameFirstLast(ArrayList<Integer> list) {
        if (list.size() > 0) {
            return list.get(0).equals(list.get(list.size() - 1));
        }
        return false;
    }

    /** Returns the list after swapping the first and last element of the array */
    public static ArrayList<Integer> swapEnds(ArrayList<Integer> list) {
        if (list.size() > 1) {
            int first = list.get(0);
            int last = list.get(list.size() - 1);
            list.set(0, last);
            list.set(list.size() - 1, first);
        }
        return list;
    }

    /** Rearranges the list so all zeros are moved to the front */
    public static ArrayList<Integer> zeroFront(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        int zeroCount = 0;

        // Count zeros and add non-zero elements to result
        for (Integer num : list) {
            if (num == 0) {
                zeroCount++;
            } else {
                result.add(num);
            }
        }

        // Add the zeros to the front
        for (int i = 0; i < zeroCount; i++) {
            result.add(0, 0);
        }

        return result;
    }

    /** Replaces lone occurrences of the target value in the list 
     *  with the larger of the numbers next to it. 
     */
    public static ArrayList<Integer> notAlone(ArrayList<Integer> list, int val){
        for (int i = 0; i < list.size(); i++){
            if(val == list.get(i) && i==0){
                list.set(0, list.get(i+1));
            } else if (val == list.get(i)){
                if (i > 0 && i < list.size() - 1) {
                    if (list.get(i - 1) != val && list.get(i + 1) != val) {
                        int larger = Math.max(list.get(i - 1), list.get(i + 1));
                        list.set(i, larger);
                    }
                } else if (i == list.size() - 1 && list.size() > 1) {
                    if (list.get(i - 1) != val) {
                        list.set(i, list.get(i - 1));
                    }
                }
            }
        }
        return list;
    }
    


    /** Left shifts the array, moving all elements one position to the left */
    public static ArrayList<Integer> shiftLeft(ArrayList<Integer> list) {
        if (list.size() > 1) {
            int first = list.get(0);
            list.remove(0);
            list.add(first);
        }
        return list;
    }

    /** Moves each 3 to be followed by a 4 in the array */
    public static ArrayList<Integer> fix34(ArrayList<Integer> list) {
        int i = 0;
        
        while (i < list.size()) {
            if (list.get(i) == 3) { // looks for 3
                int j = 0;
                boolean swapped = false;
                
            while (j < list.size() && !swapped) { //looks for 4 thats not after 3
                if (list.get(j) == 4 && (j == 0 || list.get(j - 1) != 3)) {
                // Swap the number after 3 with this 4
                    int temp = list.get(i + 1);
                    list.set(i + 1, 4);
                    list.set(j, temp);
                    swapped = true;
                }
                j++;
            }
        }
        i++;
    }
        
    return list;
    }
    

    // Returns the mode(s) of a list of integers
    public static ArrayList<Integer> modes(int[] numList) {
        ArrayList<Integer> modeList = new ArrayList<>();
        int maxFrequency = 0;
        boolean allSameFrequency = true;
    
        int maxValue = numList[0]; // Find the max
        for (int num : numList) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
    
        int[] frequencies = new int[maxValue + 1];// store freq
    
        for (int num : numList) { // Count freq
            frequencies[num]++;
            if (frequencies[num] > maxFrequency) {
                maxFrequency = frequencies[num];
            }
        }
    
        int firstNonZeroFrequency = 0; // Check if all freq are the same
        int i = 0;
        while (i < frequencies.length && allSameFrequency) {
            if (frequencies[i] != 0) {
                if (firstNonZeroFrequency == 0) {
                    firstNonZeroFrequency = frequencies[i];
                } else if (frequencies[i] != firstNonZeroFrequency) {
                    allSameFrequency = false;
                }
            }
            i++;
        }
    
       
        if (!allSameFrequency) { // all freq are the same
            // Collect modes
            for (int j = 0; j < frequencies.length; j++) {
                if (frequencies[j] == maxFrequency) {
                    modeList.add(j);
                }
            }
        }
    
        return modeList;
    }


    public static void main(String[] args) {
        // Test all methods here (you can call any of the above methods in the main method if you wish)
    }
}

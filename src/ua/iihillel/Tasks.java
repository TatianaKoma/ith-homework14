package ua.iihillel;

import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("fox", "fox", "rabbit", "wolf", "fox", "wolf", "parrot"));
        System.out.println(convertToUnique(words));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 97, 8, 6, 97, 2, 2, 75, 63, 97, 1, 8, 45));
        System.out.println(getSortedUniqueIntegersASC(numbers));
        System.out.println(getSortedUniqueIntegersDESC(numbers));
        System.out.println(buildSentenceDirection(words));
    }

    public static Set<String> convertToUnique(List<String> words) {
        Set<String> uniqueWords = new HashSet<>(words);
        return uniqueWords;
    }

    public static List<Integer> getSortedUniqueIntegersASC(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>(numbers);
        List<Integer> numbersList = new ArrayList<Integer>(uniqueNumbers);
        numbersList.sort(Comparator.naturalOrder());
        return numbersList;
    }

    public static List<Integer> getSortedUniqueIntegersDESC(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>(numbers);
        List<Integer> numbersList = new ArrayList<Integer>(uniqueNumbers);
        Collections.sort(numbersList, Collections.reverseOrder());
        return numbersList;
    }

    public static LinkedHashSet<String> buildSentenceDirection(List<String> words) {
        LinkedHashSet<String> uniqueNumbers = new LinkedHashSet<>(words);
        return uniqueNumbers;
    }
}

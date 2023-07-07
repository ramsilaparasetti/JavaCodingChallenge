import java.sql.SQLOutput;
import java.util.*;

public class JavaExercises {
    StringBuilder newWord = new StringBuilder();
    public Boolean isStringPalindrome(String word) {
        // try {
        for (int charIndex = word.length() - 1; charIndex >= 0; charIndex--) {
            newWord.append(word.charAt(charIndex));

        }

        // }
//        catch (Exception e){
//                System.out.println("Illegal argument exception");
//        }

        if (word.equals(newWord.toString())) {
            return true;
        } else return false;
    }

    public Boolean isIntPalindrome(int number) {
        int copyNumber = number;
        int reminder;
        int reversedNumber = 0;
        do{
            reminder = (copyNumber % 10);
            reversedNumber = (reversedNumber*10) + reminder;
            copyNumber = copyNumber/10;

        } while (copyNumber > 0);


        if(number == reversedNumber){
            return true;
        }
        else return false;
    }

    public void revIntArray(int[] intArray) {

        try {
            int arrayIntOutBoundIndex = intArray.length - 1;
            for (int arrayIndex = 0; arrayIndex < intArray.length / 2; arrayIndex++) {
                int temp = intArray[arrayIndex];
                intArray[arrayIndex] = intArray[arrayIntOutBoundIndex - arrayIndex];
                intArray[arrayIntOutBoundIndex - arrayIndex] = temp;
            }
        }
        catch (ArrayIndexOutOfBoundsException abe){
            System.out.println("Array out of bound exception");
        }

        for (int i = 0; i <= intArray.length - 1; i++){
            System.out.println(intArray[i]);
        }
    }

    public void revStrArray(String[] strArray) {
        int arrayStrOutBoundIndex = strArray.length - 1;
        for(int arrayIndex = 0; arrayIndex < strArray.length/2; arrayIndex++){
            String temp = strArray[arrayIndex];
            strArray[arrayIndex] = strArray[arrayStrOutBoundIndex - arrayIndex];
            strArray[arrayStrOutBoundIndex - arrayIndex] = temp;
        }

        for (int i = 0; i <= strArray.length - 1; i++){
            System.out.println(strArray[i]);
        }
    }

    public int[] maxMinArray(int[] intArray) {
        for(int index = 0; index < intArray.length; index++){
            for(int subIndex = 1; subIndex < intArray.length - index; subIndex++ ) {
                if (intArray[subIndex - 1] > intArray[subIndex]) {
                    int temp = intArray[subIndex];
                    intArray[subIndex] = intArray[subIndex - 1];
                    intArray[subIndex - 1] = temp;
                }
            }
        }
        for (int i = 0; i <= intArray.length - 1; i++){
            System.out.println(intArray[i]);
        }

        return intArray;
    }


//    public int[] indicesArray(int[] intArray, int target) {
//        int[] resultArray = new int[2];
//        for(int index = 0; index < intArray.length; index++){
//            for(int subIndex = index + 1; subIndex < intArray.length; subIndex++ ) {
//                if ((intArray[index] + intArray[subIndex]) == target)  {
//                    resultArray[0] = index;
//                    resultArray[1] = subIndex;
//                }
//            }
//        }
//        for (int i = 0; i <= resultArray.length - 1; i++){
//            System.out.println(resultArray[i]);
//        }
//        return resultArray;
//    }

    public int[] indicesArray(int[] intArray, int target) {

        Map<Integer, Integer> visitedNumbers = new HashMap<>();

        for(int index = 0; index < intArray.length; index++){
            int delta = target - intArray[index];
            if (visitedNumbers.containsKey(delta)){
                return new int[] {visitedNumbers.get(delta), index};
            }
            visitedNumbers.put(intArray[index], index);
        }

        return new int[] {-1, -1};
    }

    public void arrayListMethod() {
        List<Integer> testArray = new ArrayList<>(Arrays.asList(7,4,4,8,5,4,8,6,4,1));
        Iterator<Integer> itr = testArray.iterator();
        double wMobNumber = 0;
        double fMobNumber = 0;
        while (itr.hasNext()){
            wMobNumber = (wMobNumber * 10) + itr.next();
        }

        for(int i: testArray){
            fMobNumber = (fMobNumber * 10) + testArray.get(i);
            String mobNumber = String.valueOf(fMobNumber);
        }

        System.out.println("While Mobile Number :"+wMobNumber);
        System.out.println("For Mobile Number :"+fMobNumber);
    }

    public void wordCount() {


        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String sentence = scan.nextLine();

        String[] words = sentence.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();

        for(String word:words) {
            if(wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word)+1);
            }
            else wordCount.put(word, 1);
        }
        List<String> sortedArray = new ArrayList<>(wordCount.keySet());
        Collections.sort(sortedArray);
        for(String word: sortedArray){
            System.out.println("Word : "+word+ ", " + "Count :"+wordCount.get(word));
        }
        //wordCount.forEach((key, value) -> System.out.println("Word : "+key+ " " + "Count :"+value));
    }



    public static void main (String[] args) {
        int[] intArray = {1,2,3,4,5,6};
        int[] unsortedArray = {5,4,6,3,1,2};
        int [] targetArray = {2,7,11,15,18,33};
        int targetNumber = 44;
        String[] strArray = {"Ram,rat, cat, bat, virat"};
        JavaExercises js = new JavaExercises();

//        System.out.println(js.isStringPalindrome("123321"));
//        js.revIntArray(intArray);
//        js.revStrArray(strArray);
//        System.out.println(js.isIntPalindrome(1234321));
//        System.out.println("Min Number :"+js.maxMinArray(unsortedArray)[0] + " ----- " + "Max Number :"+js.maxMinArray(unsortedArray)[unsortedArray.length - 1]);
        // js.indicesArray(targetArray, targetNumber);
//        js.arrayListMethod();
        js.wordCount();
    }
}


import java.util.ArrayList;
import java.util.Random;

public class SortingAlgorithms {

    public static ArrayList<Integer> generateList() {
        Random random = new Random();
        ArrayList<Integer> integerList = new ArrayList<>();

        for(int i = 0; i < 50; i++) {
            int randomInt = random.nextInt();
            integerList.add(randomInt);
        }

        return integerList;
    }

    public static long bubbleSort(ArrayList<Integer> list) {

        long startTime = System.nanoTime();
        for(int var : list) {

            for(int varIn : list) {
                int a = list.indexOf(varIn);
                int b = a + 1;
                int temp;

                if(b < list.size()) {
                    if(list.get(a) > list.get(b)) {
                        temp = list.get(a);
                        list.set(a, list.get(b));
                        list.set(b, temp);

                    }
                }
            }
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Bubble Sort");
        System.out.println("Time: " + totalTime);
        return totalTime;
    }

    public static int partition(ArrayList<Integer> list, int left, int right) {
        int pivot = list.get(right);
        int a = left - 1;
        for (int i = left; i < right; i++) {
            if (list.get(i) <= pivot) {
                a++;
                int temp = list.get(a);
                list.set(a, list.get(i));
                list.set(i, temp);
            }
        }
        int temp = list.get(a + 1);
        list.set(a + 1, list.get(right));
        list.set(right, temp);
        return a + 1;
    }

    public static void sort(ArrayList<Integer> list, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(list, left, right);
            sort(list, left, pivotIndex - 1);
            sort(list, pivotIndex + 1, right);
        }
    }
    public static long quickSort(ArrayList<Integer> list) {

        long startTime = System.nanoTime();

        sort(list, 0, list.size() - 1);

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Quick Sort");
        System.out.println("Time: " + totalTime);
        return totalTime;
    }


    public static void main(String[] args) {
        System.out.println("Generated List A.");
        ArrayList<Integer> listA = generateList();

        System.out.println("\nGenerated List B.");
        ArrayList<Integer> listB = generateList();

        System.out.println("\nSorted List A.");
        long bubbleTime = bubbleSort(listA);

        System.out.println("\nSorted List B.");
        long quickTime = quickSort(listB);

        long timeSave;
        if(bubbleTime > quickTime) {
            timeSave = bubbleTime - quickTime;
            System.out.println("Quick Sort time was faster by " + timeSave + " nanoseconds.");
        } else {
            timeSave = quickTime - bubbleTime;
            System.out.println("Bubble Sort time was faster by " + timeSave + " nanoseconds.");
        }
    }
}

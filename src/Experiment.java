import java.util.Arrays;

public class Experiment {
    private Sorter sorter;
    private Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }

    public long measureSortTime(int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length);

        long start = System.nanoTime();

        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(copy);
        } else if (type.equalsIgnoreCase("advanced")) {
            sorter.advancedSort(copy);
        }

        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();

        return end - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {
            System.out.println("\n===== Array Size: " + size + " =====");

            int[] randomArray = sorter.generateRandomArray(size);
            int[] sortedArray = Arrays.copyOf(randomArray, randomArray.length);
            Arrays.sort(sortedArray);


            long basicRandom = measureSortTime(randomArray, "basic");
            long advancedRandom = measureSortTime(randomArray, "advanced");

            long basicSorted = measureSortTime(sortedArray, "basic");
            long advancedSorted = measureSortTime(sortedArray, "advanced");

            int target = sortedArray[size / 2];
            long searchTime = measureSearchTime(sortedArray, target);

            System.out.println("Random Array:");
            System.out.println("Basic Sort Time: " + basicRandom + " ns");
            System.out.println("Advanced Sort Time: " + advancedRandom + " ns");

            System.out.println("Sorted Array:");
            System.out.println("Basic Sort Time: " + basicSorted + " ns");
            System.out.println("Advanced Sort Time: " + advancedSorted + " ns");

            System.out.println("Search Time (target " + target + "): " + searchTime + " ns");
        }
    }
}

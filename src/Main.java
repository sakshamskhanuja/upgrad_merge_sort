public class Main {

    public static void main(String[] args) {
        int[] array = {6, 5, 4, 3, 2, 1};

        // Prints the contents of an unsorted array.
        printArray(array);

        // Sorts an array using Merge sort.
        mergeSort(array);

        // Prints the sorted array.
        printArray(array);
    }

    /**
     * Prints the contents of an integer array.
     *
     * @param array is an integer array.
     */
    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Sorts an array using the Merge sort algorithm.
     *
     * @param array is an unsorted array.
     */
    private static void mergeSort(int[] array) {
        // Stores the array length.
        int length = array.length;

        // Checks if array is already sorted -> contains only a single element.
        if (length < 2) {
            return;
        }

        // Stores the middle index.
        int middleIndex = length / 2;

        // Initializing the left and right half array.
        int[] leftHalf = new int[middleIndex];
        int[] rightHalf = new int[length - middleIndex];

        // Filling up the left half.
        for (int i = 0; i < middleIndex; i++) {
            leftHalf[i] = array[i];
        }

        // Filling up the right half.
        for (int i = middleIndex; i < length; i++) {
            rightHalf[i - middleIndex] = array[i];
        }

        // Dividing left and right half array until length reaches to 1.
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Merging left and right half.
        merge(array, leftHalf, rightHalf);
    }

    /**
     * Merges two arrays while sorting their contents.
     *
     * @param array     is the original array from which the leftHalf and rightHalf were created.
     * @param leftHalf  is left half array.
     * @param rightHalf is the right half array.
     */
    private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        // Iterator for the left half.
        int i = 0;

        // Iterator for the right half.
        int j = 0;

        // Iterator for the sorted array.
        int k = 0;

        // Stores the length of leftHalf array.
        int leftSize = leftHalf.length;

        // Stores the length of rightHalf array.
        int rightSize = rightHalf.length;

        // Merging while sorting.
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            } else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        // Filling up the array with left out values from the left half.
        while (i < leftSize) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }

        // Filling up the array with left out values from the right half.
        while (j < rightSize) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}

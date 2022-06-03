public class CeilingOfNumber {
    public static char binarySearch(char[] array, char searchElement) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int middle = (startIndex + endIndex) / 2;
//        int ceil = array[middle];
        if ( array[endIndex] < searchElement ) {
            return array[startIndex];
        }
        while (startIndex <= endIndex) {
            if ( array[startIndex] < array[endIndex] ) {
                if ( array[middle] < searchElement ) {
                    startIndex = middle + 1;
//                    ceil = array[middle];
                    middle = (startIndex + endIndex) / 2;
                } else if ( array[middle] > searchElement ) {
                    endIndex = middle - 1;
//                    ceil = array[middle];
                    middle = (startIndex + endIndex) / 2;
                } else {
                    return array[middle];
                }
            } else {
                if ( array[middle] < searchElement ) {
                    startIndex = middle - 1;
//                    ceil = array[middle];
                    middle = (startIndex + endIndex) / 2;
                } else if ( array[middle] > searchElement ) {
                    endIndex = middle + 1;
//                    ceil = array[middle];
                    middle = (startIndex + endIndex) / 2;
                } else {
                    return array[middle];
                }
            }
        }
        return array[startIndex];
    }

    public static void main(String[] args) {
        int[] testArr = {100, 90, 17, 16, 4, 3, 2, 1, -19};
        char[] testArr1 = {'c', 'e', 'k', 't'};
//        int start = 0;
//        System.out.println(testArr1[start]);
//        System.out.println(binarySearch( testArr1, 'd' ));
        System.out.println( 1 % 100 );
//        System.out.println((6+7)/2);1
    }
}

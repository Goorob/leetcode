package Kickstart.Year_2020.Round_A;

public class Plates {
    public static void main(String[] args) {
        int[] soln = new int[]{
                getMaxBeauty(new int[][]{
                                new int[]{80, 80},
                                new int[]{15, 50},
                                new int[]{20, 10}
                        }, 3
                ),

                getMaxBeauty(new int[][]{
                                new int[]{10, 10, 100, 30},
                                new int[]{80, 50, 10, 50}
                        }, 5
                )
        };

        for (int sol : soln)
            System.out.println(sol);
    }

    private static int getMaxBeauty(int[][] plates, int nop) {
        int noOfStacks = plates.length;
        int beautyValue = 0;

        for (int i = 0; i < noOfStacks; i++) {
            int maxPlateIdx = getMaxPlateIndex(plates[i]);
            int lastPlateIdx = plates[i].length - 1;
            int noOfPlates = plates[i].length;

            if (maxPlateIdx == 0) {
                // Plate is at the top
                for (int j = 0; j < noOfPlates && nop > 0; j++, nop--) {
                    beautyValue += plates[i][j];
                }
            } else {
                for (int j = maxPlateIdx; j >= 0 && nop > 0 && maxPlateIdx != lastPlateIdx; j--, nop--) {
                    beautyValue += plates[i][j];
                }
            }
        }

        return beautyValue;
    }

    private static int getMaxPlateIndex(int[] plates) {
        int maxValue = Integer.MIN_VALUE;
        int maxValIdx = Integer.MAX_VALUE;

        for (int i = 0; i < plates.length; i++) {
            if (plates[i] > maxValue) {
                maxValue = plates[i];
                maxValIdx = i;
            }
        }
        return maxValIdx;
    }
}

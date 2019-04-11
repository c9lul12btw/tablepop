package io.github.c9lul12btw;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static int MINIMUM_STOC = 500;
    private static int MAXIMUM_STOC = 2000;

    private static int MINIMUM_PLOTS = 6;
    private static int MAXIMUM_PLOTS = 15;

    private static int MINIMUM_SCORE = 5;
    private static int MAXIMUM_SCORE = 10;

    private static double[][] seed;

    public static void main(String[] args) {

        System.out.format("\n%-10s%-10s%-10s%-10s%-10s","Rating","Total","Number","Score","STOC");
        System.out.format("\n%-10s%-10s%-10s%-10s%-10s\n\n","","STOC","of Plots","per Plot","per Plot");
        seed = new double[50][50];

        for (int i = 0; i < 50; i++) {
            int RANDOM_STOC = ThreadLocalRandom.current().nextInt(MINIMUM_STOC, MAXIMUM_STOC + 1);
            int RANDOM_PLOTS = ThreadLocalRandom.current().nextInt(MINIMUM_PLOTS, MAXIMUM_PLOTS + 1);
            double RANDOM_SCORE = ThreadLocalRandom.current().nextInt(MINIMUM_SCORE, MAXIMUM_SCORE + 1);

            int STOC_PER_PLOT = RANDOM_STOC / RANDOM_PLOTS;
            double RATING = (RANDOM_STOC * STOC_PER_PLOT) * (RANDOM_SCORE / 1000);

            double[] player = new double[]{RATING, RANDOM_STOC, RANDOM_PLOTS, RANDOM_SCORE, STOC_PER_PLOT};
            seed[i] = player;
        }

        Arrays.sort(seed, (o1, o2) -> Double.compare(o2[0], o1[0]));

        for (double[] player : seed) {
            System.out.format("%-10.2f%-10.2f%-10.2f%-10.2f%-10.2f\n", player[0], player[1], player[2], player[3], player[4]);
        }
    }
}

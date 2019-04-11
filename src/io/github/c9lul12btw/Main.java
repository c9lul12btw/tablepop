package io.github.c9lul12btw;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        realisticRating();
    }

    public static void basicRating() {

        System.out.format("\n%-10s%-10s%-10s%-10s%-10s","Rating","Total","Number","Score","STOC");
        System.out.format("\n%-10s%-10s%-10s%-10s%-10s\n\n","","STOC","of Plots","per Plot","per Plot");
        double[][] seed = new double[50][50];

        for (int i = 0; i < 50; i++) {

            int MINIMUM_STOC = 500;
            int MAXIMUM_STOC = 2000;
            int MAXIMUM_PLOTS = 15;
            int MINIMUM_PLOTS = 6;
            int MAXIMUM_SCORE = 10;
            int MINIMUM_SCORE = 5;

            double RANDOM_STOC = ThreadLocalRandom.current().nextDouble(MINIMUM_STOC, MAXIMUM_STOC + 1);
            int RANDOM_PLOTS = ThreadLocalRandom.current().nextInt(MINIMUM_PLOTS, MAXIMUM_PLOTS + 1);
            double RANDOM_SCORE = ThreadLocalRandom.current().nextInt(MINIMUM_SCORE, MAXIMUM_SCORE + 1);

            double STOC_PER_PLOT = RANDOM_STOC / RANDOM_PLOTS;
            double RATING = (RANDOM_STOC * STOC_PER_PLOT) * (RANDOM_SCORE / 1000);

            double[] player = new double[]{RATING, RANDOM_STOC, RANDOM_PLOTS, RANDOM_SCORE, STOC_PER_PLOT};
            seed[i] = player;
        }

        Arrays.sort(seed, (o1, o2) -> Double.compare(o2[0], o1[0]));

        for (double[] player : seed) {
            System.out.format("%-10.2f%-10.2f%-10.2f%-10.2f%-10.2f\n", player[0], player[1], player[2], player[3], player[4]);
        }
    }

    public static void realisticRating() {
        System.out.format("\n%-10s%-10s%-10s%-10s%-10s","Rating","Total","Number","Score","STOC");
        System.out.format("\n%-10s%-10s%-10s%-10s%-10s\n\n","","STOC","of Plots","per Plot","per Plot");

        double[][] COLLECTION = new double[100][5];
        int TOTAL_STOC = 0;
        double AVERAGE_SCORE = 0;
        int PLOTS = 0;

        //high bracket
        for (int i = 0; i < 50; i++) {

            //Base 6
            TOTAL_STOC = (int) (novStoc(8, 10)[0] + appStoc(8, 10)[0] + desStoc(8, 10)[0] + arcStoc(8, 10)[0] + artStoc(8, 10)[0] + masStoc(8, 10)[0]);
            AVERAGE_SCORE = (novStoc(8, 10)[1] + appStoc(8, 10)[1] + desStoc(8, 10)[1] + arcStoc(8, 10)[1] + artStoc(8, 10)[1] + masStoc(8, 10)[1]) / 6;
            PLOTS = 6;

            double STOC_PER_PLOT = TOTAL_STOC / PLOTS;
            double RATING = (TOTAL_STOC * STOC_PER_PLOT) * (AVERAGE_SCORE / 1000);

            double[] PLAYER = new double[]{RATING, TOTAL_STOC, PLOTS, AVERAGE_SCORE, STOC_PER_PLOT};
            COLLECTION[i] = PLAYER;
        }
        //low bracket
        for (int i = 0; i < 50; i++) {

            //Base 6
            TOTAL_STOC = (int) (novStoc(5, 8)[0] + appStoc(5, 8)[0] + desStoc(5, 8)[0] + arcStoc(5, 8)[0] + artStoc(5, 8)[0] + masStoc(5, 8)[0]);
            AVERAGE_SCORE = (novStoc(5, 8)[1] + appStoc(5, 8)[1] + desStoc(5, 8)[1] + arcStoc(5, 8)[1] + artStoc(5, 8)[1] + masStoc(5, 8)[1]) / 6;
            PLOTS = 6;

            double STOC_PER_PLOT = TOTAL_STOC / PLOTS;
            double RATING = (TOTAL_STOC * STOC_PER_PLOT) * (AVERAGE_SCORE / 1000);

            double[] PLAYER = new double[]{RATING, TOTAL_STOC, PLOTS, AVERAGE_SCORE, STOC_PER_PLOT};
            COLLECTION[i+50] = PLAYER;
        }

        Arrays.sort(COLLECTION, (o1, o2) -> Double.compare(o2[0], o1[0])); //order by rating

        for (double[] PLAYER : COLLECTION) {
            System.out.format("%-10.2f%-10.2f%-10.2f%-10.2f%-10.2f\n", PLAYER[0], PLAYER[1], PLAYER[2], PLAYER[3], PLAYER[4]);
        }


    }

    private static double[] novStoc(int min, int max) {
        int STOC_SCORE;
        int TOTAL_STOC = 0;
        double RANK_MULT = 1;
        for (int i = 0; i < 4; i++) {
            STOC_SCORE = ThreadLocalRandom.current().nextInt(min, max + 1);
            TOTAL_STOC = TOTAL_STOC + STOC_SCORE;
        }
        double AVERAGE_SCORE = TOTAL_STOC / 4;
        double CALC_STOC = TOTAL_STOC * RANK_MULT;
        return new double[]{CALC_STOC, AVERAGE_SCORE};
    }

    private static double[] appStoc(int min, int max) {
        int STOC_SCORE;
        int TOTAL_STOC = 0;
        double RANK_MULT = 2.4;
        for (int i = 0; i < 4; i++) {
            STOC_SCORE = ThreadLocalRandom.current().nextInt(min, max + 1);
            TOTAL_STOC = TOTAL_STOC + STOC_SCORE;
        }
        double AVERAGE_SCORE = TOTAL_STOC / 4;
        double CALC_STOC = TOTAL_STOC * RANK_MULT;
        return new double[]{CALC_STOC, AVERAGE_SCORE};
    }

    private static double[] desStoc(int min, int max) {
        int STOC_SCORE;
        int TOTAL_STOC = 0;
        double RANK_MULT = 4;
        for (int i = 0; i < 4; i++) {
            STOC_SCORE = ThreadLocalRandom.current().nextInt(min, max + 1);
            TOTAL_STOC = TOTAL_STOC + STOC_SCORE;
        }
        double AVERAGE_SCORE = TOTAL_STOC / 4;
        double CALC_STOC = TOTAL_STOC * RANK_MULT;
        return new double[]{CALC_STOC, AVERAGE_SCORE};
    }

    private static double[] arcStoc(int min, int max) {
        int STOC_SCORE;
        int TOTAL_STOC = 0;
        double RANK_MULT = 7.2;
        for (int i = 0; i < 4; i++) {
            STOC_SCORE = ThreadLocalRandom.current().nextInt(min, max + 1);
            TOTAL_STOC = TOTAL_STOC + STOC_SCORE;
        }
        double AVERAGE_SCORE = TOTAL_STOC / 4;
        double CALC_STOC = TOTAL_STOC * RANK_MULT;
        return new double[]{CALC_STOC, AVERAGE_SCORE};
    }

    private static double[] artStoc(int min, int max) {
        int STOC_SCORE;
        int TOTAL_STOC = 0;
        double RANK_MULT = 9.6;
        for (int i = 0; i < 4; i++) {
            STOC_SCORE = ThreadLocalRandom.current().nextInt(min, max + 1);
            TOTAL_STOC = TOTAL_STOC + STOC_SCORE;
        }
        double AVERAGE_SCORE = TOTAL_STOC / 4;
        double CALC_STOC = TOTAL_STOC * RANK_MULT;
        return new double[]{CALC_STOC, AVERAGE_SCORE};
    }

    private static double[] masStoc(int min, int max) {
        int STOC_SCORE;
        int TOTAL_STOC = 0;
        double RANK_MULT = 16.1;
        for (int i = 0; i < 4; i++) {
            STOC_SCORE = ThreadLocalRandom.current().nextInt(min, max + 1);
            TOTAL_STOC = TOTAL_STOC + STOC_SCORE;
        }
        double AVERAGE_SCORE = TOTAL_STOC / 4;
        double CALC_STOC = TOTAL_STOC * RANK_MULT;
        return new double[]{CALC_STOC, AVERAGE_SCORE};
    }
}

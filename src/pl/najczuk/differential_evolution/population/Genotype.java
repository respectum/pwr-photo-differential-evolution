package pl.najczuk.differential_evolution.population;

import java.util.Random;

/**
 * User: Adrian
 * Date: 12/31/2014
 * Time: 10:24
 */
public class Genotype {
    private double brightness, contrast, r, g, b;
    private double gammaR, gammaG, gammaB;
    public static final int DIFFERENTIAL_CROSSOVER = 0, ADDITIVE_CROSSOVER = 1;
    public static final double
            C_MIN = 0.6, C_MAX = 1.5,
            B_MIN = -20, B_MAX = 20,
            RGB_MIN = -20, RGB_MAX = 20,
            GAMMA_MIN = 0.9, GAMMA_MAX = 1.1;

    /**
     * Constructor for given genotype parameters
     *
     * @param brightness
     * @param contrast
     * @param r
     * @param g
     * @param b
     * @param gammaR
     * @param gammaG
     * @param gammaB
     */
    public Genotype(float brightness, float contrast, float r, float g, float b, double gammaR, double gammaG, double
            gammaB) {
        this.brightness = brightness;
        this.contrast = contrast;
        this.r = r;
        this.g = g;
        this.b = b;
        this.gammaR = gammaR;
        this.gammaG = gammaG;
        this.gammaB = gammaB;
    }

    /**
     * Constructor for random genotype using gaussian distribution
     */
    public Genotype() {

        Random random = new Random();
        this.brightness =  getRandomValue();
        this.contrast = getRandomValue();
        this.r =  getRandomValue();
        this.g =  getRandomValue();
        this.b = getRandomValue();
        this.gammaR =  getRandomValue();
        this.gammaG =  getRandomValue();
        this.gammaB =  getRandomValue();
    }

    /**
     * @param g1             first genotype used for creation from crossover
     * @param g2             second genotype used for creation from crossover
     * @param flag type of crossover to be used DIFFERENTIAL_CROSSOVER or ADDITIVE_CROSSOVER
     */
    public Genotype(Genotype g1, Genotype g2, int flag) {
            this.brightness = flag==ADDITIVE_CROSSOVER ? addGenomes(g1.getBrightness(),g2.getBrightness())
                    :diffGenomes(g1.getBrightness(),g2.getBrightness());

            this.contrast = flag==ADDITIVE_CROSSOVER ? addGenomes(g1.getContrast(),g2.getContrast())
                    :diffGenomes(g1.getContrast(),g2.getContrast());

            this.r = flag==ADDITIVE_CROSSOVER ? addGenomes(g1.getR(),g2.getR())
                    :diffGenomes(g1.getR(),g2.getR());

            this.g = flag==ADDITIVE_CROSSOVER ? addGenomes(g1.getG(),g2.getG())
                    :diffGenomes(g1.getG(),g2.getG());

            this.b = flag==ADDITIVE_CROSSOVER ? addGenomes(g1.getB(),g2.getB())
                    :diffGenomes(g1.getB(),g2.getB());

            this.gammaR = flag==ADDITIVE_CROSSOVER ? addGenomes(g1.getGammaR(),g2.getGammaR())
                    :diffGenomes(g1.getGammaR(),g2.getGammaR());

            this.gammaG = flag==ADDITIVE_CROSSOVER ? addGenomes(g1.getGammaG(),g2.getGammaG())
                    :diffGenomes(g1.getGammaG(),g2.getGammaG());

            this.gammaB = flag==ADDITIVE_CROSSOVER ? addGenomes(g1.getGammaB(),g2.getGammaB())
                    :diffGenomes(g1.getGammaB(),g2.getGammaB());
    }

    public static double getRandomValue(){
        Random random = new Random();
        double value = -1;
        while (value<0 || value>1) {
            value = random.nextGaussian() * 0.5 + 0.5;
        }
        return value;
    }

    private double addGenomes(double g1, double g2){
        double sum = g1+g2 >1 ? 1 : g1+g2;
        return sum;
    }
    private double diffGenomes(double g1, double g2){
        double diff = g1-g2 <0 ? 0 : g1-g2;
        return diff;
    }

    @Override
    public String toString() {
        return "Genotype{" +
                "brightness=" + brightness +
                ", contrast=" + contrast +
                ", r=" + r +
                ", g=" + g +
                ", b=" + b +
                ", gammaR=" + gammaR +
                ", gammaG=" + gammaG +
                ", gammaB=" + gammaB +
                '}';
    }

    public double getBrightness() {
        return brightness;
    }

    public double getContrast() {
        return contrast;
    }

    public double getR() {
        return r;
    }

    public double getG() {
        return g;
    }

    public double getB() {
        return b;
    }

    public double getGammaR() {
        return gammaR;
    }

    public double getGammaG() {
        return gammaG;
    }

    public double getGammaB() {
        return gammaB;
    }
}
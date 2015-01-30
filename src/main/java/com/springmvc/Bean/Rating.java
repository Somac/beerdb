package com.springmvc.Bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Rating {

    private int overallRating;
    private int amountOfRaters;
    private double averageRate;

    public int getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(int overallRating) {
        this.overallRating = overallRating;
    }

    public int getAmountOfRaters() {
        return amountOfRaters;
    }

    public void setAmountOfRaters(int amountOfRaters) {
        this.amountOfRaters = amountOfRaters;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void calculateAverageRate() {
        if(this.overallRating > 0){
            this.averageRate = this.overallRating/(double)this.amountOfRaters;

            BigDecimal bd = new BigDecimal(this.averageRate);
            bd = bd.setScale(1, RoundingMode.HALF_UP);

            this.averageRate = bd.doubleValue();
        }
    }
}

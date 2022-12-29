package com.personal_projects.currencyExchange.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashMap;

/*
Currency model class that takes the base currency used in the exchange as well as date the info was accessed,
with corresponding rates.
 */
public class currency {

    private String base;
    private LocalDate date;
    //@NotNull(message = "Rate must not be blank")
    private HashMap<String, Float> rates = new HashMap<>();

    // default base = EUR
    public currency() {
    }

    // allows for getting rates by date
    public currency(LocalDate date, HashMap<String, Float> rates) {
        this.date = date;
        this.rates = rates;
    }

    // allows for getting rates by date and by base
    public currency(String base, LocalDate date, HashMap<String, Float> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public HashMap<String, Float> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, Float> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "exchange{" +
                "base='" + base + '\'' +
                ", date=" + date +
                ", rates=" + rates +
                '}';
    }
}

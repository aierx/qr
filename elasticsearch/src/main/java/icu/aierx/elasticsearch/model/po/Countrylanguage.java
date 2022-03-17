package icu.aierx.elasticsearch.model.po;

import java.math.BigDecimal;

/**
 * @author leiwenyong
 * @since 2022/3/17
 */
public class Countrylanguage {
    private String countrycode;

    private String language;

    private Object isofficial;

    private BigDecimal percentage;

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Object getIsofficial() {
        return isofficial;
    }

    public void setIsofficial(Object isofficial) {
        this.isofficial = isofficial;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }
}
package icu.aierx.elasticsearch.model.po;

import java.math.BigDecimal;

/**
 * @author leiwenyong
 * @since 2022/3/17
 */
public class Country {
    private String code;

    private String name;

    private Object continent;

    private String region;

    private BigDecimal surfacearea;

    private Short indepyear;

    private Integer population;

    private BigDecimal lifeexpectancy;

    private BigDecimal gnp;

    private BigDecimal gnpold;

    private String localname;

    private String governmentform;

    private String headofstate;

    private Integer capital;

    private String code2;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getContinent() {
        return continent;
    }

    public void setContinent(Object continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getSurfacearea() {
        return surfacearea;
    }

    public void setSurfacearea(BigDecimal surfacearea) {
        this.surfacearea = surfacearea;
    }

    public Short getIndepyear() {
        return indepyear;
    }

    public void setIndepyear(Short indepyear) {
        this.indepyear = indepyear;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public BigDecimal getLifeexpectancy() {
        return lifeexpectancy;
    }

    public void setLifeexpectancy(BigDecimal lifeexpectancy) {
        this.lifeexpectancy = lifeexpectancy;
    }

    public BigDecimal getGnp() {
        return gnp;
    }

    public void setGnp(BigDecimal gnp) {
        this.gnp = gnp;
    }

    public BigDecimal getGnpold() {
        return gnpold;
    }

    public void setGnpold(BigDecimal gnpold) {
        this.gnpold = gnpold;
    }

    public String getLocalname() {
        return localname;
    }

    public void setLocalname(String localname) {
        this.localname = localname;
    }

    public String getGovernmentform() {
        return governmentform;
    }

    public void setGovernmentform(String governmentform) {
        this.governmentform = governmentform;
    }

    public String getHeadofstate() {
        return headofstate;
    }

    public void setHeadofstate(String headofstate) {
        this.headofstate = headofstate;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }
}
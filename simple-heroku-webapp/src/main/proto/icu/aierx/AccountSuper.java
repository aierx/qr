package icu.aierx;

import java.io.Serializable;

/**
 * @author leiwenyong
 * @since 2022-05-15
 */
public class AccountSuper implements Serializable {
    private static final long serialVersionUID = -5032297829866299015L;

    String father;

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }
}

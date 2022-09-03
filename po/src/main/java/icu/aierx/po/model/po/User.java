package icu.aierx.po.model.po;

/**
 * @author leiwenyong
 * @since 2022-06-04
 */
@Deprecated
public class User extends UserPO implements Cloneable, Lei {
    private Integer num1 = 1;
    private Float num2 = 2f;
    private Long num3 = 3L;
    private Double num4 = 4d;
    @Deprecated
    private  String string1 = "leiwenyong";

    @Deprecated
    public User() {
    }

    public User(Integer num1, Float num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    @Deprecated
    int add(@Deprecated Integer a, Integer b) {
        int c = a;
        Long d = 1L;
        if (c>0){
            return 0;
        }
        return a + b;
    }

    int sub(int a,int b){
        return a-b;
    }
}

package icu.aierx.elasticsearch.base;

/**
 * @author leiwenyong
 * @since 2022/3/17
 */
public enum Status {
    SUCCESS("success","成功"),
    FAILURE("failure","失败");


    private String value;

    private String desc;

    Status(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

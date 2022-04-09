package icu.aierx.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}

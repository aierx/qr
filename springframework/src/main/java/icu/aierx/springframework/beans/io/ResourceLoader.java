package icu.aierx.springframework.beans.io;

import java.net.URL;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public class ResourceLoader {
    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}

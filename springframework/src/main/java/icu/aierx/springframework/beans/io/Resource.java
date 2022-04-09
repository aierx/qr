package icu.aierx.springframework.beans.io;

import java.io.InputStream;

/**
 * @author leiwenyong
 * @since 2022/3/12
 */
public interface Resource {
    InputStream getInputStream() throws Exception;
}

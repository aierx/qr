package icu.aierx.server.connector;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.Flushable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * @author leiwenyong
 * @since 2022/4/23
 */
public interface ServletResponseAdapter extends ServletResponse, AutoCloseable, Flushable {
    @Override
    default String getCharacterEncoding() {
        return null;
    }

    @Override
    default String getContentType() {
        return null;
    }

    @Override
    default ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    default PrintWriter getWriter() throws IOException {
        return null;
    }

    @Override
    default void setCharacterEncoding(String charset) {

    }

    @Override
    default void setContentLength(int len) {

    }

    @Override
    default void setContentLengthLong(long len) {

    }

    @Override
    default void setContentType(String type) {

    }

    @Override
    default void setBufferSize(int size) {

    }

    @Override
    default int getBufferSize() {
        return 0;
    }

    @Override
    default void flushBuffer() throws IOException {

    }

    @Override
    default void resetBuffer() {

    }

    @Override
    default boolean isCommitted() {
        return false;
    }

    @Override
    default void reset() {

    }

    @Override
    default void setLocale(Locale loc) {

    }

    @Override
    default Locale getLocale() {
        return null;
    }
}

package icu.aierx.server.connector;

import javax.servlet.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * @author leiwenyong
 * @since 2022/4/23
 */
public interface ServletRequestAdapter extends AutoCloseable, ServletRequest {
    @Override
    default Object getAttribute(String name) {
        return null;
    }

    @Override
    default Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    default String getCharacterEncoding() {
        return null;
    }

    @Override
    default void setCharacterEncoding(String env) throws UnsupportedEncodingException {

    }

    @Override
    default int getContentLength() {
        return 0;
    }

    @Override
    default long getContentLengthLong() {
        return 0;
    }

    @Override
    default String getContentType() {
        return null;
    }

    @Override
    default ServletInputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    default String getParameter(String name) {
        return null;
    }

    @Override
    default Enumeration<String> getParameterNames() {
        return null;
    }

    @Override
    default String[] getParameterValues(String name) {
        return new String[0];
    }

    @Override
    default Map<String, String[]> getParameterMap() {
        return null;
    }

    @Override
    default String getProtocol() {
        return null;
    }

    @Override
    default String getScheme() {
        return null;
    }

    @Override
    default String getServerName() {
        return null;
    }

    @Override
    default int getServerPort() {
        return 0;
    }

    @Override
    default BufferedReader getReader() throws IOException {
        return null;
    }

    @Override
    default String getRemoteAddr() {
        return null;
    }

    @Override
    default String getRemoteHost() {
        return null;
    }

    @Override
    default void setAttribute(String name, Object o) {

    }

    @Override
    default void removeAttribute(String name) {

    }

    @Override
    default Locale getLocale() {
        return null;
    }

    @Override
    default Enumeration<Locale> getLocales() {
        return null;
    }

    @Override
    default boolean isSecure() {
        return false;
    }

    @Override
    default RequestDispatcher getRequestDispatcher(String path) {
        return null;
    }

    @Override
    default String getRealPath(String path) {
        return null;
    }

    @Override
    default int getRemotePort() {
        return 0;
    }

    @Override
    default String getLocalName() {
        return null;
    }

    @Override
    default String getLocalAddr() {
        return null;
    }

    @Override
    default int getLocalPort() {
        return 0;
    }

    @Override
    default ServletContext getServletContext() {
        return null;
    }

    @Override
    default AsyncContext startAsync() throws IllegalStateException {
        return null;
    }

    @Override
    default AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        return null;
    }

    @Override
    default boolean isAsyncStarted() {
        return false;
    }

    @Override
    default boolean isAsyncSupported() {
        return false;
    }

    @Override
    default AsyncContext getAsyncContext() {
        return null;
    }

    @Override
    default DispatcherType getDispatcherType() {
        return null;
    }
}

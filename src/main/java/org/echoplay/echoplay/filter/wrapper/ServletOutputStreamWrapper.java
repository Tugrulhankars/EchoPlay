package org.echoplay.echoplay.filter.wrapper;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ServletOutputStreamWrapper extends ServletOutputStream {

    private final ServletOutputStream outputStream;
    private final ByteArrayOutputStream copy = new ByteArrayOutputStream();

    public ServletOutputStreamWrapper(ServletOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
        copy.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        outputStream.write(b, off, len);
        copy.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        outputStream.flush();
        copy.flush();
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
        copy.close();
    }

    @Override
    public boolean isReady() {
        return outputStream.isReady();
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        outputStream.setWriteListener(writeListener);
    }

    public byte[] getCopy() {
        return copy.toByteArray();
    }
}

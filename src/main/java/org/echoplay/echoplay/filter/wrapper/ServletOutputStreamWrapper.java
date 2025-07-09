package org.echoplay.echoplay.filter.wrapper;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ServletOutputStreamWrapper extends ServletOutputStream {
    private final OutputStream outputStream;
    private final ByteArrayOutputStream copy;
    public ServletOutputStreamWrapper(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.copy = new ByteArrayOutputStream(); // ByteArrayOutputStream'i başlatıyoruz.
    }
    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
        copy.write(b);

    }
    public byte[] getCopy() {
        return copy.toByteArray();
    }
}

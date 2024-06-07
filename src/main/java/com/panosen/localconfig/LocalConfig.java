package com.panosen.localconfig;

import java.io.IOException;
import java.io.InputStream;

public abstract class LocalConfig {

    protected final String fileName;

    public LocalConfig(String fileName) {
        this.fileName = fileName;
    }

    protected InputStream getInputStream() throws IOException {
        String newFileName = fileName.startsWith("/") ? fileName : "/" + fileName;
        return this.getClass().getResourceAsStream(newFileName);
    }
}

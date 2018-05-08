package com.example.lijie.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @Description 当从流中获取参数之后还需继续使用，则将用此类将request封装一次。
 * @Author 李杰 lijie@ane56.com
 * @Date 2018/5/8 下午5:35
 */
public class BodyReaderRequestWrapper extends HttpServletRequestWrapper {
    private byte[] body;
    private final Charset charset; // 默认为UTF-8
    private static final Logger logger = LoggerFactory.getLogger(BodyReaderRequestWrapper.class);
    public BodyReaderRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        this.charset = Charset.forName(request.getCharacterEncoding() == null ? "UTF-8" : request.getCharacterEncoding());
        body = this.getBodyString(request).getBytes(charset);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        return new ServletInputStream() {
            private ReadListener readListener;
            private int lastIndexRetrieved = -1;

            @Override
            public int read() throws IOException {
                if(isFinished()) {
                    if(readListener != null) {
                        readListener.onAllDataRead();
                    }
                    return -1;
                }
                return body[lastIndexRetrieved++ + 1];
            }

            @Override
            public boolean isFinished() {
                return this.lastIndexRetrieved == body.length - 1;
            }

            @Override
            public boolean isReady() {
                return isFinished();
            }

            @Override
            public void setReadListener(ReadListener readListener) {
                if (readListener == null) {
                    throw new IllegalArgumentException("readListener can not be null");
                }
                if (this.readListener != null) {
                    throw new IllegalArgumentException("readListener has been set");
                }
                this.readListener = readListener;
                if (isFinished()) {
                    try {
                        this.readListener.onAllDataRead();
                    } catch (IOException e) {
                        this.readListener.onError(e);
                    }
                } else {
                    try {
                        this.readListener.onDataAvailable();
                    } catch (IOException e) {
                        this.readListener.onError(e);
                    }
                }
            }
        };
    }

    public String getBodyString() {
        return new String(body, charset);
    }

    public void setBody(String bodyString) {
        this.body = bodyString.getBytes(charset);
    }

    private String getBodyString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        try (InputStream inputStream = request.getInputStream();
             InputStreamReader streamReader = new InputStreamReader(inputStream, charset);
             BufferedReader reader = new BufferedReader(streamReader) ) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
        	logger.error(e.getMessage(),e);
//            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
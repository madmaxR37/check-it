package com.example.checkit.utils;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Path;

public class BufferedImageMultipartFile implements MultipartFile {
    
    private final byte[] bytes;
    
    private final String name;
    
    private final String contentType;

    public BufferedImageMultipartFile(BufferedImage image, String name, String contentType) {
        this.name = name;
        this.contentType = contentType;
        try(ByteArrayOutputStream boas = new ByteArrayOutputStream()){
            ImageIO.write(image,"jpg", boas);
            this.bytes = boas.toByteArray();
        }catch (IOException e){
            throw new  RuntimeException("Failed to convert BufferImage", e);
        }
    }
    


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getOriginalFilename() {
        return this.name;
    }

    @Override
    public String getContentType() {
        return this.contentType;
    }

    @Override
    public boolean isEmpty() {
        return this.bytes.length==0;
    }

    @Override
    public long getSize() {
        return bytes.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return this.bytes;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(this.bytes);
    }

    @Override
    public Resource getResource() {
        return MultipartFile.super.getResource();
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {

    }

    @Override
    public void transferTo(Path dest) throws IOException, IllegalStateException {
        MultipartFile.super.transferTo(dest);
    }
}

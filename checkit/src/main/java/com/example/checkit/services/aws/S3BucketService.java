package com.example.checkit.services.aws;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class S3BucketService {

    private final String bucketName;

    private final AmazonS3Client s3Client;

    private final String endpoint;

    public S3BucketService(@Value("${aws.s3.bucket-name}") String bucketName, AmazonS3Client s3Client,@Value("${aws.s3.endpoint}") String endpoint) {
        this.bucketName = bucketName;
        this.s3Client = s3Client;
        this.endpoint = endpoint;
    }
    public String uploadFile(MultipartFile file){
        String fileName = UUID.randomUUID().toString() + '_' + "check-it_image";
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());

        try (InputStream inputStream = file.getInputStream()){

            s3Client.putObject(new PutObjectRequest(bucketName,fileName,inputStream,metadata).withCannedAcl(
                    CannedAccessControlList.PublicRead
            ));
        }catch (IOException e){
            throw new RuntimeException("Error uploading the file to s3", e);
        }

        return getImageUrl(fileName);
    }

    private String getImageUrl(String fileName) {
        return endpoint+fileName;
    }
}

package com.example.checkit.configurations;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Value("${aws.access-key-id}")
    private String awsAccessKeyId;

    @Value("${aws.secret-access-key}")
    private String awsSecretAccessKey;

    @Value("${aws.region}")
    private String awsRegion;

    @Bean
    public AmazonS3Client amazonS3CLient(){
        AWSCredentials credentials = new BasicAWSCredentials(awsAccessKeyId,awsSecretAccessKey);
        AmazonS3ClientBuilder builder =AmazonS3ClientBuilder.standard().withCredentials(
                new AWSStaticCredentialsProvider(credentials)
        ).withRegion(awsRegion);
        return (AmazonS3Client) builder.build();
    }
}

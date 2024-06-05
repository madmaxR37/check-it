package com.example.checkit.services.externalServices;

import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.models.OrderEntity;
import com.example.checkit.repositories.OrderRepository;
import com.example.checkit.utils.BufferedImageMultipartFile;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;


@Service
public class QRGeneratorService {

    private final S3BucketService bucketService;

    private final OrderRepository orderRepository;

    public QRGeneratorService(S3BucketService bucketService, OrderRepository orderRepository) {
        this.bucketService = bucketService;
        this.orderRepository = orderRepository;
    }

    public void generateQRCode(Long id, int width, int height)throws WriterException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(String.valueOf(id), BarcodeFormat.QR_CODE, width, height );

        BufferedImage image= MatrixToImageWriter.toBufferedImage(bitMatrix);
        MultipartFile file = new BufferedImageMultipartFile(image,"qrcode","image/jpg");

        String url = bucketService.uploadFile(file);

       Optional<OrderEntity> orderOptional = orderRepository.findById(id);
       if (orderOptional.isEmpty()){
           throw new EntityNotFoundException("Order doesn't exist", HttpStatus.NOT_FOUND);
       }
       OrderEntity orderEntity = orderOptional.get();
       orderEntity.setQrCode(url);
       orderRepository.save(orderEntity);
    }
}

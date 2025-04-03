package pl.knap.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import pl.knap.shop.admin.product.service.AdminProductImageService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageInitializer {

    private final AdminProductImageService imageService;

    @Value("classpath:images/*")
    private Resource[] resources;

    @Value("${app.uploadDir}")
    private String uploadDir;

    public ImageInitializer(AdminProductImageService imageService) {
        this.imageService = imageService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        for (Resource resource : resources) {
            try (InputStream inputStream = resource.getInputStream()) {
                String filename = resource.getFilename();
                Path targetPath = Paths.get(uploadDir, filename);
                if (filename != null && Files.notExists(targetPath)) {
                    imageService.uploadImage(filename, inputStream);
                    System.out.println("Uploaded: " + filename);
                }
            } catch (IOException e) {
                System.err.println("Failed to upload: " + resource.getFilename());
            }
        }
    }
}

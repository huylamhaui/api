package lamph11.api.router;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lamph11.api.service.FileService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/file")
@AllArgsConstructor
public class FileResource {

    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile file) {
        try {
            String id = fileService.uploadFile(file);
            return ResponseEntity.ok(id);
        }catch(Throwable t) {
            return ResponseEntity.badRequest().body(t);
        }
    }
    

    @GetMapping("/download")
    public void getFile(@RequestParam String fileId, HttpServletResponse response) {
        try {
            InputStream in = fileService.getFile(fileId);
            FileCopyUtils.copy(in, response.getOutputStream());
        }catch(Throwable t) {
            t.printStackTrace();
        }
    }
}

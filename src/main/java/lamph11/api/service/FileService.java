package lamph11.api.service;

import java.io.InputStream;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations gridFsOperations;
    
    public String uploadFile(MultipartFile file) {
        try{
            DBObject metaData = new BasicDBObject();
            metaData.put("type", "video");
            metaData.put("title", file.getOriginalFilename());

            ObjectId id = gridFsTemplate.store(
                file.getInputStream(),
                file.getName(),
                file.getContentType(),
                metaData
            );
            return id.toString();
        }catch(Exception e) {
            return null;
        }
    }


    public InputStream getFile(String fileId) {
        try {
            GridFSFile file = gridFsTemplate.findOne(
                new Query(Criteria.where("_id").is(fileId))
            );
            return gridFsOperations.getResource(file).getInputStream();
        }catch(Exception e) {
            return null;
        }
    }
}

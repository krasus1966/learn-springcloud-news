package top.krasus1966.news.controller;

import cn.hutool.core.util.StrUtil;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsObject;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.krasus1966.news.enums.ResultsEnum;
import top.krasus1966.news.exception.CommonException;
import top.krasus1966.news.result.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;


/**
 * @author Krasus1966
 * @date 2020/11/15 15:23
 **/
@RestController
@RequestMapping("/resource")
@Slf4j
public class UploadController {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @PostMapping("/upload")
    public R<String> upload(@RequestParam("files") MultipartFile[] files) {
        try {
            if (null == files || files.length == 0) {
                return R.parse(ResultsEnum.NO_UPLOAD_FILE);
            }
            List<String> idList = new ArrayList<>();
            for (MultipartFile file : files) {
                ObjectId objectId = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType());
                String id = objectId.toString();
                idList.add(id);
            }
            return R.parse(ResultsEnum.SUCCESS, idList);
        } catch (Exception e) {
            log.error("/resource/upload ERROR", e);
            return R.parse(ResultsEnum.FAILED);
        }
    }

    @RequestMapping("/download")
    public void download(@RequestParam("fileId") String fileId, HttpServletResponse resp) {
        if (StrUtil.isEmpty(fileId)) {
            R.error(ResultsEnum.PARAM_NOT_VALID);
        }
        Query query = Query.query(Criteria.where("_id").is(fileId));
        GridFSFile gridFsFile = gridFsTemplate.findOne(query);
        if (null == gridFsFile) {
            R.error(ResultsEnum.UPLOAD_FILE_NOT_EXIST);
        }
        try {
            GridFsResource gridFsResource = gridFsTemplate.getResource(gridFsFile);
            resp.setContentType(gridFsResource.getContentType());
            resp.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(Objects.requireNonNull(gridFsResource.getFilename()),"UTF-8"));
            InputStream inputStream = gridFsResource.getInputStream();
            OutputStream outputStream = resp.getOutputStream();
            int length = -1;
            byte[] bs = new byte[1024];
            int len;
            while ((len = inputStream.read(bs)) != -1) {
                if (length > 0) {
                    if (length > len) {
                        outputStream.write(bs, 0, len);
                        outputStream.flush();
                        length -= len;
                    } else {
                        outputStream.write(bs, 0, (int) length);
                        outputStream.flush();
                        break;
                    }
                } else {
                    outputStream.write(bs, 0, len);
                }
            }
        } catch (Exception e) {
            log.error("/resource/download ERROR", e);
            throw new CommonException(ResultsEnum.SERVER_UNEXCEPTION_ERROR);
        }
    }
}

package top.krasus1966.news.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.krasus1966.news.enums.ResultsEnum;
import top.krasus1966.news.result.R;



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
    public R upload(MultipartFile[] file){
        try{
            return R.parse(ResultsEnum.SUCCESS);
        }catch (Exception e){
            log.error("/resource/upload ERROR",e);
            return R.parse(ResultsEnum.FAILED);
        }
    }
}

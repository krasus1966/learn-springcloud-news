package top.krasus1966.news.controller.api.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import top.krasus1966.news.result.R;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件上传下载Api
 *
 * @author Krasus1966
 * @date 2020/11/27 15:08
 **/
@Api(value = "文件上传下载",tags = {"文件上传下载"})
@RequestMapping("/resource")
public interface FileControllerApi {

    @ApiOperation(value = "文件上传",notes = "文件上传",httpMethod = "POST")
    @PostMapping("/upload")
    R<String> upload(@RequestParam("files") MultipartFile[] files);

    @ApiOperation(value = "文件下载",notes = "文件下载",httpMethod = "POST")
    @RequestMapping("/download")
    void download(@RequestParam("fileId") String fileId, HttpServletResponse resp);
}

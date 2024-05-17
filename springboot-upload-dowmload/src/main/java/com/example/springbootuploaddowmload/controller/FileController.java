package com.example.springbootuploaddowmload.controller;

import com.example.springbootuploaddowmload.utils.Result;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * 通用文件上传与下载
 *
 * @author CJW
 * @since 2023/9/22
 */
@RestController
@RequestMapping("/file")
public class FileController {
    /**
     * 文件上传
     *
     * @param uploadFiles 文件数组
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public Result<String> upload(@RequestParam MultipartFile[] uploadFiles) throws IOException {
        for (MultipartFile uploadFile : uploadFiles) {
            saveFile(uploadFile);
        }
        return Result.success("成功");
    }

    /**
     * 问价下载
     *
     * @param fileName 文件名
     * @param response
     * @throws IOException
     */
    @GetMapping("/download")
    public void download(@RequestParam String fileName, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        File file = new File("D:\\MyProject\\study\\springboot-upload-dowmload\\src\\main\\resources\\pictures\\" + fileName);
        ServletOutputStream outputStream;
        byte[] array;
        try {
            outputStream = response.getOutputStream();
            array = FileUtils.readFileToByteArray(file);
            outputStream.write(array);
            outputStream.flush();
            outputStream.close();
        } catch (IOException ignored) {
        }
    }

    /**
     * 单个文件上传
     *
     * @param uploadFile 一个文件
     * @throws IOException
     */
    private void saveFile(MultipartFile uploadFile) throws IOException {
        //获取原始文件名后缀并拼接uuid进行存储
        String originalFileName = uploadFile.getOriginalFilename();
        String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
        uploadFile.transferTo(new File("D:\\MyProject\\study\\springboot-upload-dowmload\\src\\main\\resources\\pictures\\" + fileName));
    }
}

package com.itheima.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;


@Controller
public class FileController {
    // 向文件上传页面跳转
    @GetMapping("/toUpload")
    public String toUpload() {
        return "upload";
    }

    // 文件上传管理
    @PostMapping("/uploadFile")
    public String uploadFile(List<MultipartFile> fileUpload, HttpServletRequest request, Model model) {
        model.addAttribute("uploadStatus", 1); // 默认文件上传成功(返回状态1)
        for (MultipartFile file : fileUpload) {
            String fileName = file.getOriginalFilename(); //获取文件名以及后缀名
            fileName = UUID.randomUUID() + "_" + fileName; //重新生成文件名（根据具体情况生成对应文件名）
            // 将文件上传到指定的服务器目录filePool
            String dirPath = request.getServletContext().getRealPath("/filePool/");
            File filePath = new File(dirPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath + fileName));//将文件转存到本地目标文件
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("uploadStatus", "上传失败： " + e.getMessage());//上传失败，返回状态信息
            }
        }
        return "upload";
    }

    // 向文件下载页面跳转
    @GetMapping("/toDownload")
    public String toDownload(HttpServletRequest request, Model model) {
        String path = request.getServletContext().getRealPath("/filePool/");
        File fileDir = new File(path);
        File filesList[] = fileDir.listFiles();//从指定目录获得文件列表
        model.addAttribute("filesList", filesList);
        return "download";
    }

    // 所有类型文件下载管理
    @GetMapping("/downloadFile")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request,
                                               String filename) throws Exception {
        //下载文件路径
        String path = request.getServletContext().getRealPath("/filePool/");
        //构建将要下载的文件对象
        File file = new File(path + File.separator + filename);
        // 通知浏览器以下载方式打开（下载前对文件名进行转码）
        filename = getFilename(request, filename);
        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", filename);
        // 定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    // 根据浏览器的不同进行编码设置，返回编码后的文件名
    private String getFilename(HttpServletRequest request, String filename)
            throws Exception {
        // IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        // 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                //IE内核浏览器，统一为UTF-8编码显示，并对转换的+进行更正
                return URLEncoder.encode(filename, "UTF-8").replace("+", " ");
            }
        }
        //火狐等其它浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }
}

package com.nnxy.competition.controller;

import com.nnxy.competition.entity.Competition;
import com.nnxy.competition.service.FileService;
import com.nnxy.competition.utils.RedisUtil;
import com.nnxy.competition.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 接收上传的文件类
 *
 * @author :CZS
 * @date :2019/12/19 21:46
 * Email    :642125256@qq.com
 */

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 校验上传的文件，进行保存或修改
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage uploadFile(@RequestParam("multipartFiles") MultipartFile[] multipartFiles) throws IOException {
        //获得修改表单的对应竞赛id
        String competitionId = redisUtil.get("competitionId").toString();
        //文件是否存在，标志
        Boolean tag = false;
        //设置文件保存路径
        final String path = "C:\\Users\\Administrator\\Desktop\\file\\competition\\" + competitionId + "\\";


        if (multipartFiles != null && multipartFiles.length > 0) {
            for (MultipartFile multipartFile : multipartFiles) {
                String fileName = multipartFile.getOriginalFilename();
                List<com.nnxy.competition.entity.File> files = fileService.findFileByCompetitionId(competitionId);
                for (com.nnxy.competition.entity.File file : files) {
                    if (fileName.equals(file.getFileName())) {
                        tag = true;
                        break;
                    }
                }
                if (tag) {
                    tag = false;
                    continue;
                }
                //封装文件对象
                File file = new File(path, fileName);
                com.nnxy.competition.entity.File f = new com.nnxy.competition.entity.File();
                f.setFileId(UUID.randomUUID().toString());
                f.setFileName(fileName);
                f.setFilePath(path + fileName);
                Competition competition = new Competition();
                competition.setCompetitionId(competitionId);
                f.setCompetition(competition);
                System.out.println(f);

                //判断文件夹是否存在，如果不存在则创建
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                try {
                    // 文件写入
                    multipartFile.transferTo(file);

                    //文件保存至数据库
                    fileService.insertFile(f);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new ResponseMessage("0", "操作失败");
                }
            }
        }

        redisUtil.del("competitionId");
        return new ResponseMessage("1", "操作成功");
    }

    /**
     * 校验上传的文件，进行保存或修改
     */
    @RequestMapping(value = "/deleteFile")
    public @ResponseBody
    ResponseMessage deleteFile(String fileId) throws IOException {
        try {
            com.nnxy.competition.entity.File file = fileService.findFileById(fileId);
            System.out.println(file);
            java.io.File f = new java.io.File(file.getFilePath());
            //文件是否存在
            if (f.exists()) {
                //存在就删除
                if (f.delete()) {
                    System.out.println("本地文件删除成功");
                } else {
                    System.out.println("本地文件删除失败");
                }
            } else {
                System.out.println("本地不存在");
            }
            fileService.deleteFileById(fileId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("0", "删除失败");
        }

        return new ResponseMessage("1", "删除成功");
    }


}
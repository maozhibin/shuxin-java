package com.baoquan.shuxin.web.controller;

        import java.io.File;
        import java.io.IOException;
        import java.util.HashMap;
        import java.util.Map;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

        import org.apache.commons.codec.binary.Base64;
        import org.apache.commons.codec.binary.Hex;
        import org.apache.commons.codec.digest.DigestUtils;
        import org.apache.commons.io.FileUtils;
        import org.apache.commons.lang3.StringUtils;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.ResponseBody;
        import org.springframework.web.multipart.commons.CommonsMultipartFile;

        import com.alibaba.fastjson.JSON;

/**
 * Desc:
 * Created by yongj on 7/27/2017,
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/logo")
    @ResponseBody
    public void upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            String imgUrl = saveFile(StringUtils.substringAfterLast(file.getOriginalFilename(), "."), file.getBytes(),
                    request);
            Map<String, String> map = new HashMap<>();
            map.put("filename", file.getOriginalFilename());
            map.put("imgUrl", imgUrl);
            response.getWriter().print(JSON.toJSONString(map));
        }
    }

    private String saveFile(String suffix, byte[] content, HttpServletRequest request) throws IOException {
        String fileMd5 = Hex.encodeHexString(DigestUtils.getMd5Digest().digest(content));

        //创建目录
        String rootDir = request.getServletContext().getRealPath("/WEB-INF/public/") + "/uploads/logos/";
        String subDir = fileMd5.substring(0, 2) + File.separator + fileMd5.substring(2, 4) + File.separator
                + fileMd5.substring(4, 6) + File.separator;
        File dir = new File(rootDir + subDir);
        FileUtils.forceMkdir(dir);

        //写入文件
        String filename = fileMd5 + '.' + suffix;
        FileUtils.writeByteArrayToFile(new File(dir, filename), content);

        return "/uploads/logos/" + subDir + filename;
    }

    @RequestMapping("/imageBase64")
    @ResponseBody
    public void base64(@RequestParam("file") String base64, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // 判断文件是否为空
        if (StringUtils.startsWith(base64, "data:image/")) {
            /*
            data:image/gif;base64,base64编码的gif图片数据
            data:image/png;base64,base64编码的png图片数据
            data:image/jpeg;base64,base64编码的jpeg图片数据
            data:image/x-icon;base64,base64编码的icon图片数据
             */
            String[] parts = StringUtils.split(base64, ',');
            String type = StringUtils.substringBetween(parts[0], "/", ";");
            if ("x-icon".equals(type)) type = "ico";
            String imgUrl = saveFile(type, Base64.decodeBase64(parts[1]), request);
            Map<String, String> map = new HashMap<>();
            map.put("filename", "");
            map.put("imgUrl", imgUrl);
            response.getWriter().print(JSON.toJSONString(map));
        }
    }

}

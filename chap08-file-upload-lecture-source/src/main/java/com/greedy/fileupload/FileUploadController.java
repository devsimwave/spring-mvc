package com.greedy.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

   @PostMapping("single-file")
   public String singleFileUpload(@RequestParam MultipartFile singleFile,
         @RequestParam String singleFileDescription,
         HttpServletRequest request,
         Model model) {
      
      System.out.println("singleFile : " + singleFile);
      System.out.println("singleFileDescription : " + singleFileDescription);
      
      /* 파일을 저장할 경로 설정 */
      String root = request.getSession().getServletContext().getRealPath("resources");
      
      System.out.println("root : " + root);
      
      String filePath = root + "\\uploadFiles";
      
      File mkdir = new File(filePath);
      if(!mkdir.exists()) {
         /* 여러개 생성 */
         mkdir.mkdirs();
      }
      
      /* 파일명 변경 처리 */
      String originFileName = singleFile.getOriginalFilename();
      String ext = originFileName.substring(originFileName.lastIndexOf("."));
      String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
      
      /* 파일을 저장한다. */
      try {
         singleFile.transferTo(new File(filePath + "\\" + savedName));
         
         model.addAttribute("message", "파일 업로드 성공!");
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
         /* 실패시 파일 삭제 */
         new File(filePath + "\\" + savedName).delete();
         model.addAttribute("message", "파일 업로드 실패 !");
      }
      
      return "result";   
   }
   
   
   @PostMapping("multi-file")
   public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles,
         @RequestParam String multiFileDescription,
         HttpServletRequest request,
         Model model) {
      
      System.out.println("multiFiles : " + multiFiles);
      System.out.println("multiFileDescription : " + multiFileDescription);
      
      /* 파일을 저장할 경로 지정 */
      String root =request.getSession().getServletContext().getRealPath("resources");
      
      /* 경로설정 */
      String filePath = root + "\\uploadFiles";
      
      /* 경로가 없을경우 폴더 생성 설정*/
      File mkdir = new File(filePath);
      if(!mkdir.exists()) {
         mkdir.mkdirs();
      }
      
      /* 파일명 변경 처리 */
      List<Map<String, String>> files = new ArrayList<>();
      /* 파일정보 리스트에 담기 */
      for(int i = 0; i < multiFiles.size(); i++) {
         String originFileName = multiFiles.get(i).getOriginalFilename();
         String ext = originFileName.substring(originFileName.lastIndexOf("."));
         String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
         
         /* 파일 정보를 담을 map 생성*/
         Map<String, String> file = new HashMap<>();
         file.put("originFileName", originFileName);
         file.put("savedName", savedName);
         file.put("filePath", filePath);
         
         files.add(file);
      }
      
      /* 파일 저장 */
      try {
         for(int i= 0; i < multiFiles.size(); i++) {
            Map<String, String> file = files.get(i);
            
            multiFiles.get(i).transferTo(new File(filePath + "\\" + file.get("savedName")));
         }
         model.addAttribute("message", "파일 업로드 성공!");
      } catch(Exception e) {
         e.printStackTrace();
         
         /* 실패시 파일 삭제 */
         for (int i = 0; i < multiFiles.size(); i++) {
            
            Map<String, String> file = files.get(i);
            
            new File(filePath + "\\" + file.get("saveName")).delete();
            
         }
         
         model.addAttribute("message" , "파일 업로드 실패 !");
      }
      
      
      return "result";
   }
}
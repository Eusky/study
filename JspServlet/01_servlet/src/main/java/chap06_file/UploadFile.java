package chap06_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/UploadFile")
@MultipartConfig(
    location = "D:/storage", // 업로드 파일을 저장할 디렉토리 경로
    maxFileSize = 1024 * 1024 * 10 // 크기를 10MB로 제한
)
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  File dir = new File("D:/storage");
	  if(!dir.exists())
	    dir.mkdir();
	  
		Part part =  request.getPart("file");
		String fileName = System.currentTimeMillis() + "_" + part.getSubmittedFileName(); // 제출된 파일 이름 + 타임스탬프 
		part.write(fileName);
		
		// 응답 
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<a href=\"/01_servlet/chap06_file/NewFile.html\">뒤로 가기</a>");
		out.println("<div>첨부된 파일 정보</div>");
		out.println("<div>원래파일명: " + part.getSubmittedFileName() + "</div>");
		out.println("<div>저장파일명: " + fileName + "</div>");
		out.println("<hr>");
		
		// 업로드 디렉토리에 저장된 모든 파일 가져오기 
		out.println("<div>저장된 파일 목록</div>");
		File[] files = dir.listFiles();
		for(File file : files) {
		  String storedFileName = file.getName();
		  String originFileName = storedFileName.substring(storedFileName.indexOf("_") + 1);
		  out.println("<div><a href=\"/01_servlet/DownloadFile?fileName=" + URLEncoder.encode(storedFileName, "UTF-8") + "\">" + originFileName + "</a></div>");
		}
		out.close();
		
	}

}

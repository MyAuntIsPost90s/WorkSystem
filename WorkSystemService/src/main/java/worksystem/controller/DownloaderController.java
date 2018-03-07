package worksystem.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestHolder;

@Controller
@RequestMapping("downloader")
public class DownloaderController {

	/**
	 * 通用文件下载接口
	 * 
	 * @param request
	 * @param response
	 * @param path
	 */
	@ResponseBody
	@RequestMapping("download")
	public void download(HttpServletRequest request, HttpServletResponse response, String path) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			String filePath = requestHolder.getRealPathPath(path);
			File file = new File(filePath);
			response.reset();
			response.setContentType("application/octet-stream;charset=UTF-8");
			response.setHeader("Content-Disposition",
					"attachment; filename=" + URLEncoder.encode(file.getName(), "UTF8"));
			response.addHeader("Content-Length", "" + file.length());

			try (OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
					InputStream inStream = new FileInputStream(filePath)) {
				byte[] buffer = new byte[1024 * 1024];
				int read;
				while ((read = inStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, read);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

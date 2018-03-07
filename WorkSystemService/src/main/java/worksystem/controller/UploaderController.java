package worksystem.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lingshi.web.model.RequestFile;
import lingshi.web.model.RequestHolder;
import net.coobird.thumbnailator.Thumbnails;
import worksystem.common.Constant;
import worksystem.util.RandomNum;

@Controller
@RequestMapping("uploader")
public class UploaderController {

	/**
	 * 上传作业
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("uploadWork")
	public void uploadWork(HttpServletRequest request, HttpServletResponse response) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			RequestFile requestFile = requestHolder.getRequestFile();
			if (requestFile == null || requestFile.isEmpty()) {
				requestHolder.fail("上传文件为空");
				return;
			}
			MultipartFile file = requestFile.getFile();
			String fileName = file.getOriginalFilename();
			boolean extNoPass = (!fileName.endsWith(".doc") && !fileName.endsWith(".docx"));
			if (extNoPass) {
				requestHolder.fail("上传文件不合法");
				return;
			}
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String path = Constant.WORK_URL + RandomNum.getLGID() + ext;
			file.transferTo(new File(requestHolder.getRealPathPath(path)));
			requestHolder.success("上传成功", path);
		} catch (Exception e) {
			requestHolder.err("上传文件失败", e);
		}
	}

	/**
	 * 上传学生作业图片
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("uploadStudentWork")
	public void uploadStudentWork(HttpServletRequest request, HttpServletResponse response) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			RequestFile requestFile = requestHolder.getRequestFile();
			if (requestFile == null || requestFile.isEmpty()) {
				requestHolder.fail("上传文件为空");
				return;
			}
			String path = Constant.WORKIMG_URL + RandomNum.getLGID() + ".png";
			// 图片压缩
			Thumbnails.of(requestFile.getFile().getInputStream()).size(500, 500).outputQuality(0.7).outputFormat("png")
					.toFile(new File(requestHolder.getRealPathPath(path)));
			requestHolder.success("上传成功", path);
		} catch (Exception e) {
			requestHolder.err("上传文件失败", e);
		}
	}
}

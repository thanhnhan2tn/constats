package com.thanhnhantn.constats.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	public ServletContext ctx;
	@RequestMapping(value = "/themes/upload", method = RequestMethod.POST)
	public @ResponseBody ModelAndView handleFileUpload(
			@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAtt, HttpSession session,
			HttpServletRequest request) {
		ModelAndView m = new ModelAndView();
		logger.info(request.getSession().getServletContext().getContextPath());
		String path = request.getSession().getServletContext().getRealPath("/resources/")+"/tmp/" + file.getOriginalFilename();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File f = new File(path);
				if (f.exists()) {
					f.delete();
					logger.info("Delete a file: " + f.getPath());
				}
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(f));
				stream.write(bytes);
				stream.close();
				m.addObject("You successfully uploaded "
						+ file.getOriginalFilename() + "!");
				logger.info("Upload Success!");
				session.setAttribute("filePath", path);
				m.setViewName("redirect:/themes/install");
			} catch (Exception e) {
				e.printStackTrace();
				m.addObject("You failed to upload "
						+ file.getOriginalFilename());
				m.setViewName("redirect:/themes?action=install");
			}
		} else {
			m.addObject("You failed to upload " + file.getName()
					+ " because the file was empty.");
			m.setViewName("redirect:/themes?action=install");
		}
		return m;
	}
}
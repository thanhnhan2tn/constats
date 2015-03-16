package com.thanhnhantn.constats.controllers;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thanhnhantn.constats.components.IncludeFile;
import com.thanhnhantn.constats.components.Theme;
import com.thanhnhantn.constats.components.themeFile;

public class XmlThemeInstaller {
	private static final Logger logger = LoggerFactory
			.getLogger(XmlThemeInstaller.class);

	public XmlThemeInstaller() {
		// TODO Auto-generated constructor stub
	}

	public static Theme xmlToTheme(File file) throws JAXBException {
		// System.out.println(file);
		// Khoi tao Context
		JAXBContext context = JAXBContext.newInstance(Theme.class);
		// Tao Unmarshaller tu Context
		Unmarshaller un = context.createUnmarshaller();
		// File xml phu thuoc vao doi tuong + duong duong path
		Theme theme = (Theme) un.unmarshal(file);
		return theme;
	}

	public static void themeToFiles(Theme theme, HttpServletRequest request)
			throws IOException {
		// Copy Css and JS file
		if (!theme.getIncludeFiles().isEmpty()) {
			System.out.println(theme.getIncludeFiles().size());
			for (IncludeFile f : theme.getIncludeFiles()) {
				File source = new File(f.getSource());
				File dest = new File(f.getDestination());
				if (source.exists()) {
					if (!dest.getParentFile().exists()) {
						dest.getParentFile().mkdirs();
						logger.info("Mkdir " + dest.getParentFile());
					}
					if (!dest.exists()) {
						dest.deleteOnExit();
						logger.info("Delete a file: " + dest.toString());
					}
					Files.copy(source.toPath(), dest.toPath(), REPLACE_EXISTING);
					logger.info("Copy file to " + dest.toString());
				}
			}
		}
		// Make Layout File
		for (themeFile f : theme.getFiles()) {
			System.out.println(f.getFileName());
			String path = theme.getPath();
			File folder = new File(request.getSession().getServletContext().getRealPath("/") + "/resources/themes/" + path);
			File file = new File(folder + "/" + f.getFileName());
			if (!folder.exists()) {
				folder.mkdirs();
				logger.info("Create folder " + folder);
				if (file.createNewFile()) {
					logger.info("Create file " + file.getPath());
				} else {
					logger.info("Cannot Create file " + file.getPath());
				}
			} else {
				if (file.exists()) {
					// if file exists, then delete it
					file.delete();
					logger.info("Delete file " + file.getPath());
					if (file.createNewFile()) {
						logger.info("Create file " + file.getPath());
					} else {
						logger.info("Cannot Create file " + file.getPath());
					}
				} else {
					// if file doesnt exists, then create it
					if (file.createNewFile()) {
						logger.info("Create file " + file.getPath());
					} else {
						logger.info("Cannot Create file " + file.getPath());
					}
				}
			}
			// get the content in bytes
			byte[] contentInBytes = f.toString().getBytes();
			FileOutputStream out = new FileOutputStream(file);
			out.write(contentInBytes);
			out.flush();
			out.close();
		}
		// End For
	}

}

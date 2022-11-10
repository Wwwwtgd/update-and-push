package com.jk.shop.controller;

import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jk.common.util.CommonUtil;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	
        InputStream is = null;
        FileOutputStream out = null;
        try
        {
            String productName = req.getParameter("productName");
            productName = new String(productName.getBytes("ISO8859-1"), "utf-8");
            System.err.println("productName-> " + productName);
            System.out.print(productName);
            //��ȡ�ļ�����Ϣ
            Part part = req.getPart("productImag");
            String filename = part.getSubmittedFileName();
            //��ȡ�ļ���׺��
            String suffix = ".jpg";
            if (filename != null)
            {
                suffix = filename.substring(filename.indexOf("."));
            }

            //����Ŀ¼
            String dir = "D:\\upload\\product";
            File dirFile = new File(dir);
            if (!dirFile.exists())
            {
                dirFile.mkdir();
            }
            String uniqueName = CommonUtil.generateUUID() + suffix;
            File productImagFile = new File(dirFile, uniqueName);
            is = part.getInputStream();
            out = new FileOutputStream(productImagFile);
            //����������
            byte[] data = new byte[1024];
            int len = 0;
            while ((len = is.read(data)) != -1)
            {
                out.write(data, 0, len);
            }
            req.setAttribute("msg", "�ϴ��ɹ���");
            req.getRequestDispatcher("/upload.jsp").forward(req, resp);
        }
        catch (Exception e)
        {
            req.setAttribute("msg", "�ϴ�ʧ�ܣ�");
            req.getRequestDispatcher("/upload.jsp").forward(req, resp);
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }

            if (is != null)
            {
                is.close();
            }

        }
    }
}

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

public class UploadPhotoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String filename = null;
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            //设置上传文件大小限制
            factory.setSizeThreshold(1024 * 1024);
            List items = null;
            try {
                items = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = (FileItem) iterator.next();
                if (!item.isFormField()) {
                    //根据时间戳创建头像文件
                    filename = System.currentTimeMillis() + ".jpg";
                    //通过getRealPath获取上传文件夹
                    String photoFolder = req.getServletContext().getRealPath("uploaded");
                    File f = new File(photoFolder, filename);
                    f.getParentFile().mkdirs();
                    //通过item.getInputStream()获取浏览器上传的文件的输入流
                    InputStream is = item.getInputStream();
                    //复制文件
                    FileOutputStream fos = new FileOutputStream(f);
                    byte[] b = new byte[1024 * 1024];
                    int length = 0;
                    while (-1 != (length = is.read(b))) {
                        fos.write(b, 0, length);
                    }
                    fos.close();
                } else {
                    System.out.println(item.getFieldName());
                    String value = item.getString();
                    value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(value);
                }
            }
            String html = "<img width='200' height='150' src='uploaded/%s' />";
            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();
            pw.format(html, filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

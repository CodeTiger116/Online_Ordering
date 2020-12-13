package servlet.manager;

import bean.Food;
import org.apache.commons.beanutils.BeanUtils;
import service.FoodService;
import service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

@WebServlet("/foodAddServlet")
@MultipartConfig  //表示一个servlet支持文件上传
public class FoodAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");


        //使用@MultipartConfig后，可通过getPart获取上传的文件，返回的是part类
        Part part = request.getPart("img");



        //上传图片到项目目录，只保存上传后的图片地址到数据库
        String filePath = getServletContext().getRealPath("upload/food");
        System.out.println("path---"+filePath);

        File file = new File(filePath);
        if(!file.exists()){
            //file.mkdirs();
            boolean mkdirs = file.mkdirs();
            System.out.println(mkdirs);
        }

        //获取文件名
        String fileName = part.getSubmittedFileName();
        System.out.println(fileName);

        //为了防止上传的图片名字重复，一般会给图片重新去取一个不会重复的名字
        //截取文件的扩展名
        String extName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(extName);
        //不会重复的名字
        String name = UUID.randomUUID().toString();
        //拼装
        StringBuffer newName = new StringBuffer();
        newName.append(name).append(extName);

        //将用户上传的图片写到指定目录
        part.write(filePath + File.separator + newName.toString());

        //获取参数
        Map<String, String[]> map = request.getParameterMap();

        Food food = new Food();

        try {
            BeanUtils.populate(food,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(food);

        //保存菜品相关信息到数据库
        FoodService service = new FoodServiceImpl();
        String new_name = newName.toString();
        service.save(food,new_name);


        response.sendRedirect(request.getContextPath()+"/foodFindByPageServlet");




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}

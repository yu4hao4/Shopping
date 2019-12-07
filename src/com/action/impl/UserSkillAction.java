package com.action.impl;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import com.action.Action;
import com.entity.Result;
import com.service.GoodsService;
import com.service.GuestService;
import com.service.NavService;
import com.service.NewsService;
import com.service.UserService;
import com.service.impl.GoodsServiceImpl;
import com.service.impl.GuestServiceImpl;
import com.service.impl.NavServiceImpl;
import com.service.impl.NewsServiceImpl;
import com.service.impl.UserServiceImpl;

public class UserSkillAction implements Action {
	private static String projectPath = new File("").getAbsolutePath()+File.separator;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String submit = request.getParameter("submit");
		String userName = request.getParameter("userName");
		String personName = request.getParameter("name");
		String passWord = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String date =request.getParameter("sel1")+"-"+request.getParameter("sel2")+"-"+request.getParameter("sel3");
		String time =request.getParameter("sel1")+"-"+request.getParameter("sel2")+"-"+request.getParameter("sel3")+
				" "+request.getParameter("sel4")+":"+request.getParameter("sel5")+":"+request.getParameter("sel6");
		String telphone =request.getParameter("mobile");
		String location =request.getParameter("address");
		String parentId =request.getParameter("parentId");
		String className =request.getParameter("className");
		String id = request.getParameter("id");
		String newsTitle= request.getParameter("title");
		String newscontent=request.getParameter("content");
		String replyContent =request.getParameter("replyContent");
		
		boolean flag=false;
		JSONObject jdata =null;  //存放结果
		UserService userService = new UserServiceImpl();
		NavService navService =new NavServiceImpl();
		NewsService newsService = new NewsServiceImpl();
		GuestService guestService =new GuestServiceImpl();
		GoodsService goodsService =new GoodsServiceImpl();
		if(submit.equals("更新")) { //用户
			flag = userService.modifyUser(userName,personName,passWord,sex,date,telphone,location);
				Result r = new Result(flag);
				jdata =new JSONObject(r);
			return "MoResult:"+jdata.toString();
		}
		else if(submit.equals("添加")) { //用户
			flag = userService.addUser(userName,personName,passWord,sex,date,telphone,location);
			Result r = new Result(flag);
			jdata =new JSONObject(r);
		return "AdResult:"+jdata.toString();
		}
		else if(submit.equals("添加栏目")) {
			flag =  navService.addNav(parentId,className);
			Result r = new Result(flag);
			jdata =new JSONObject(r);
		return "AdResult:"+jdata.toString();
		}
		else if(submit.equals("栏目更新")) { 
			flag = navService.modifyNav(id,parentId,className);
				Result r = new Result(flag);
				jdata =new JSONObject(r);
			return "MoResult:"+jdata.toString();
		}
		else if(submit.equals("添加新闻")) {
			flag =  newsService.addNews(newsTitle,newscontent,time);
			Result r = new Result(flag);
			jdata =new JSONObject(r);
		return "AdResult:"+jdata.toString();
		}
		else if(submit.equals("新闻更新")) { 
			flag = newsService.modifyNews(newsTitle,newscontent,time,id);
				Result r = new Result(flag);
				jdata =new JSONObject(r);
			return "MoResult:"+jdata.toString();
		}
		else if(submit.equals("留言更新")) { 
			flag = guestService.modifyGuest(id,replyContent);
				Result r = new Result(flag);
				jdata =new JSONObject(r);
			return "MoResult:"+jdata.toString();
		}
		else if(submit.equals("商品修改")) { 
			String productName=request.getParameter("productName");
			String productPrice=request.getParameter("productPrice");
			String productContent=request.getParameter("productContent");
			String isDiscount=request.getParameter("isDiscount");
			flag = goodsService.modifyGoods(id,productName,parentId,productPrice,productContent,isDiscount);
				Result r = new Result(flag);
				jdata =new JSONObject(r);
			return "MoResult:"+jdata.toString();
		}
		//添加商品
		else if(submit.equals("productAdd")) {
			String productName= request.getParameter("productName");
			parentId  =request.getParameter("parentId");
			String productPrice =new String(request.getParameter("productPrice").getBytes("ISO-8859-1"), "UTF-8");
			String productContent =request.getParameter("productContent");
			String isDiscount =new String(request.getParameter("isDiscount").getBytes("ISO-8859-1"), "UTF-8");

			String productImg =getPath(request);
			flag =  goodsService.addGoods(productName,productPrice,productContent,isDiscount,productImg,parentId);
			Result r = new Result(flag);
			jdata =new JSONObject(r);
		return "AdResult:"+jdata.toString();
		}
		return "FfResult:";
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	/**
	 * 获得上传文件的路径
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	private String getPath(HttpServletRequest request) throws IOException, ServletException {

		// 获取到Part对象；
		Part part = request.getPart("photo");;
		// 获取上传文件名称；
		String name = getName(part);
		// 将上传内容写入到指定目录；
		saveImg(
				request.getServletContext().getRealPath("/upload/"),
				name,
				part.getInputStream()
		);
		String repath ="upload/"+name;
		return repath;
	}

	/**
	 * 写入图片文件
	 * @param filename
	 * @param is
	 */
	private void saveImg(String projectPath,String filename, InputStream is) {
		FileOutputStream fos = null;
		try{
			fos=new FileOutputStream(projectPath+filename);
			byte [] buf = new byte[1024];
			int len = 0;
			while((len = is.read(buf)) != -1){
				fos.write(buf,0,len);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				assert fos != null;
				fos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private String getName(Part part) {
		// 当前我们所做的操作是获取了上传的文件的原始名称；
		// 但是，如果多人上传时，名称一样，那么难免会出现覆盖的情况；
		// 此时，我们可以截取其扩展名（如doc），作为文件后缀；
		// 然后再通过某种方式，生成一个不重复的文件名(如：GUID)，即可
		// 最后，将这个文件名可以存储在数据库表的字段中，需要使用时取出就可以了；

		String str = part.getHeader("Content-Disposition");

		String[] elements = str.split(";");

		for (String element : elements) {
			if (element.trim().startsWith("filename")) {

				UUID uuid = UUID.randomUUID();
				String test = element.substring(element.indexOf("=") + 1).replace("\"", "");
				String s = test.substring(test.lastIndexOf(".") + 1);
				return uuid + "." + s;
			}
		}

		return null;
	}

}

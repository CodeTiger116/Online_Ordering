package servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/shopCarServlet")
public class ShopCarServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String method = request.getParameter("method");
        //System.out.println(method);


        String foodId = request.getParameter("foodId");
        String dinnerTableId = request.getParameter("dinnerTableId");

        //加入购物车后，页面刷新，返回原来的菜品类型界面
        String foodTypeId = request.getParameter("foodTypeId");


        Integer foodIdInt = Integer.parseInt(foodId);
        Integer dinnerTableIdInt = Integer.parseInt(dinnerTableId);


        //把购物车数据存在session
        HttpSession session = request.getSession();

        //根据餐桌的id获取其购物车
        Map<Integer,Integer> shopCar = (Map<Integer, Integer>) session.getAttribute(dinnerTableId);

        //添加到购物车
        if(method != null && method.equals("add")){





            if(shopCar != null){
                //购物车有商品
                //判断当前购物车中，是否已经有当前需要加入到购物车的商品
                Set<Integer> foodIds = shopCar.keySet();
                if(foodIds.contains(foodIdInt)){
                    Integer buyNum = shopCar.get(foodIdInt);
                    shopCar.put(foodIdInt,buyNum+1);
                }else {
                    shopCar.put(foodIdInt,1);
                }


            }else{
                //foodId  dinnerTableId  num
                //新建购物车
                shopCar = new HashMap<>();
                shopCar.put(foodIdInt,1);
                session.setAttribute(dinnerTableId,shopCar);
            }
        /*
        //测试
        Set<Integer> foodIds2 = shopCar.keySet();
        for(Integer foodid : foodIds2){
            System.out.println(foodid + ":" + shopCar.get(foodid));
        }*/

            //request.getRequestDispatcher("/indexServlet?id="+dinnerTableId).forward(request,response);
            response.sendRedirect(request.getContextPath()+"/indexServlet?id="+dinnerTableId+"&foodTypeId="+foodTypeId);

        }else if(method != null && method.equals("update")){
            //System.out.println("-----------更新------------");
            //更新购物车
            String buyNum = request.getParameter("buyNum");
            //System.out.println(buyNum);

            shopCar.put(foodIdInt,Integer.parseInt(buyNum));

            response.sendRedirect(request.getContextPath()+"/indexServlet?id="+dinnerTableId+"&foodTypeId="+foodTypeId);
        }else if(method != null && method.equals("delete")){


            shopCar.remove(foodIdInt);

            response.sendRedirect(request.getContextPath()+"/indexServlet?id="+dinnerTableId+"&foodTypeId="+foodTypeId);
        }




    }
}

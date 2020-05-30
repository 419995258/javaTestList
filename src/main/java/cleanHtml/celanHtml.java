package cleanHtml;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class celanHtml {




    public static void main(String[] args){
//        test();
        test2();
    }


    public static void test(){
        //声明Connection对象
        Connection con;
//驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
//URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://192.168.3.55:3306/alengin?serverTimezone=GMT%2b8&useSSL=false&useUnicode=true&characterEncoding=utf8";
//MySQL配置时的用户名
        String user = "root";
//MySQL配置时的密码
        String password = "love431";
//遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select t.ITEM_ID,t.CONTENT,t.HOWTO,t.CORRECT_RESPONSE from al_res_zhuguan_item t where 1=1 and t.item_id = '1856e695-d3ca-406e-be04-a6b1857abeeb' ";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");

            Whitelist whitelist =new Whitelist();
            whitelist.addAttributes("img", "src");

            String upSql = "update al_res_zhuguan_item t set t.content = ?,t.HOWTO = ?,t.CORRECT_RESPONSE=? where 1=1 and t.ITEM_ID = ?";
            PreparedStatement stmt = con.prepareStatement(upSql);
            System.out.println("itemId \t content \t howTo\t cr \t");
            Integer i = 0;
            while(rs.next()){

                //获取stuname这列数据
                String itemId = rs.getString("ITEM_ID");
                String content = rs.getString("CONTENT");
                String howTo = rs.getString("HOWTO");
                String cr = rs.getString("CORRECT_RESPONSE");
                //输出结果
                i = i + 1;
                System.out.println(i + ":" + itemId);
                //System.out.println(itemId + "\t" + content + "\t" + howTo + "\t" + cr);
                if(StringUtils.isBlank(content)){
                    content = "";
                }
                content = StringEscapeUtils.unescapeHtml4(Jsoup.clean(content, whitelist));

                if(StringUtils.isBlank(howTo)){
                    howTo = "";
                }
                howTo = StringEscapeUtils.unescapeHtml4(Jsoup.clean(howTo, whitelist));

                if(StringUtils.isBlank(cr)){
                    cr = "";
                }
                cr = StringEscapeUtils.unescapeHtml4(Jsoup.clean(cr, whitelist));

                stmt.setString(1,content);
                stmt.setString(2,howTo);
                stmt.setString(3,cr);
                stmt.setString(4,itemId);
                System.out.println(itemId + ":" + stmt.executeUpdate());
            }
            System.out.println("finish");
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }


    }

    public static void test2(){
        /**
         <sub></sub>
         <sup></sup>
         MathML

         new.css 1042 .exambox .examTitle>span
                 1174 .subjectBox .fl .examTitle>span


         *
         */
        String str = "下列各关系中，<sub>a</sub>不是函数关系的是（ &nbsp; &nbsp;) \n" +
                "<br><span class=\"mathquill-embedded-latex edui-formula-active\">^1/_2</span><span>\u200D</span>";
        str = StringEscapeUtils.unescapeHtml4(str);
        Whitelist whitelist =new Whitelist();
        // 保留换行
        whitelist.addTags("br");
        // 保留h5部分标签
        whitelist.addTags("input");
        whitelist.addTags("sub");
        whitelist.addTags("sup");
        // 保留图片
        whitelist.addAttributes("img", "src");
        // 保留公式编辑器的样式
        whitelist.addAttributes("span","class","mathquill-embedded-latex");
        String clean = Jsoup.clean(str, whitelist);
        System.out.println(clean);
        clean = StringEscapeUtils.escapeHtml4(clean);
        System.out.println(clean);
    }
}

package Util;

import ShebaXYZ.Order;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static ShebaXYZ.USER.user;

public class ModifyDatabase {

    public boolean insertIntoUser(String phone,String password,String firstName,String lastName,String email,String joinDate)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        boolean isException=false;
        try {
            stmt=c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql="INSERT INTO \"USER\" (\"PHONE\",\"PASSWORD\",\"FIRST_NAME\",\"LAST_NAME\",\"EMAIL\",\"JOINING_DATE\") Values("+phone+",'"+password+"','"+firstName+"','"+lastName+"','"+email+"',Current_Date);";
        System.out.println(sql);

        try {
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {

            e.printStackTrace();
            isException=true;
        }

        DatabaseUtil.close(c);
        return isException;

    }

    public ResultSet selectUser(String phone,String password)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="SELECT * FROM \"USER\" WHERE  \"PHONE\"="+phone+" AND \"PASSWORD\"='"+password+"';";

        try {
            stmt=c.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return rs;
    }
    public ResultSet selectServiceProvider(String phone,String password)
    { Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="SELECT * FROM \"SERVICE_PROVIDER\" WHERE  \"PHONE\"="+phone+" AND \"PASSWORD\"='"+password+"';";

        try {
            stmt=c.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return rs;

    }


    public ResultSet selectServiceCategory()
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="select \"SERVICE_CATEGORY\" from \"SERVICES\" GROUP BY \"SERVICE_CATEGORY\";";

        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  rs;
    }
    public ResultSet selectServiceSubCategory(String str)
   {
       Connection c=DatabaseUtil.connect();
       Statement stmt=null;
       ResultSet rs=null;
       String sql="Select \"SERVICE_SUBCATEGORY\" FROM \"SERVICES\" WHERE \"SERVICE_CATEGORY\"='"+str+"'GROUP BY \"SERVICE_SUBCATEGORY\";";

       try {
            stmt=c.createStatement();
           rs=stmt.executeQuery(sql);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       DatabaseUtil.close(c);
       return  rs;
   }

    public ResultSet selectServiceName(String str)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="Select \"SERVICE_NAME\" FROM \"SERVICES\" WHERE \"SERVICE_SUBCATEGORY\"='"+str+"' GROUP BY \"SERVICE_NAME\";";

        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  rs;
    }

    public ResultSet selectPendingService(String str)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="SELECT \"RECORD\".\"OID\" AS ordernumber , \"SERVICES\".\"SERVICE_NAME\" AS service,(\"SERVICE_PROVIDER\".\"FIRST_NAME\" ||' '|| \"SERVICE_PROVIDER\".\"LAST_NAME\") AS worker ,\"RECORD\".\"START_TIME\" AS start_time\n" +
                "FROM \"RECORD\" JOIN \"ORDER\" ON \"RECORD\".\"OID\"=\"ORDER\".\"OID\" \n" +
                "JOIN \"SERVICE_PROVIDER\" ON \"SERVICE_PROVIDER\".\"PHONE\"=\"ORDER\".\"SERVICE_PROVIDER\"\n" +
                "JOIN \"SERVICES\" ON \"ORDER\".\"SERVICE_ID\"=\"SERVICES\".\"SERVICE_ID\" \n" +
                "WHERE \"RECORD\".\"OID\" IN ( SELECT \"OID\" FROM \"RECORD\" WHERE \"USER_ID\"="+str+"AND \"RECORD\".\"FINISH_TIME\" IS NULL);";

        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  rs;


    }

    public ResultSet selectLocation()
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="SELECT \"NAME\" FROM \"LOCATION\";";
        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  rs;
    }


    public ResultSet selectWorker(String str)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="SELECT (\"SERVICE_PROVIDER\".\"FIRST_NAME\"||' '||\"SERVICE_PROVIDER\".\"LAST_NAME\") AS FULLNAME,\n" +
                "\"SERVICE_PROVIDER\".\"PHONE\" AS PHONE,\"SERVICE_PROVIDER\".\"RATING\" AS RATING,\"SERVICES\".\"COST\" AS PRICE,\"LOCATION\".\"LATITUDE\" AS LAT,\"LOCATION\".\"LONGITUDE\" AS LON\n" +
                "FROM \"SERVICES\" JOIN  \"SERVICE_PROVIDER\" ON (\"SERVICES\".\"SERVICE_SUBCATEGORY\"=\"SERVICE_PROVIDER\".\"SERVICE_SUBCATEGORY\")\n" +
                "JOIN \"LOCATION\" ON ( \"SERVICE_PROVIDER\".\"LOCATION_ID\"=\"LOCATION\".\"LOCATION_ID\")\n" +
                "WHERE \"SERVICES\".\"SERVICE_NAME\"='"+str+"'AND \"SERVICE_PROVIDER\".\"IS_IDLE\"=true;";
        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  rs;
    }
    public ResultSet selectLocationLatLon(String  str)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="Select * From \"LOCATION\" WHERE \"NAME\"='"+str+"';";
        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  rs;
    }

    public ResultSet totalSP(String str)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="select totalSP('"+str+"');";
        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  rs;

    }
    public ResultSet selectServiceID(String str)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="select \"SERVICE_ID\" From \"SERVICES\" WHERE \"SERVICE_NAME\"='"+str+"';";
        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  rs;
    }
    public void insertOrder(Order or)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        String sql="INSERT INTO \"ORDER\"(\"OID\",\"USER_ID\",\"SERVICE_ID\",\"SERVICE_PROVIDER\",\"COST\",\"USER_LOCATION\") VALUES(NEXTVAL('oid_generator'),"+or.userId+","+or.serviceId+","+or.serviceProvider+","+or.getCost()+","+or.userLocation+");";
        try {
            stmt=c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);

    }
    public ResultSet selectViewProviderRequest(String str)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="SELECT \"ORDER\".\"OID\" AS ORDERID,(\"USER\".\"FIRST_NAME\"||' '||\"USER\".\"LAST_NAME\") AS USERNAME,\n" +
                "\"USER\".\"PHONE\" AS PHONE,\"SERVICES\".\"SERVICE_NAME\" AS SERVICE,\"ORDER\".\"COST\" AS PRICE,\n" +
                "\"LOCATION\".\"NAME\" AS ADDRESS\n" +
                "FROM \"ORDER\" JOIN \"USER\" ON (\"ORDER\".\"USER_ID\"=\"USER\".\"PHONE\" )\n" +
                "JOIN \"SERVICES\" ON ( \"ORDER\".\"SERVICE_ID\"=\"SERVICES\".\"SERVICE_ID\") \n" +
                "JOIN \"LOCATION\" ON (\"ORDER\".\"USER_LOCATION\"=\"LOCATION\".\"LOCATION_ID\")\n" +
                "WHERE \"ORDER\".\"SERVICE_PROVIDER\"="+str+" AND \"ORDER\".\"IS_ACCEPTED\" IS NULL;";
        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  rs;

    }
    public void updateOrder(String OID,String isAccept)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        String sql="UPDATE \"ORDER\" SET \"IS_ACCEPTED\"="+isAccept+" WHERE \"OID\"="+OID+";";
        try {
            stmt=c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);

    }

    public void updateRecord(String oid,String rat,String comment)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        String sql="UPDATE \"RECORD\" SET \"FINISH_TIME\"=CURRENT_TIMESTAMP,\"USER_RATING\"="+rat+",\"COMMENT\"='"+comment+"' WHERE \"OID\"="+oid+";";
        try {
            stmt=c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
    }
    public ResultSet selectCancelOrderOrProcessOrder(String str,String is)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="SELECT \"ORDER\".\"OID\" AS OID,\"SERVICES\".\"SERVICE_NAME\" AS SERVICE,\n" +
                "\"SERVICE_PROVIDER\".\"FIRST_NAME\"||' '||\"SERVICE_PROVIDER\".\"LAST_NAME\" AS PROVIDER_NAME\n" +
                "FROM \"ORDER\" JOIN \"SERVICES\" ON \"ORDER\".\"SERVICE_ID\"=\"SERVICES\".\"SERVICE_ID\"\n" +
                "JOIN \"SERVICE_PROVIDER\" ON \"SERVICE_PROVIDER\".\"PHONE\"=\"ORDER\".\"SERVICE_PROVIDER\"\n" +
                "WHERE \"ORDER\".\"USER_ID\"="+str+"AND \"ORDER\".\"IS_ACCEPTED\" "+is+";";
        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  rs;

    }
    public void deleteOId(String str)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        String sql="DELETE FROM \"ORDER\" WHERE \"OID\"="+str+";";
        try {
            stmt=c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);

    }

    public boolean checkEnoughBalance(String str)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        boolean b=false;
        String sql="select ENOUGH_BALANCE("+str+");";
        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
          if(rs.next())  b=rs.getBoolean("enough_balance");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  b;

    }
    public String transactionAmmount(String str)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String  b=null;
        String sql="select TRANSACT("+str+");";
        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
          if(rs.next())  b=rs.getString("transact");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  b;
    }
    public ResultSet selectHistory(String str)
    {
        Connection c=DatabaseUtil.connect();
        Statement stmt=null;
        ResultSet rs=null;
        String sql="SELECT \"RECORD\".\"OID\" AS ordernumber , \"SERVICES\".\"SERVICE_NAME\" AS service,(\"SERVICE_PROVIDER\".\"FIRST_NAME\" ||' '|| \"SERVICE_PROVIDER\".\"LAST_NAME\") AS worker ,\"RECORD\".\"FINISH_TIME\" AS start_time\n" +
                "FROM \"RECORD\" JOIN \"ORDER\" ON \"RECORD\".\"OID\"=\"ORDER\".\"OID\" \n" +
                "JOIN \"SERVICE_PROVIDER\" ON \"SERVICE_PROVIDER\".\"PHONE\"=\"ORDER\".\"SERVICE_PROVIDER\"\n" +
                "JOIN \"SERVICES\" ON \"ORDER\".\"SERVICE_ID\"=\"SERVICES\".\"SERVICE_ID\" \n" +
                "WHERE \n" +
                "\"RECORD\".\"FINISH_TIME\" IS NOT NULL AND\n" +
                "\"RECORD\".\"OID\" IN ( SELECT \"OID\" FROM \"RECORD\" WHERE \"USER_ID\"="+str+");";

        try {
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseUtil.close(c);
        return  rs;


    }










    public static void main(String[] args)
    {
      /*  ModifyDatabase m=new ModifyDatabase();
        //if(m.insertIntoUser("01745964708","123","Shahanara","Parvin","parvin@gmail.com","03/11/98"))
        //    System.out.println("there is a exception");
        ResultSet r=m.selectCancelOrderOrProcessOrder(1733202506+"","= FALSE");
        m.deleteOId(113+"");
       // Order o=new Order("1","0176326309","102","1022","30","false",102+"");
       // m.updateOrder(1736598990+"","false");
        while (true)
        {
            try {
                if (!r.next()) break;
                String s=r.getString("oid");
                System.out.print(s+" ");
             s=r.getString("service");
                System.out.print(s+" ");
                s=r.getString("provider_name");
                System.out.println(s+" ");
//                s=r.getString("service");
//                System.out.print(s+" ");
//                s=r.getString("price");
//                System.out.print(s+" ");
//                s=r.getString("address");
//                System.out.println(s);
            } catch (SQLException e) {
                e.printStackTrace();
            }



        }
        */

//        ModifyDatabase m=new ModifyDatabase();
//        ResultSet resultSet=m.totalSP("coat");
//        int a=-6;
//        try{
//            if(resultSet.next()) a= resultSet.getInt("totalsp");
//
//        }catch (Exception e)
//        {
//            System.out.println(e);
//        }
//        System.out.println(a);
 //       ModifyDatabase m=new ModifyDatabase();
 //       if(m.checkEnoughBalance(138+"")) System.out.println(m.transactionAmmount(138+""));

        ModifyDatabase m=new ModifyDatabase();
    //    m.updateOrder(130+"","true");


    }

}

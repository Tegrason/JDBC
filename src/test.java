import java.sql.*;

public class test {
    public void test(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","user","password");
            String sql = "select *from user where id = < ?";
            //存储过程
            CallableStatement cst = conn.prepareCall("");
            cst.setInt(1,1);
            boolean i = cst.execute();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,5);
            //更新 ps.executeUpdate();
            rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("user_name");
            }
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(null == rs){
                    rs.close();
                }
                if(null == ps){
                    ps.close();
                }
                if(null == conn){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

        }

    }
}

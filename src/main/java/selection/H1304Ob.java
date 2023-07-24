package selection;

import config.State;
import objects.User;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class H1304Ob extends State {

    public static void printInfo() throws SQLException {
        ResultSet resultSet=getStatement().executeQuery("SELECT * FROM sys.h1303;");
        while (resultSet.next()){
            System.out.println(resultSet.getString("name") + " "+resultSet.getString("date"));
        }
    }

    public static void getUser(String name) throws SQLException {
        ResultSet resultSet=getStatement().executeQuery("SELECT * FROM sys.h1303 where name=\""+name+"\";");
        while (resultSet.next()){
            System.out.println(resultSet.getString("family") + " "+resultSet.getString("date"));
        }
    }
    public static boolean addUser(String name, String family, String cityName) throws SQLException {
       return getStatement().execute("INSERT INTO `sys`.`h1303` (`name`, `family`, `city`) VALUES ('"+name+"', '"+family+"', '"+cityName+"');");
    }
    public static List<User> getUserObjects(String name)  {
        ResultSet resultSet= null;
        List<User> list=new ArrayList<>();
        try {
            resultSet = getStatement().executeQuery("SELECT * FROM sys.h1303 where name=\""+name+"\";");


        while (resultSet.next()){
           list.add(new User(resultSet));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

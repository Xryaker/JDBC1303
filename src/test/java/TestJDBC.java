import objects.User;
import org.junit.Assert;
import org.junit.Test;
import selection.H1304Ob;

import java.sql.SQLException;

public class TestJDBC {
    @Test
    public void test1() throws SQLException {
        Assert.assertFalse( H1304Ob.addUser("Sergiy","Reznikov","Kiev"));
    }
    @Test
    public void test2(){
        for (User l : H1304Ob.getUserObjects("Vasiliy")) {
            System.out.println(l.date);
        }
    }
}

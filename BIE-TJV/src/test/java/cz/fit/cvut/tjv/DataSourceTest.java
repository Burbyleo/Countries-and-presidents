//package cz.fit.cvut.tjv;
//
//import cz.fit.cvut.tjv.config.ApplicationConfig;
//import jdk.nashorn.internal.ir.annotations.Ignore;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@Ignore
//@SpringBootTest
//@ContextConfiguration(classes = ApplicationConfig.class)
//public class DataSourceTest {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Test
//    public void dbTest() {
//        Connection connection = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            connection = dataSource.getConnection();
//            assertNotNull(connection, "Connection is null");
//
//            ps = connection.prepareStatement("SELECT 1");
//            assertNotNull(ps);
//
//            rs = ps.executeQuery();
//            assertNotNull(rs);
//
//            while (rs.next()) {
//                assertEquals(rs.getInt(1), 1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            fail();
//        } finally {
//            try {
//                rs.close();
//                ps.close();
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                fail();
//            }
//        }
//    }
//
//}

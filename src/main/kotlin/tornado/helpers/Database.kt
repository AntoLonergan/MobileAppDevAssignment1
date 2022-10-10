package tornado.helpers

import java.sql.Connection
import java.sql.DriverManager

class Database {
    var conn: Connection

    init{

        Class.forName("org.sqlite.JDBC")
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_1/data", "root", "")
    }

}
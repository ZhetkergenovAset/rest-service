package gexabyte.java.test.dao;


import com.google.gson.Gson;
import gexabyte.java.test.config.ConnectionBuilder;
import gexabyte.java.test.exception.DaoException;
import gexabyte.java.test.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl implements UserDao {
    private static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id=?";

    private User createUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setUserName(rs.getString("username"));
        user.setIinNumber(rs.getString("iin_number"));
        user.setLastName(rs.getString("last_name"));
        return user;
    }

    @Override
    public String getUser(Long id) throws DaoException {
        String result = null;
        try (Connection connection = ConnectionBuilder.build();
             PreparedStatement statement = connection.prepareStatement(GET_USER_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = createUser(resultSet);
                result = new Gson().toJson(user);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
        return result;
    }
}

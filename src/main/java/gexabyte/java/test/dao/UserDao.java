package gexabyte.java.test.dao;


import gexabyte.java.test.exception.DaoException;
import gexabyte.java.test.model.User;

public interface UserDao {

    String getUser(Long id) throws DaoException;

}

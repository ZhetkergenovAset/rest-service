package gexabyte.java.test.rest;


import gexabyte.java.test.dao.UserDao;
import gexabyte.java.test.dao.UserDaoImpl;
import gexabyte.java.test.exception.DaoException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "/user")
public class UserController {
    private UserDao userDao = new UserDaoImpl();

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("id") Long id) throws DaoException {
        return userDao.getUser(id);
    }
}

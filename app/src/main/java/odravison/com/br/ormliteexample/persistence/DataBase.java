package odravison.com.br.ormliteexample.persistence;

import android.content.Context;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import odravison.com.br.ormliteexample.DAO.UserDAO;
import odravison.com.br.ormliteexample.model.User;

/**
 * Created by odravison on 21/10/16.
 */

public class DataBase {

    private Helper helper;
    private UserDAO userDao;

    public DataBase(Context ctx){
        helper = new Helper(ctx); // Classe para o controle do banco
        try{
            userDao = new UserDAO(helper.getConnectionSource());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // ================================== CRUD DE USUÁRIO ===========================

    public void insertUser(User user) throws SQLException {
        userDao.create(user);
    }

    public void updateUser(User user) throws SQLException {
        userDao.update(user);
    }

    public void deleteUser(User user) throws SQLException {
        userDao.delete(user);
    }

    public User selectUsersById(Integer id) throws SQLException {
        User userResult;

        QueryBuilder<User, Integer> builder = userDao.queryBuilder();
        builder.where().idEq(id);
        PreparedQuery<User> preparedQuery = builder.prepare();
        List<User> result = userDao.query(preparedQuery);

        return userResult = result.get(0);
    }











}

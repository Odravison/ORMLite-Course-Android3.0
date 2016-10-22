package odravison.com.br.ormliteexample.DAO;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import odravison.com.br.ormliteexample.model.User;

/**
 * Created by odravison on 21/10/16.
 */

public class UserDAO extends BaseDaoImpl<User, Integer> {

    public UserDAO(ConnectionSource conn) throws SQLException {
        super(User.class);
        setConnectionSource(conn);
        initialize();
    }

    @Override
    public QueryBuilder<User, Integer> queryBuilder() {
        return super.queryBuilder();
    }

    @Override
    public List<User> query(PreparedQuery<User> preparedQuery) throws SQLException {
        return super.query(preparedQuery);
    }
}

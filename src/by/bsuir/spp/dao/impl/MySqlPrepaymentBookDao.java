package by.bsuir.spp.dao.impl;

import by.bsuir.spp.bean.document.PrepaymentBookStatement;
import by.bsuir.spp.dao.PrepaymentBookDao;
import by.bsuir.spp.dao.connectionpool.impl.ConnectionPoolImpl;
import by.bsuir.spp.exception.dao.DaoException;

import java.beans.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Кирилл on 2/20/2016.
 */
public class MySqlPrepaymentBookDao implements PrepaymentBookDao {

    private static final MySqlPrepaymentBookDao instance = new MySqlPrepaymentBookDao();

    private MySqlPrepaymentBookDao() {}

    public static MySqlPrepaymentBookDao getInstance() {
        return instance;
    }

    private static final String INSERT_PREPAYMENT_BOOK_QUERY = "INSERT into `prepayment_book` (clientName, clientNumber, unpdaidCost, organisationHeadName, bookkeeperName, date) "+
            "values (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_PREPAYMENT_BOOK_BY_ID = "select * from `prepayment_book` where id=?";
    private static final String DELETE_PREPAYMENT_BOOK_BY_ID = "delete from `prepayment_book` where id=?";
    private static final String UPDATE_PREPAYMENT_BOOK_BY_ID = "update `prepayment_book` set clientName=?, clientNumber=?, unpdaidCost=?, organisationHeadName=?, bookkeeperName=?, date=? "+
            "where id=?";
    private static final String SELECT_ALL_PREPAYMENT_BOOK = "select * from `prepayment_book`";

    @Override
    public List<PrepaymentBookStatement> getAllPrepaymentBooks() {

        List<PrepaymentBookStatement> prepaymentBookStatements = new ArrayList<>();

        try(Connection connection = (Connection) ConnectionPoolImpl.getInstance();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PREPAYMENT_BOOK);
            ResultSet resultSet = statement.executeQuery()) {

            while(resultSet.next()) {
                PrepaymentBookStatement prepaymentBookStatement = new PrepaymentBookStatement();
                prepaymentBookStatement.setStatementNumber(resultSet.getInt(1));
                prepaymentBookStatement.setClientName(resultSet.getString(2));
                prepaymentBookStatement.setClientNumber(resultSet.getInt(3));
                prepaymentBookStatement.setUnpaidCost(resultSet.getInt(4));
                prepaymentBookStatement.setOrganizationHeadName(resultSet.getString(5));
                prepaymentBookStatement.setBookkeeperName(resultSet.getString(6));
                prepaymentBookStatement.setDate(resultSet.getDate(7));

                prepaymentBookStatements.add(prepaymentBookStatement);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prepaymentBookStatements;
    }

    @Override
    public Integer create(PrepaymentBookStatement newInstance) throws DaoException {
        int id = 0;

        try(Connection connection = (Connection) ConnectionPoolImpl.getInstance();
            PreparedStatement statement = connection.prepareStatement(INSERT_PREPAYMENT_BOOK_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, newInstance.getClientName());
            statement.setInt(2, newInstance.getClientNumber());
            statement.setInt(3, newInstance.getUnpaidCost());
            statement.setString(4, newInstance.getOrganizationHeadName());
            statement.setString(5, newInstance.getBookkeeperName());
            statement.setDate(6, new Date(newInstance.getDate().getTime()));
            statement.execute();

            try(ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()){
                    id = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public PrepaymentBookStatement read(Integer id) throws DaoException {

        PrepaymentBookStatement prepaymentBookStatement = null;

        try(Connection connection = (Connection) ConnectionPoolImpl.getInstance();
            PreparedStatement statement = connection.prepareStatement(SELECT_PREPAYMENT_BOOK_BY_ID)) {

            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    prepaymentBookStatement = new PrepaymentBookStatement();
                    prepaymentBookStatement.setStatementNumber(id);
                    prepaymentBookStatement.setClientName(resultSet.getString(2));
                    prepaymentBookStatement.setClientNumber(resultSet.getInt(3));
                    prepaymentBookStatement.setUnpaidCost(resultSet.getInt(4));
                    prepaymentBookStatement.setOrganizationHeadName(resultSet.getString(5));
                    prepaymentBookStatement.setBookkeeperName(resultSet.getString(6));
                    prepaymentBookStatement.setDate(resultSet.getDate(7));
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prepaymentBookStatement;
    }

    @Override
    public void update(PrepaymentBookStatement obj) throws DaoException {

        try(Connection connection = (Connection) ConnectionPoolImpl.getInstance();
            PreparedStatement statement = connection.prepareStatement(UPDATE_PREPAYMENT_BOOK_BY_ID)) {

            statement.setString(1, obj.getClientName());
            statement.setInt(2, obj.getClientNumber());
            statement.setInt(3, obj.getUnpaidCost());
            statement.setString(4, obj.getOrganizationHeadName());
            statement.setString(5, obj.getBookkeeperName());
            statement.setDate(6, new Date(obj.getDate().getTime()));
            statement.setInt(7, obj.getStatementNumber());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(PrepaymentBookStatement obj) throws DaoException {

        try(Connection connection = (Connection) ConnectionPoolImpl.getInstance();
            PreparedStatement statement = connection.prepareStatement(DELETE_PREPAYMENT_BOOK_BY_ID)) {

            statement.setInt(1, obj.getStatementNumber());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
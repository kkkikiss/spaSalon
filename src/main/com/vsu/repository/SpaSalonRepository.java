package main.com.vsu.repository;

import main.com.vsu.entity.SpaSalon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpaSalonRepository {
    private final String INSERT_QUERY = "INSERT INTO spa (name_salon, id_profile, cost) " +
            "VALUES (?, ?, ?);";
    private final String SELECT_BY_ID_QUERY = "SELECT id_salon, name_salon, id_profile, cost " +
            "FROM spa WHERE id_salon = ?;";
    private final String SELECT_BY_ID_PROFILE_QUERY = "SELECT id_salon, name_salon, id_profile, cost " +
            "FROM spa WHERE id_profile = ?;";
    private final String UPDATE_QUERY = "UPDATE vehicle " +
            "SET id_salon = ?, name_salon = ?, id_profile = ?, cost = ? WHERE id_salon = ?";
    private final String DELETE_QUERY = "DELETE FROM spa WHERE id_salon = ?;";

    private static SpaSalon getSpaSalonFromResultSet(ResultSet resultSet) throws SQLException {
        SpaSalon spaSalon = new SpaSalon();
        spaSalon.setId(resultSet.getLong("id_salon"));
        spaSalon.setNameSalon(resultSet.getString("name_salon"));
        spaSalon.setCost(resultSet.getBigDecimal("cost"));
        spaSalon.setIdProfile(resultSet.getLong("id_profile"));
        return spaSalon;
    }
    public void insert(SpaSalon spaSalon) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, spaSalon.getNameSalon());
            statement.setLong(2, spaSalon.getIdProfile());
            statement.setBigDecimal(3, spaSalon.getCost());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public SpaSalon getById(long id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return getSpaSalonFromResultSet(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SpaSalon> getByIdProfile(long idProfile) {
        List<SpaSalon> spaSalons = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_PROFILE_QUERY);
            statement.setLong(1, idProfile);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                spaSalons.add(getSpaSalonFromResultSet(resultSet));
            }
            return spaSalons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(SpaSalon spaSalon) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setLong(1, spaSalon.getId());
            statement.setString(2, spaSalon.getNameSalon());
            statement.setLong(3, spaSalon.getIdProfile());
            statement.setBigDecimal(4, spaSalon.getCost());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(long id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

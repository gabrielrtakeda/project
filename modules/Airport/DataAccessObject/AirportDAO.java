package project.modules.Airport.DataAccessObject;

import project.modules.Application.Entity.AbstractEntity;
import project.modules.Database.DatabaseConnect;
import project.modules.Airport.Entity.AirportEntity;
import project.modules.Airport.Type.AirportEntityComboType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class AirportDAO extends DatabaseConnect
{
    private String table = "`Aeroporto`";
    private PreparedStatement preparedStatement;

    public Boolean register(AirportEntity airportEntity)
    {
        Boolean result = false;
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO " + table);
        query.append(" (`descricao`, `sigla`, `endereco`) VALUES");
        query.append(" (?, ?, ?);");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setString(1, airportEntity.getDescription());
            preparedStatement.setString(2, airportEntity.getAbbreviation());
            preparedStatement.setString(3, airportEntity.getAddress());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }

    public Boolean update(AirportEntity airportEntity)
    {
        Boolean result = false;
        StringBuilder query = new StringBuilder();
        query.append("UPDATE " + table);
        query.append(" SET `descricao` = ?");
        query.append(", `sigla` = ?");
        query.append(", `endereco` = ?");
        query.append(" WHERE `sigla` = ?");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setString(1, airportEntity.getDescription());
            preparedStatement.setString(2, airportEntity.getAbbreviation());
            preparedStatement.setString(3, airportEntity.getAddress());
            preparedStatement.setString(4, airportEntity.getAbbreviation());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }

    public AirportEntity consult(Integer id)
    {
        AirportEntity airportEntity = new AirportEntity();
        String query = "SELECT * FROM " + table + " WHERE `idAeroporto` = ?";
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            airportEntity = buildEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return airportEntity;
    }

    public List<AbstractEntity> consult(String column, String search)
    {
        List<AbstractEntity> entities = new ArrayList<AbstractEntity>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM " + table);
        query.append(" WHERE " + column + " LIKE ?");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setString(1, "%" + search + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                entities.add(
                    buildEntity(resultSet)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return entities;
    }

    private AirportEntity buildEntity(ResultSet resultSet)
    {
        AirportEntity airportEntity = new AirportEntity();

        try {
            if (resultSet.next()) {
                airportEntity.setId(resultSet.getInt("idAeroporto"))
                             .setDescription(resultSet.getString("descricao"))
                             .setAbbreviation(resultSet.getString("sigla"))
                             .setAddress(resultSet.getString("endereco"))
                             .setDateRegister(resultSet.getDate("dataCadastro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airportEntity;
    }

    public List<AirportEntity> load()
    {
        List<AirportEntity> entities = new ArrayList<AirportEntity>();
        String query = "SELECT * FROM " + table + " ORDER BY `descricao` ASC;";
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                AirportEntity airportEntity = new AirportEntity();
                entities.add(
                    airportEntity.setId(resultSet.getInt("idAeroporto"))
                                 .setDescription(resultSet.getString("descricao"))
                                 .setAbbreviation(resultSet.getString("sigla"))
                                 .setAddress(resultSet.getString("endereco"))
                                 .setDateRegister(resultSet.getDate("dataCadastro"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return entities;
    }

    public List<AirportEntityComboType> loadComboType()
    {
        List<AirportEntityComboType> entities = new ArrayList<AirportEntityComboType>();
        String query = "SELECT * FROM " + table + " ORDER BY `descricao` ASC;";
        try {
            preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                AirportEntityComboType airportEntity = new AirportEntityComboType();
                airportEntity.setId(resultSet.getInt("idAeroporto"))
                             .setDescription(resultSet.getString("descricao"))
                             .setAbbreviation(resultSet.getString("sigla"))
                             .setAddress(resultSet.getString("endereco"))
                             .setDateRegister(resultSet.getDate("dataCadastro"));

                entities.add(airportEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return entities;
    }

    public Boolean delete(AirportEntity airportEntity)
    {
        Boolean result = false;
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM " + table);
        query.append(" WHERE `idAeroporto` = ?");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setInt(1, airportEntity.getId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }
}

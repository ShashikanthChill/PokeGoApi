/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.services;

import com.the_humble_fool.PokeGoApi.models.servicemodels.TypeEffectivenessServiceModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author The_Humble_Fool
 */
@Service
public class TypeEffectivenessPublicService
{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<TypeEffectivenessServiceModel> getAllTypeEffectives()
    {
        List<TypeEffectivenessServiceModel> typeEffectivenessServiceModels = new ArrayList<>();

        getAllTypeEffectives(typeEffectivenessServiceModels);

        return typeEffectivenessServiceModels;
    }

    private void getAllTypeEffectives(List<TypeEffectivenessServiceModel> typeEffectivenessServiceModels)
    {
        jdbcTemplate.query("select * from type_effectiveness", (ResultSet rs, int rowNum) -> {
            ResultSetMetaData metaData = rs.getMetaData();
            rs.beforeFirst();
            while (rs.next()) {
                System.out.println("Col: " + metaData.getColumnName(2));
                TypeEffectivenessServiceModel typeEffectivenessServiceModel = new TypeEffectivenessServiceModel(rs.getString(2));
                for (int i = 3; i < metaData.getColumnCount(); i++) {
                    double aDouble = rs.getDouble(i);
                    if (aDouble == 0.0) {
                        typeEffectivenessServiceModel.getNoEffective().add(metaData.getColumnName(i));
                    } else if (aDouble == 0.5) {
                        typeEffectivenessServiceModel.getNotVeryEffective().add(metaData.getColumnName(i));
                    } else if (aDouble == 1.0) {
                        typeEffectivenessServiceModel.getNormalEffective().add(metaData.getColumnName(i));
                    } else if (aDouble == 2.0) {
                        typeEffectivenessServiceModel.getSuperEffective().add(metaData.getColumnName(i));
                    }
                }
                typeEffectivenessServiceModels.add(typeEffectivenessServiceModel);
            }
            return null;
        });
    }

    private void getSpecificTypeEffectives(List<TypeEffectivenessServiceModel> typeEffectivenessServiceModels, String type)
    {
        jdbcTemplate.query("select * from type_effectiveness where type='" + type + "'", new RowMapper<Object>()
        {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                ResultSetMetaData metaData = rs.getMetaData();
                rs.beforeFirst();
                TypeEffectivenessServiceModel typeEffectivenessServiceModel = null;
                while (rs.next()) {
                    System.out.println("Col: " + metaData.getColumnName(2));
                    typeEffectivenessServiceModel = new TypeEffectivenessServiceModel(rs.getString(2));
                    for (int i = 3; i < metaData.getColumnCount(); i++) {
                        double aDouble = rs.getDouble(i);
                        if (aDouble == 0.0) {
                            typeEffectivenessServiceModel.getNoEffective().add(metaData.getColumnName(i));
                        } else if (aDouble == 0.5) {
                            typeEffectivenessServiceModel.getNotVeryEffective().add(metaData.getColumnName(i));
                        } else if (aDouble == 1.0) {
                            typeEffectivenessServiceModel.getNormalEffective().add(metaData.getColumnName(i));
                        } else if (aDouble == 2.0) {
                            typeEffectivenessServiceModel.getSuperEffective().add(metaData.getColumnName(i));
                        }
                    }
                }
                if (typeEffectivenessServiceModel != null) {
                    typeEffectivenessServiceModels.add(typeEffectivenessServiceModel);
                }
                return null;
            }
        });
    }

    public List<TypeEffectivenessServiceModel> getSpecificTypeEffectives(String type)
    {
        List<TypeEffectivenessServiceModel> typeEffectivenessServiceModels = new ArrayList<>();
        getSpecificTypeEffectives(typeEffectivenessServiceModels, type);
        return typeEffectivenessServiceModels;
    }
}

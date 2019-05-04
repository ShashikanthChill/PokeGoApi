/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.jparepositories;

import com.the_humble_fool.PokeGoApi.models.entitymodels.ResearchBreakthroughEncountersEntityModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author The_Humble_Fool
 */
@Repository
public interface ResearchBreakthroughEncountersJpaRepo extends JpaRepository<ResearchBreakthroughEncountersEntityModel, Integer>
{

    public List<ResearchBreakthroughEncountersEntityModel> findByPokemonStartingWith(String pokemon);
}

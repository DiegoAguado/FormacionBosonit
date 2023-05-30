package com.block7crudvalidation.block7crudvalidation.Persona.repository;

import com.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonaRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonaOutputDto> getCustomQuery(HashMap<String, Object> conditions){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class);

        Root<Persona> root = query.from(Persona.class);

        //WHERE
        List<Predicate> predicates = new ArrayList<>();

        conditions.forEach((field, value) ->{
            switch (field){
                case "usuario":
                    predicates.add(cb.like(root.get(field), "%" + (String)value + "%"));
                    break;
                case "name":
                    predicates.add(cb.like(root.get(field), "%" + (String)value + "%"));
                    break;
                case "surname":
                    predicates.add(cb.like(root.get(field), "%" + (String)value + "%"));
                    break;
                case "created_date":
                    String dateCondition = (String)conditions.get("dateCondition");

                    switch (dateCondition){
                        case "greater":
                            predicates.add(cb.greaterThan(root.get("created_date"), (Date) value));
                            break;
                        case "less":
                            predicates.add(cb.lessThan(root.get("created_date"), (Date) value));
                            break;
                        case "equal":
                            predicates.add(cb.equal(root.get("created_date"), (Date) value));
                            break;
                    }
                    break;
                case "order":
                    String order = (String)conditions.get("order");

                    switch(order){
                        case "usuario":
                            query.orderBy(cb.asc(root.get("usuario")));
                            break;
                        case "name":
                            query.orderBy(cb.asc(root.get("name")));
                            break;
                    }
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));

        return entityManager.createQuery(query)
                .setMaxResults((int)conditions.get("pageSize"))
                .setFirstResult((int)conditions.get("pageNumber")*(int)conditions.get("pageSize"))
                .getResultList()
                .stream()
                .map(Persona::personaToPersonOutputDto)
                .toList();
    }
}

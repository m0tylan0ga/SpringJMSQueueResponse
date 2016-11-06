/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class QueueDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Queue queue) {
        entityManager.persist(queue);
    }

    public void delete(Queue queue) {
        if (entityManager.contains(queue)) {
            entityManager.remove(queue);
        }
    }

    public List<Queue> getAll() {
        return entityManager.createQuery("from Queue s LEFT JOIN FETCH s.user").getResultList();
    }

    public List<User> getAllSubscribedQueues() {
        return getAll().stream().map(i -> i.getUser()).collect(Collectors.toList());
    }

    public Queue getById(long id) {
        return entityManager.find(Queue.class, id);
    }

    public void update(Queue queue) {
        entityManager.merge(queue);
    }

}

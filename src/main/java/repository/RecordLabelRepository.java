package repository;

import entity.RecordLabels;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RecordLabelRepository {
    private final EntityManager entityManager;

    public RecordLabelRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<RecordLabels> getAllRecordLabels() {
        String query = "select rl from RecordLabels rl";
        TypedQuery<RecordLabels> typedQuery = entityManager.createQuery(query, RecordLabels.class);
        return typedQuery.getResultList();
    }

    public void createRecordLabel(RecordLabels recordLabels) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(recordLabels);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();

        }
    }

    public RecordLabels findRecordLabel(Long id) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();
        RecordLabels recordLabels = entityManager.find(RecordLabels.class, id);
        System.out.println(recordLabels.toString());
        entityManager.getTransaction().commit();
        return recordLabels;
    }

    public void updateRecordLabelName(Long id, String name) {
        entityManager.getEntityManagerFactory();

        entityManager.getTransaction().begin();

        RecordLabels recordLabels = entityManager.find(RecordLabels.class, id);
        recordLabels.setName(name);
        System.out.println(recordLabels);
        entityManager.getTransaction().commit();
    }

    public void deleteRecordLabel(Long id) {
        try {

            entityManager.getEntityManagerFactory();

            entityManager.getTransaction().begin();
            RecordLabels recordLabels = entityManager.find(RecordLabels.class, id);
            System.out.println(recordLabels.getName() + " has been removed \n");
            entityManager.remove(recordLabels);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();

        }
    }
}


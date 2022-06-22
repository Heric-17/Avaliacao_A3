package model.DAO;

import jakarta.persistence.*;
import org.hibernate.HibernateException;

import java.util.List;

@NamedQueries({@NamedQuery(name = "trazerTodosOsCursos", query = "select c from Curso c join fetch c.alunos")})
public class DAO<E> {

    private static EntityManager em;

    private Class<E> clazz;

    public DAO(Class<E> clazz) {
        if (em == null) {
            getEntityManager();
        }
        this.clazz = clazz;
    }

    public DAO() {
        if (em == null) {
            getEntityManager();
        }
        this.clazz = clazz;
    }

    private void getEntityManager() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("avaliacao_a3");
            em = emf.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public DAO<E> saveOneEntity(E entity) throws DAOException {
        try {
            this.openTransaction();
            em.persist(entity);
            this.closeTransaction();
            return this;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e.getCause());
        }
    }

    public DAO<E> saveEntity(E entity) throws DAOException {
        try {
            em.persist(entity);
            return this;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e.getCause());
        }
    }

    // READ
    public E getEntityById(int id) throws DAOException {
        try {
            E entityBd = em.find(clazz, id);
            return entityBd;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e.getCause());
        }
    }

    public List<E> getListEntities(int firsIndex, int quantity) throws DAOException {
        try {
            String jpql = "select e from " + clazz.getName() + " e";
            TypedQuery<E> query = em.createQuery(jpql, clazz);

            query.setFirstResult(firsIndex);
            query.setMaxResults(quantity);

            List<E> entities = query.getResultList();
            entities.forEach(e -> em.detach(e));

            return entities;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e.getCause());
        }
    }

    public List<E> getEntitiesByJPQL() throws DAOException {
        try {
            TypedQuery<E> query = em.createQuery("select c from Curso c join fetch c.alunos", clazz);

            List<E> entities = query.getResultList();

            return entities;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e.getCause());
        }
    }
    // UPDATE

    public DAO<E> updateOneEntity(E entity) throws DAOException {
        try {
            this.openTransaction();
            em.merge(entity);
            this.closeTransaction();
            return this;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e.getCause());
        }
    }

    // DELETE

    public DAO<E> deleteOneEntityById(int id) throws DAOException {
        try {
            E entity = this.getEntityById(id);
            this.openTransaction();
            em.remove(em.merge(entity));
            this.closeTransaction();
            return this;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e.getCause());

        }
    }

    public DAO<E> openTransaction() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> closeTransaction() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> rollBackTransaction() {
        em.getTransaction().rollback();
        return this;
    }

    public DAO<E> closeEntityManager() {
        em.close();
        return this;
    }
}

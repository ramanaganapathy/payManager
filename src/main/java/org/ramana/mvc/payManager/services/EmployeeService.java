package org.ramana.mvc.payManager.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ramana.mvc.payManager.domain.Employee;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {

    static private final String EmployeeS_REGION = "Employee";

    @PersistenceContext
    private EntityManager em;

    public Employee createEmployee(String firstName, String lastName, Date signupDate) {
        Employee Employee = new Employee();
        Employee.setFirstName(firstName);
        Employee.setLastName(lastName);
        Employee.setJoinDate(signupDate);
        em.persist(Employee);
        return Employee;
    }

    public Collection<Employee> search(String name) {
        String sqlName = ("%" + name + "%").toLowerCase();
        String sql = "select c.* from Employee c where (LOWER( c.firstName ) LIKE :fn OR LOWER( c.lastName ) LIKE :ln)";
        return em.createNativeQuery(sql, Employee.class)
                .setParameter("fn", sqlName)
                .setParameter("ln", sqlName)
                .getResultList();
    }


    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return em.createQuery("SELECT * FROM " + Employee.class.getName()).getResultList();
    }


    @Cacheable(EmployeeS_REGION)
    @Transactional(readOnly = true)
    public Employee getEmployeeById(Integer id) {
        return em.find(Employee.class, id);
    }

    @CacheEvict(EmployeeS_REGION)
    public void deleteEmployee(Integer id) {
        Employee Employee = getEmployeeById(id);
        em.remove(Employee);
    }

    @CacheEvict(value = EmployeeS_REGION, key = "#id")
    public void updateEmployee(Integer id, String fn, String ln, Date birthday) {
        Employee Employee = getEmployeeById(id);
        Employee.setLastName(ln);
        Employee.setJoinDate(birthday);
        Employee.setFirstName(fn);
        //sessionFactory.getCurrentSession().update(Employee);
        em.merge(Employee);
    }
}

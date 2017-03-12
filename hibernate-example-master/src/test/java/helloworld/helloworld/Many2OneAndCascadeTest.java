/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-20 14:41 创建
 *
 */
package helloworld.helloworld;

import org.hibernate.Session;
import org.junit.Test;

import helloworld.AbstractHibernateBaseTest;
import hibernate.xml.relation.many2one.Department;
import hibernate.xml.relation.many2one.Employee;

/**
 * @author jxilong@yiji.com
 */
public class Many2OneAndCascadeTest extends AbstractHibernateBaseTest {

    /**
     * 1.inverse=false,表示多一方也维护关系
     *      BOTH:先保存deartment,再保存 Employee.出现五条记录，两条更新.(更新是多方维护,)
     *           先保存Employee,再保存deartment.出现七条记录，四条更新(由于先插入Employee，他先不知道department,他知道department只有更新，维护。前面通过insert维护)
     *      DEPARTMENT:先保存deartment,再保存 Employee.出现五条记录，两条更新.(更新是多方维护,department 插入是null)
     *                 先保存Employee,再保存deartment.出现五条记录，两条更新.(更新是多方维护,department 插入是null)
     *      EMPLOYEE:先保存deartment,再保存Employee.出现三条。（DEPARTMENT为空无法维护）
     *               先保存Employee,再保存deartment.出现五条记录
     *
     * 2.inverse=true.表示多方放弃维护关系
     *           BOTH:先保存deartment,再保存 Employee.出现三条(多方放弃维护关系)
     *                先保存Employee,再保存deartment.出现五条记录(Employee 两条更新)
     *           DEPARTMENT:先保存deartment,再保存 Employee.出现三条记录(department 插入是null)
     *                      先保存Employee,再保存deartment.出现三条记录(更新是多方维护,department 插入是null,但没有set都不产生更新)
     *           EMPLOYEE:先保存deartment,再保存Employee.出现三条。（DEPARTMENT或inverse=true为空无法维护）
     *                    先保存Employee,再保存deartment.出现五条记录（关系是由Employee的department不为空又维护关系，所以出现更新）
     */
	@Test
	public void testSave() {
		Department department = new Department();
		department.setName("department");

		Department department2 = new Department();
        department2.setName("department2");

		Employee xiaoming = new Employee();
		xiaoming.setName("xiaoming");
		Employee glory = new Employee();
        glory.setName("glory");
		
		//关系
		xiaoming.setDepartment(department);
		glory.setDepartment(department);
		department.addEmployee(xiaoming);
		department.addEmployee(glory);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
        session.save(glory);
        session.save(department2);
        session.save(xiaoming);
        session.save(department);
		session.getTransaction().commit();
	}

    /**
     * 1.inverse=true
     *      DEPARMENT:有关系直接抛异常，因为无维护关系无法更新  MySQLIntegrityConstraintViolationException;没有关系,直接删除DEPARMENT
     *      EMPLOYEE; 有关系直接删除EMPLOYEE
     *
     * 2.inverse=false
     *     DEPARMENT:有关系先更新相关为空，直接删除自己
     *     EMPLOYEE; 有关系直接删除EMPLOYEE
     */
    @Test
    public void testDelete() {
        testSave();

        Session session = sessionFactory.openSession();

        logger.info("----------------------");
        session.beginTransaction();
        Department department = session.get(Department.class, 2L);
        session.delete(department);
        //session.delete(employee);
        session.getTransaction().commit();
    }

    @Test
    public void tesDepartmentCascade() {
        testSave();

        Session session = sessionFactory.openSession();

        logger.info("----------------------");
        session.beginTransaction();
        Department department = session.get(Department.class, 2L);
        session.delete(department);
        session.getTransaction().commit();
    }


    @Test
    public void testSaveCascade() {
        Department department = new Department();
        department.setName("department");

        Department department2 = new Department();
        department2.setName("department2");

        Employee xiaoming = new Employee();
        xiaoming.setName("xiaoming");
        Employee glory = new Employee();
        glory.setName("glory");

        //关系
        xiaoming.setDepartment(department);
        glory.setDepartment(department);
        department.addEmployee(xiaoming);
        department.addEmployee(glory);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(department);
        session.getTransaction().commit();
    }

}

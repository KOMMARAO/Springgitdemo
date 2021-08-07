/*package com.studentvalidation.dao;

 * package com.studentdatajpa.dao;
 * 
 * import java.util.List; import javax.persistence.EntityManager; import
 * javax.persistence.PersistenceContext; import javax.persistence.TypedQuery;
 * import javax.transaction.Transactional; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.studentdatajpa.entity.Student;
 * 
 * @Repository
 * 
 * @Transactional public class StudentDaoImpl implements StudentDao {
 * 
 * @PersistenceContext private EntityManager entity; // getting the entity
 * manager implementation object to // make database transactions.
 * 
 * public void setEntityManager(EntityManager entityManager) { this.entity =
 * entityManager; }
 * 
 * @Override public void addStudent(Student student) { // inserting the student
 * object into the database entity.persist(student); }
 * 
 * @Override public void updateStudent(Student student) { // updating the
 * student data using merge method entity.merge(student); }
 * 
 * @Override public void removeStudent(int id) { // finding the student detail
 * from the id and passing that object to the remove // method of entityManager
 * Student stu = entity.find(Student.class, id); entity.remove(stu); }
 * 
 * @Override public Student getStudentById(int id) { // finding the specific
 * student details based on the id passed return entity.find(Student.class, id);
 * }
 * 
 * @Override public List<Student> getAllStudents() { // Creating a query to get
 * the data from student table and storing it in a list // and returning the
 * list TypedQuery<Student> query =
 * entity.createQuery("SELECT s FROM Student s", Student.class); return
 * query.getResultList(); }
 * 
 * }
 */
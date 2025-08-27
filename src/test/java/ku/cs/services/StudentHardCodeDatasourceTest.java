package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    @Test
    void testReadData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList studentList = datasource.readData();

        assertEquals(4, studentList.getStudents().size());

        Student student1 = studentList.getStudents().get(0);
        assertEquals("6710400001", student1.getId());
        assertEquals("First", student1.getName());

        Student student2 = studentList.getStudents().get(1);
        assertEquals("6710400002", student2.getId());
        assertEquals("Second", student2.getName());

        Student student3 = studentList.getStudents().get(2);
        assertEquals("6710400003", student3.getId());
        assertEquals("Third", student3.getName());

        Student student4 = studentList.getStudents().get(3);
        assertEquals("6710400004", student4.getId());
        assertEquals("Fourth", student4.getName());
    }
}

package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListHardCodeDatasourceTest {

    @Test
    void testReadData() {
        StudentListHardCodeDatasource datasource = new StudentListHardCodeDatasource();

        StudentList studentList = datasource.readData();

        assertEquals(10, studentList.getStudents().size(), "จำนวนของนักเรียนต้องเท่ากับ 10");

        Student student1 = studentList.getStudents().get(0);
        assertEquals("6710400001", student1.getId());
        assertEquals("First", student1.getName());

        Student student2 = studentList.getStudents().get(1);
        assertEquals("6710400002", student2.getId());
        assertEquals("Second", student2.getName());

        Student student3 = studentList.getStudents().get(2);
        assertEquals("6710400003", student3.getId());
        assertEquals("Third", student3.getName());

        Student student10 = studentList.getStudents().get(9);
        assertEquals("67104000010", student10.getId());
        assertEquals("Tenth", student10.getName());
    }
}

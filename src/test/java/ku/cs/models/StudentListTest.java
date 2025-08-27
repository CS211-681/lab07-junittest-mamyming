package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่ด้วย id และ name")
    void testAddNewStudentByIdAndName() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "สมชาย");

        assertEquals(1, studentList.getStudents().size());
        assertEquals("สมชาย", studentList.getStudents().get(0).getName());
        assertEquals("6xxxxxxxx", studentList.getStudents().get(0).getId());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่ด้วย id, name และ score")
    void testAddNewStudentByIdNameAndScore() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "สมหญิง", 85);

        assertEquals(1, studentList.getStudents().size());
        assertEquals(85, studentList.getStudents().get(0).getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนที่มี id ซ้ำกัน")
    void testAddStudentWithDuplicateId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "สมชาย");
        studentList.addNewStudent("6xxxxxxxx", "สมหญิง");

        assertEquals(1, studentList.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบการค้นหานักเรียนจาก id")
    void testFindStudentById() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "สมปอง");

        Student student = studentList.findStudentById("6xxxxxxxx");
        assertNotNull(student);
        assertEquals("สมปอง", student.getName());

        Student nonExistentStudent = studentList.findStudentById("7xxxxxxxx");
        assertNull(nonExistentStudent);
    }

    @Test
    @DisplayName("ทดสอบการกรองนักเรียนตามชื่อ")
    void testFilterByName() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "สมชาย");
        studentList.addNewStudent("7xxxxxxxx", "สมหญิง");
        studentList.addNewStudent("8xxxxxxxx", "หมายปอง");

        StudentList filteredList = studentList.filterByName("สม");
        assertEquals(2, filteredList.getStudents().size());
        assertEquals("สมชาย", filteredList.getStudents().get(0).getName());
        assertEquals("สมหญิง", filteredList.getStudents().get(1).getName());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนนักเรียนจาก id")
    void testGiveScoreToId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "สมชาย", 75);

        studentList.giveScoreToId("6xxxxxxxx", 10);
        assertEquals(85, studentList.getStudents().get(0).getScore());

        studentList.giveScoreToId("7xxxxxxxx", 10);
        assertEquals(85, studentList.getStudents().get(0).getScore());
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดของนักเรียนจาก id")
    void testViewGradeOfId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "สมชาย", 85);

        String grade = studentList.viewGradeOfId("6xxxxxxxx");
        assertEquals("A", grade);

        String gradeNotFound = studentList.viewGradeOfId("7xxxxxxxx");
        assertNull(gradeNotFound);
    }
}

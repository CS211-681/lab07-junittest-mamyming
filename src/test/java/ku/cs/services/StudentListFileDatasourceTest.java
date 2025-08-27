package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class StudentListFileDatasourceTest {

    private String testDirectory;
    private String testFile;
    private StudentListFileDatasource datasource;

    @BeforeEach
    void setUp() throws IOException {
        testDirectory = Files.createTempDirectory("testDir").toString();
        testFile = "students.csv";
        datasource = new StudentListFileDatasource(testDirectory, testFile);

        StudentList studentList = new StudentList();
        studentList.addNewStudent("6710400001", "First", 85);
        studentList.addNewStudent("6710400002", "Second", 90);
        datasource.writeData(studentList);
    }

    @Test
    void testReadData() {
        StudentList studentList = datasource.readData();

        assertEquals(2, studentList.getStudents().size());

        Student student1 = studentList.getStudents().get(0);
        assertEquals("6710400001", student1.getId());
        assertEquals("First", student1.getName());
        assertEquals(85, student1.getScore());

        Student student2 = studentList.getStudents().get(1);
        assertEquals("6710400002", student2.getId());
        assertEquals("Second", student2.getName());
        assertEquals(90, student2.getScore());
    }

    @Test
    void testWriteData() throws IOException {
        StudentList newStudentList = new StudentList();
        newStudentList.addNewStudent("6710400003", "Third", 95);
        newStudentList.addNewStudent("6710400004", "Fourth", 80);

        datasource.writeData(newStudentList);

        StudentList studentList = datasource.readData();

        assertEquals(2, studentList.getStudents().size());

        Student student1 = studentList.getStudents().get(0);
        assertEquals("6710400003", student1.getId());
        assertEquals("Third", student1.getName());
        assertEquals(95, student1.getScore());

        Student student2 = studentList.getStudents().get(1);
        assertEquals("6710400004", student2.getId());
        assertEquals("Fourth", student2.getName());
        assertEquals(80, student2.getScore());
    }

    @Test
    void testFileCreation() {
        File file = new File(testDirectory + File.separator + testFile);
        assertTrue(file.exists());
    }

    @Test
    void testCheckFileIsExisted() {
        StudentListFileDatasource newDatasource = new StudentListFileDatasource(testDirectory, "newstudents.csv");
        File newFile = new File(testDirectory + File.separator + "newstudents.csv");
        assertTrue(newFile.exists());
    }
}

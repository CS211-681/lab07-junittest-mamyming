package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อที่ถูกต้อง")
    void testChangeName() {
        Student s = new Student("6xxxxxxxx", "OldName");
        s.changeName("NewName");
        assertEquals("NewName", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนนเป็นค่าลบ")
    void testAddNegativeScore() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(-10);
        assertEquals(0, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรด F เมื่อคะแนนน้อยกว่า 50")
    void testGradeF() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(45);
        assertEquals("F", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรด D เมื่อคะแนนมากกว่าหรือเท่ากับ 50")
    void testGradeD() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(55);
        assertEquals("D", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรด C เมื่อคะแนนมากกว่าหรือเท่ากับ 60")
    void testGradeC() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(60);
        assertEquals("C", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรด B เมื่อคะแนนมากกว่าหรือเท่ากับ 70")
    void testGradeB() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(75);
        assertEquals("B", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรด A เมื่อคะแนนมากกว่าหรือเท่ากับ 80")
    void testGradeA() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการค้นหาชื่อจาก id")
    void testIsId() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        assertEquals(true, s.isId("6xxxxxxxx"));
        assertEquals(false, s.isId("6xxxxxxx1"));
    }

    @Test
    @DisplayName("ทดสอบการค้นหาชื่อจากบางส่วนของชื่อ")
    void testIsNameContains() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        assertEquals(true, s.isNameContains("stu"));
        assertEquals(false, s.isNameContains("sybau"));
    }

    @Test
    @DisplayName("ทดสอบการแสดงผลของ toString()")
    void testToString() {
        Student s = new Student("6xxxxxxxx", "StudentTest", 85);
        String expected = "{id: '6xxxxxxxx', name: 'StudentTest', score: 85.0}";
        assertEquals(expected, s.toString());
    }


}
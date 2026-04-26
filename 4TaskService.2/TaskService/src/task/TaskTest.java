package task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {
	
    @Test
    public void testTaskCreatedSuccessfully() {
        Task task = new Task("Task 1", "Homework", "Finish Java assignment");

        assertEquals("Task 1", task.getTaskId());
        assertEquals("Homework", task.getName());
        assertEquals("Finish Java assignment", task.getDescription());
    }

    @Test
    public void testTaskIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Homework", "Finish Java assignment");
        });
    }

    @Test
    public void testTaskIdCannotBeMoreThan10Characters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("Task 123456789", "Homework", "Finish Java assignment");
        });
    }

    @Test
    public void testNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("Task 1", null, "Finish Java assignment");
        });
    }

    @Test
    public void testNameCannotBeMoreThan20Characters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("Task 1", "Homework-For-Course-320", "Finish Java assignment");
        });
    }

    @Test
    public void testDescriptionCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("Task 1", "Homework", null);
        });
    }

    @Test
    public void testDescriptionCannotBeMoreThan50Characters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("Task 1", "Homework",
                    "Description for task 1 cannot be longer than fifty characters.");
        });
    }

    @Test
    public void testSetNameSuccessfully() {
        Task task = new Task("Task 1", "Homework", "Finish Java assignment");
        task.setName("Project1");

        assertEquals("Project1", task.getName());
    }

    @Test
    public void testSetDescriptionSuccessfully() {
        Task task = new Task("Task 1", "Homework", "Finish Java assignment");
        task.setDescription("Code Java Project");

        assertEquals("Code Java Project", task.getDescription());
    }

    @Test
    public void testSetNameInvalid() {
        Task task = new Task("Task 1", "Homework", "Finish Java assignment");

        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    public void testSetDescriptionInvalid() {
        Task task = new Task("Task 1", "Homework", "Finish Java assignment");

        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }

}

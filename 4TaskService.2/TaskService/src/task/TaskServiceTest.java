package task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskServiceTest {
	
	@Test
    public void testAddTaskSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("Project", "Homework", "Complete milestone 4");

        service.addTask(task);

        assertEquals(task, service.getTask("Project"));
    }

    @Test
    public void testAddDuplicateTaskIdFails() {
        TaskService service = new TaskService();
        Task task1 = new Task("Project", "Homework", "Complete milestone 4");
        Task task2 = new Task("Project", "Study", "Read Resources");

        service.addTask(task1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    @Test
    public void testDeleteTaskSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("Project", "Homework", "Complete milestone 4");

        service.addTask(task);
        service.deleteTask("Project");

        assertNull(service.getTask("Project"));
    }

    @Test
    public void testDeleteTaskWithInvalidIdFails() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("Invalid Task Id");
        });
    }

    @Test
    public void testUpdateNameSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("Project", "Homework", "Complete milestone 4");

        service.addTask(task);
        service.updateName("Project", "Assignment");

        assertEquals("Assignment", service.getTask("Project").getName());
    }

    @Test
    public void testUpdateDescriptionSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("Project", "Homework", "Complete milestone 4");

        service.addTask(task);
        service.updateDescription("Project", "Write Journal Mod4");

        assertEquals("Write Journal Mod4", service.getTask("Project").getDescription());
    }

    @Test
    public void testUpdateNameWithInvalidTaskIdFails() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateName("Invalid Task Name", "Assignment");
        });
    }

    @Test
    public void testUpdateDescriptionWithInvalidTaskIdFails() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateDescription("Invalid Task Description", "New description");
        });
    }

}

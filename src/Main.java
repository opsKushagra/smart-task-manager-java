import controller.TaskController;
import dao.FileTaskDAO;
import service.TaskService;
import view.TaskDashboardView;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaskService service = new TaskService(new FileTaskDAO());
            TaskDashboardView view = new TaskDashboardView();
            new TaskController(service, view);
            view.setVisible(true);
        });
    }
}

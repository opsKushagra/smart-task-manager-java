package dao;

import model.Task;
import java.util.List;

public interface TaskDAO {

    void save(List<Task> tasks);

    List<Task> load();
}

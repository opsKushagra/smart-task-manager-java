package dao;

import model.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTaskDAO implements TaskDAO {

    private static final String FILE_NAME = "tasks.dat";

    @Override
    public void save(List<Task> tasks) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Task> load() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

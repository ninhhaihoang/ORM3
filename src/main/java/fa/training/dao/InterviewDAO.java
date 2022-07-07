package fa.training.dao;

import fa.training.entities.Interview;

import java.util.List;

public interface InterviewDAO {
    List<Interview> findAll();
    Interview findById(int id);
    void save(Interview interview);
    void saveAll(List<Interview> interviews);
    void delete(int id);
}

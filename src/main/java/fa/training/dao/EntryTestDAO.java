package fa.training.dao;

import fa.training.entities.EntryTest;

import java.util.List;

public interface EntryTestDAO {
    List<EntryTest> findAll();
//    List<EntryTest> findAllBy();
    EntryTest findById(int id);
    void save(EntryTest entryTest);
    void saveAll(List<EntryTest> entryTest);
    void delete(int id);
}

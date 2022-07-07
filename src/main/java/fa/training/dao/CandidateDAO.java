package fa.training.dao;

import fa.training.entities.Candidate;

import java.util.Date;
import java.util.List;

public interface CandidateDAO {

    List<Candidate> findAll();
    Candidate findById(int id);
    List<Candidate> findAllBySkillAndLevel(String skill, int level);
    List<Candidate> findAllBySkillAndEntryTestResult(String skill, String result, Date date);
    List<Candidate> findAllByForeignLanguageAndSkill(String foreignLanguage, String skill);
    List<Candidate> findAllByResultInterviewAndDate(String result, Date date);
    void save(Candidate candidate);
    void saveAll(List<Candidate> candidates);
    void delete(int id);
}

package dao;
import java.util.List;
import model.Skill;
public interface ISkillDao {
List<Skill>getAllSkill();
void addSkill(Skill s);
Skill getSkillByID(int id);
void updateSkill(Skill s);
void deactivateSkill(Skill s);
void  activateSkill(Skill s);
void deleteSkill(int id);
}

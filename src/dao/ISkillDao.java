package dao;
import java.util.List;
import model.Skill;
public interface ISkillDao {
List<Skill>getAllSkill();
void addSkill(Skill s);
Skill getSkillByID(int id);
void updteSkill(Skill s);
void deactivateSkill(int id);
void deleteSkill(int id);
}

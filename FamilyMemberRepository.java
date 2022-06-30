package project.vacation.familyMember;

import org.springframework.data.repository.CrudRepository;

// Speichert die FamilyMember Tabelle

public interface FamilyMemberRepository extends CrudRepository<FamilyMember, String> {

}

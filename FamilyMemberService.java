package project.vacation.familyMember;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyMemberService {

	@Autowired
	private FamilyMemberRepository familyMemberRepository;

	public List<FamilyMember> getFamilyMemberList() {
		ArrayList<FamilyMember> FamilyList = new ArrayList<>();
		Iterator<FamilyMember> itFamily = familyMemberRepository.findAll().iterator();
		while (itFamily.hasNext())
			FamilyList.add(itFamily.next());
		return FamilyList;
	}

	public FamilyMember getFamilyMember(String id) {

		return familyMemberRepository.findById(id).orElse(null);
	}

	public void addFamilyMember(FamilyMember familyMember) {

		familyMemberRepository.save(familyMember);
	}

	public void updateFamilyMember(String id, FamilyMember familyMember) {

		familyMemberRepository.save(familyMember);
	}

	public void deleteFamilyMember(String id) {

		familyMemberRepository.deleteById(id);
	}
}
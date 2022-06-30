package project.vacation.familyMember;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// DIe Methoden die für das Bearbeiten der FamilyMember Tabelle benötigt wird

@Service
public class FamilyMemberService {

	@Autowired
	private FamilyMemberRepository familyMemberRepository; 	// Methoden in dieser Klasse bearbeiten dieses Repository

	// Holt alle Objekte aus FamilyMemberRepository und gibt diese aus
	public List<FamilyMember> getFamilyMemberList() {
		ArrayList<FamilyMember> FamilyList = new ArrayList<>();
		Iterator<FamilyMember> itFamily = familyMemberRepository.findAll().iterator();
		while (itFamily.hasNext())
			FamilyList.add(itFamily.next());
		return FamilyList;
	}

	// Gibt FamilyMember mit ausgewälter id aus. Wenn keiner gefunden wird nichts
	public FamilyMember getFamilyMember(String id) {

		return familyMemberRepository.findById(id).orElse(null);
	}

	// Fügt neuen FamilyMember hinzu
	public void addFamilyMember(FamilyMember familyMember) {

		familyMemberRepository.save(familyMember);
	}

	//Lässt den Benutzer FamilyMember bearbeiten
	public void updateFamilyMember(String id, FamilyMember familyMember) {

		familyMemberRepository.save(familyMember);
	}

	// Lässt den Benutzer FamilyMember löschen
	public void deleteFamilyMember(String id) {

		familyMemberRepository.deleteById(id);
	}
}
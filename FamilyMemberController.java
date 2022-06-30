package project.vacation.familyMember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Klasse beinhaltet die Controller für die FamilyMember Tabelle

@RestController
public class FamilyMemberController {

	@Autowired
	FamilyMemberService familyMemberService;
	
	@RequestMapping("/FamilyMember")
	public List<FamilyMember> getFamilyMemberList(){
		return familyMemberService.getFamilyMemberList();
	}
	
	@RequestMapping("FamilyMember/{id}")
	public FamilyMember getFamilyMember(@PathVariable String id) {
		return familyMemberService.getFamilyMember(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/FamilyMember")
	public void addFamilyMember(@RequestBody FamilyMember familyMember) {
		familyMemberService.addFamilyMember(familyMember);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/FamilyMember/{id}")
	public void updateFamilyMember(@PathVariable String id, @RequestBody FamilyMember familyMember) {
		familyMemberService.updateFamilyMember(id, familyMember);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/FamilyMember/{id}")
	public void deleteFamilyMember(@PathVariable String id) {
		familyMemberService.deleteFamilyMember(id);
	}
	
}
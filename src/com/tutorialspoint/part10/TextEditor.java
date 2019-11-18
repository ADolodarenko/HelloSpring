package com.tutorialspoint.part10;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	
	//@Autowired
	private SpellChecker spellChecker;
	
	@Autowired
	public TextEditor(SpellChecker spellChecker) {
		System.out.println("Inside TextEditor constructor." );
		
		this.spellChecker = spellChecker;
	}
	
//	public SpellChecker getSpellChecker() {
//		return spellChecker;
//	}

//	@Autowired
//	public void setSpellChecker(SpellChecker spellChecker) {
//		this.spellChecker = spellChecker;
//	}
	
	public void spellCheck() {
		spellChecker.checkSpelling();
	}

}

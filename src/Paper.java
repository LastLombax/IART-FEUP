package src;
import java.util.ArrayList;

import database.Database;

/**
 * This class represents a Session,
 * which is a gene from a Conference
 */
public class Paper {
	
	private ArrayList<Integer> themes = new ArrayList<Integer>();
	private ArrayList<Integer> authors = new ArrayList<Integer>();
	private int duration;
	private boolean isFullPaper;
	private String gene;
	private int presenter;
	
	/**
	 * Creates a Paper, which is composed by themes, authors,
	 * duration and if it's full paper or short paper
	 * @param paper String containing all the information related to the paper
	 */
	public Paper(String paper) {
		int index = 0;
		
		presenter = Integer.parseInt(Utilities.binToDec(paper.substring(index, index += Utilities.PRESENTER)));
		
		
		for (int i = 0; i < Utilities.AUTHORS_PER_PAPER; i++) {
						
			String subs = paper.substring(index, index += Utilities.AUTHORS);
			String bintoDec = Utilities.binToDec(subs);
		
			int b = Integer.parseInt(bintoDec);
			this.authors.add(b);
		}
		
		for (int i = 0; i < Utilities.THEMES_PER_PAPER; i++) 
			this.themes.add(Integer.parseInt(Utilities.binToDec(paper.substring(index, index += Utilities.THEME))));
		

		this.isFullPaper = paper.substring(index, index++).equals("0") ? false : true;
		
		if (this.isFullPaper)
			this.duration=30;
		else
			this.duration=20;
		
		createGenome();
	}
	
	/**
	 * Creates the genome of a paper 
	 * and sets it
	 */
	public void createGenome() {
		String themesG ="";
		for (int theme : themes) 
			themesG += Utilities.transform2Bin(theme, Utilities.THEME);
		
		String authorsG = "";
		for (int author : authors) 
			authorsG += Utilities.transform2Bin(author, Utilities.AUTHORS);
		
		this.gene = authorsG + themesG + this.isFullPaper;
	}

	/**
	 * Returns the gene related to the paper
	 * @return The gene
	 */
	public String getGene() {
		return this.gene;
	}

	/**
	 * Returns the themes of the paper
	 * @return themes
	 */
	public ArrayList<Integer> getThemes() {
		return themes;
	}
	
	/**
	 * Returns the authors of the paper
	 * @return authors
	 */
	public ArrayList<Integer> getAuthors() {
		return authors;
	}

	/**
	 * Checks if paper is Full Paper
	 * @return true if full paper, false if short paper
	 */
	public boolean isFullPaper() {
		return isFullPaper;
	}

	/**
	 * Returns the duration of the paper
	 * @return duration
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * Checks if the paper if valid
	 * @return true if valid, false otherwise
	 */
	public boolean isValid() {
		return gene.contains("1");
	}
	
	/**
	 * Checks if the presenter of the paper is an author of the paper
	 * @return true if is author, false otherwise
	 */
	public boolean checkIfPresenterIsAuthor() {
		return authors.contains(presenter);
	}
	
	/**
	 * Returns the presenter of the paper
	 * @return presenter
	 */
	public int getPresenter() {
		return presenter;
	}
	
	/**
	 * Converts a Paper to a human-friendly string
	 */
	@Override
	public String toString() {
		String info = "";
		
		info += "Paper Themes: ";
		for (int i = 0; i < themes.size() ; i++) {
			if (i == themes.size()-1)
				info += Database.getThemessByID(themes.get(i));
			else
				info += Database.getThemessByID(themes.get(i)) + ", ";
		}
		info += "\n";
		info += "Authors: ";
		for (int i = 0; i < authors.size() ; i++) {
			if (i == authors.size()-1)
				info += Database.getAuthorsByID(authors.get(i));
			else
				info += Database.getAuthorsByID(authors.get(i)) + ", ";
		}
		info += "\n";
		info += (isFullPaper) ? "Full Paper\n" : "Short Paper\n";
		info += "Presenter: " + Database.getAuthorsByID(presenter) + "\n";
		info += "Duration: " + duration + "\n";
		
		return info;
	}

	/**
	 * Checks if authors are all different
	 * @return false if are all different, true otherwise
	 */
	public boolean checkIfAuthorsAreAllDiff() {

		for(int i = 0; i < authors.size(); i++)
			for (int j = i+1; j < authors.size(); j++)			
				if (authors.get(i) == authors.get(j))
					return false;			
		
		return true;			
	}
	


}

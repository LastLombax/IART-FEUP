import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class Session {
	//dura��o, tema, papers(2 full papers no minimo), apresentador, dia da apresenta��o

	private int themeID;
	private int durationID;
	private ArrayList<Paper> papers = new ArrayList<Paper>();
	private String genome;
	private int sessionSchedule;
	
	/**
	 * Creates a session
	 * @param session String containing all the information related to the session
	 */
	public Session(String session) {
		this.sessionSchedule = Integer.parseInt(Utilities.binToDec(session.substring(0, 2)));//0..1
		int index = 2;
		
		this.themeID = Integer.parseInt(Utilities.binToDec(session.substring(index, index+Utilities.THEME)));//0..1
		index += Utilities.THEME;

		this.durationID = Integer.parseInt(Utilities.binToDec(session.substring(index, index += Utilities.DURATION)));//2...4
		
//		String cromo = "11 001 000110111";
		for (int i = 0; i < Utilities.PAPERS_PER_SESSION; i++) {
			System.out.println("Paper " + i);
			String paper = session.substring(index, index += Utilities.getPaperSize());
			this.papers.add(new Paper(paper));
		}

		System.out.println("Theme ID: "+ themeID);
		System.out.println("Duration ID: "+ durationID);
		System.out.println("Period: "+ sessionSchedule);
		
		createGenome();
	}
	
	// TT DD PPPPPP PPPPPPP

	/**
	 * Creates a genome with all the elements
	 */
	private void createGenome() {
		
		String papersGene = "";
		int fullPapers = 0;
		for (Paper paper : papers) 
			papersGene += paper.getGene();

		this.genome = Utilities.transform2Bin(this.themeID, Utilities.SESSION_THEME)
					+ Utilities.transform2Bin(this.durationID, Utilities.DURATION)
					+ papers;
	}
	
	/**
	 * Returns the genome of the session
	 * @return genome
	 */
	public String getGenome() {
		return this.genome;
	}
	
	/**
	 * Returns the schedule of the session
	 * @return schedule
	 */
	public int getSchedule() {
		return this.sessionSchedule;
	}
	
	/**
	 * Returns the papers of the session
	 * @return genome
	 */
	public ArrayList<Paper> getPapers() {
		return this.papers;
	}
	
	/**
	 * Returns the number of fullPapers of the session
	 * @return number of fullPapers
	 */
	public int getNumberOfFullPapers() {
		int i = 0;
		for (Paper p: papers)
			if (p.isFullPaper())
				i++;
		return i;
	}
	
	/**
	 * Returns a value relating the Session theme with the papers themes.
	 * @return value
	 */
	public double checkThemesID() {
		double score = 0;	
		for (Paper p: papers) {
			for (int t: p.getThemes()) {
				if (t == this.themeID) {
					score += 1.0 / getNumberOfValidPapers(); 
					break;
				}
			}
		}
		return score;
	}

	/**
	 * Returns number of valid papers
	 * @return number of valid papers
	 */
	public int getNumberOfValidPapers() {
		int validPapers = 0;
		for (Paper p: papers) {
			if (p.isValid()) {
				validPapers++;
			}
		}
		return validPapers;
	}

	/**
	 * Returns the duration value of the session
	 * @return durationID
	 */
	public int getDuration() {
		return this.durationID;
	}

}

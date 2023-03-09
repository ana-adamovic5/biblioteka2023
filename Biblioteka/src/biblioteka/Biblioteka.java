package biblioteka;

import java.util.ArrayList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterface;



public class Biblioteka implements BibliotekaInterface {
	
	private List<Knjiga> knjige=new ArrayList<Knjiga>();
	

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if(knjiga==null) {
			throw new NullPointerException("Knjiga ne sme biti null!");
		}
		if(knjige.contains(knjiga)) {
			throw new IllegalArgumentException("Knjiga je duplikat.");
		}
		
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {

		if(autor==null && isbn<0 && naslov==null && izdavac==null) {
			throw new IllegalArgumentException("Morate uneti bar jedan kriterijum pretrage!");
		}


		List<Knjiga> rezultati=new ArrayList<Knjiga>();
		
		if(naslov!=null)
		for (Knjiga knjiga : knjige) {
			if(knjiga.getNaslov().toLowerCase().contains(naslov))
				rezultati.add(knjiga);
		}
		return rezultati;
	}

}
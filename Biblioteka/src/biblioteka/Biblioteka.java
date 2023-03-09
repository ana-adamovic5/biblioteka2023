package biblioteka;

import java.util.ArrayList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterface;



public class Biblioteka implements BibliotekaInterface {
	
	private List<Knjiga> knjige=new ArrayList<Knjiga>();
	

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
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
		List<Knjiga> rezultati=new ArrayList<Knjiga>();
		for (Knjiga knjiga : knjige) {
			if(knjiga.getNaslov().contains(naslov))
				rezultati.add(knjiga);
		}
		return rezultati;
	}

}
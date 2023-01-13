package namegenerator;

public class Tester {
	private boolean lapi;

	public Tester() {
		lapi = true;
		Trie puu = new Trie(3);
		Solmu juuri = new Solmu (" ");
		puu.SetRoot(juuri);
		puu.SetNow(juuri);
		puu.GetTree().add(juuri);
		puu.OpetaMerkkijono("abc");
		puu.OpetaMerkkijono("acc");
		puu.OpetaMerkkijono("map");
		puu.OpetaMerkkijono("cop");
		puu.OpetaMerkkijono("jaa");
		puu.OpetaMerkkijono("bac");
		puu.OpetaMerkkijono("aaa");
		puu.OpetaMerkkijono("bap");
		puu.OpetaMerkkijono("nec");
		puu.OpetaMerkkijono("kok");
		puu.OpetaMerkkijono("lip");
		if (puu.GetRoot().GetLapsiS("a").GetKaynnit() != 3 || puu.GetRoot().GetLapsiS("b").GetLapsiS("a").GetKaynnit() != 2) {
			System.out.println("Testi 'opeta merkkijono' ei mennyt läpi");
			lapi = false;
			return;
		}
		
		Opetus ope3 = new Opetus(3, "Kiina");
		ope3.OpetaNimi("Matti", 3);
		ope3.OpetaNimi("Maija", 3);
		ope3.OpetaNimi("Maaren", 3);
		ope3.OpetaNimi("Kaija", 3);
		ope3.OpetaNimi("Keijo", 3);
		ope3.OpetaNimi("Veikka", 3);
		ope3.OpetaNimi("Liisi", 3);
		ope3.OpetaNimi("Pena", 3);
		
		if (ope3.GetJuuri().GetLapsiS("k").GetKaynnit() != 3 || ope3.GetJuuri().GetLapsiS("e").GetLapsia() != 2) {
			System.out.println("Testi 'opeta nimi' ei mennyt läpi");
			lapi = false;
			return;
		}
		
		Solmu testi = new Solmu();
		testi.SetKaynnit(5);
		testi.SetID(10);
		testi.OnkoJuuri(true);
		Solmu testi4 = new Solmu("varsi", testi);
		Solmu testi3 = new Solmu("kukka", testi);
	    if (!testi.ToString().equals("null:5:10:true:84:85:") || !testi3.ToString().equals("kukka:0:85:false:10:")) {
			System.out.println("Testi 'Solmu stringiksi' ei mennyt läpi");
			lapi = false;
			return;
	    }
	    
		Trie puu2 = new Trie(3);
		Solmu uusi = new Solmu();
		String rimpsu = ":5:10:true:";
		uusi.Parse(rimpsu, puu2);
	    if (uusi.GetID() != 10) {
			System.out.println("Testi 'Stringi solmuksi' ei mennyt läpi");
			lapi = false;
			return;
	    }
	    
	    Opetus ope = new Opetus(3, "testiNimet");
	    ope.lueTiedosto("testiNimet", 3);
	    ope.talleta("testiLukuKirjoitus");
	    Nimeaja ope2 = new Nimeaja("testiLukuKirjoitus", 3);
	    ope2.lueTiedosto(ope2.GetTiedosto());
	    if (ope2.GetJuuri().GetKaynnit() != 8) {
			System.out.println("Testi 'Lukeminen ja tallettaminen' ei mennyt läpi");
			lapi = false;
			return;
	    }
	    
		Nimeaja testi2 = new Nimeaja("Fi", 3);
		testi2.Opi(3, "Fi");
		String nimi = testi2.LuoUusi(5, 3);
		nimi = nimi.toLowerCase();
		for(int i = 0; i < nimi.length() - 2; i++) {
			testi2.SetNyt(testi2.GetJuuri().GetLapsiS(String.valueOf(nimi.charAt(i))));
			testi2.SetNyt(testi2.GetNyt().GetLapsiS(String.valueOf(nimi.charAt(i+1))));
			testi2.SetNyt(testi2.GetNyt().GetLapsiS(String.valueOf(nimi.charAt(i+2))));
		}
	}
	
	public boolean GetLapi() {
		return lapi;
	}
}

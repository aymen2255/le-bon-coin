package fr.treeptik.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import fr.treeptik.pojo.Annonce;
import fr.treeptik.pojo.User;

public class JSOUPUtil {
	public static List<Annonce> testJsoup(){
		Document doc;Document doc1;
		 int count=0;
		 List<Annonce> annonces= new ArrayList<Annonce>();
		try {
	 
			// need http protocol
			doc = Jsoup.connect("http://www.leboncoin.fr/locations/offres/provence_alpes_cote_d_azur/?f=a&th=1").get();
	 
			// get page title
			String title = doc.title();
			System.out.println("title : " + title);

			// get all links
			Elements links = doc.select("div.list-lbc a");
			for (Element link : links) {
				String lien= link.attr("href");
				doc1 = Jsoup.connect(lien).get();
				Elements liens = doc1.select("div.content");
				String description= liens.text();
				
				//System.out.println("description : " + liens.text());
				String prix = doc1.select("span.price").text();
				prix = prix.substring(0,prix.length()-2);
				prix = prix.replace("€", "").trim();
				 prix=prix.replaceAll(" ", "");
				 Integer price = Integer.parseInt(prix.trim());
				
				Annonce annonce = new Annonce(null, title, description, lien, price, count, null);
				annonces.add(annonce);
				//System.out.println("prix : " + prix);
				
				
				//System.out.println("\nlink : " + link.attr("href"));
				//System.out.println("text : " + link.text());
	 
			}
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return annonces;
	 
	  }
}
